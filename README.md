# notif-temporal

A Spring Boot 3 + Temporal Java SDK sample demonstrating a clean notification
architecture: plain Spring service, thin activity wrapper, workflow-side helper
that swallows non-critical notif failures, and two example workflows.

## Architecture

```
            +----------------------------+
            |  Workflow (Order/Payment)  |
            +-------------+--------------+
                          |
                          | new NotifHelper([options])
                          v
            +----------------------------+
            |        NotifHelper         |   workflow-side
            |  - try { stub.sendNotif }  |   (not a Spring bean)
            |  - catch ActivityFailure   |
            |  - swallow + log           |
            +-------------+--------------+
                          |  Workflow.newActivityStub(NotifActivity.class, opts)
                          v
            +----------------------------+
            |       NotifActivity        |   @ActivityInterface
            |    sendNotif(payload)      |
            +-------------+--------------+
                          |
                          v
            +----------------------------+
            |     NotifActivityImpl      |   @Component @ActivityImpl
            |  catch InvalidRecipient -> |
            |  ApplicationFailure(       |
            |  "INVALID_RECIPIENT", NR)  |
            +-------------+--------------+
                          | service.send(payload)
                          v
            +----------------------------+
            |    NotificationService     |   plain @Service
            |  switch(type) ->           |   NO io.temporal.* imports
            |    sendEmailInternal       |
            |    sendInAppInternal       |
            +----------------------------+
```

`NotificationPayload` is a single record carrying everything any notification
type needs. Factory methods `NotificationPayload.email(...)` and
`NotificationPayload.inApp(...)` are the only construction points used in
workflows.

## Layering rules enforced

- `service/` is pure Spring — no `io.temporal.*` imports.
- Workflows do not inject Spring beans. They instantiate `NotifHelper` with
  `new` and acquire other activity stubs via `Workflow.newActivityStub`.
- No method takes more than 3 parameters; anything wider goes through a record.
- Payload construction in workflow code goes exclusively through the static
  factories on `NotificationPayload`.

## Activity options

`NotifOptions` exposes two presets:

- `DEFAULT`: 30s start-to-close, 3 attempts, 2s initial interval,
  `setDoNotRetry("INVALID_RECIPIENT")`.
- `CRITICAL`: same shape with 10 attempts.

`InvalidRecipientException` is translated by the activity into a non-retryable
`ApplicationFailure` of type `INVALID_RECIPIENT`. `NotificationDeliveryException`
bubbles up so Temporal retries per the configured policy.

## Project layout

```
src/main/java/com/example/notif/
  NotifApplication.java
  service/
    NotificationService.java
    InvalidRecipientException.java
    NotificationDeliveryException.java
  activity/
    NotifActivity.java
    NotifActivityImpl.java
    OrderActivity.java
    OrderActivityImpl.java
    options/NotifOptions.java
    payload/
      NotificationPayload.java
      NotificationType.java
      Order.java
      Payment.java
  workflow/
    OrderWorkflow.java
    OrderWorkflowImpl.java
    PaymentWorkflow.java
    PaymentWorkflowImpl.java
    helper/NotifHelper.java
  config/TemporalConfig.java
```

## Build

Requires JDK 21 and Maven 3.9+.

```
mvn clean test           # run unit tests (no Temporal server needed)
mvn spring-boot:run      # run the worker against a local Temporal server
```

## Run the worker + trigger a workflow

1. Start a local Temporal dev server in another terminal:

   ```
   temporal server start-dev
   ```

   (See https://docs.temporal.io/cli for install instructions.)

2. Start the Spring Boot worker:

   ```
   mvn spring-boot:run
   ```

   The starter reads `application.yml` and brings up one worker on task queue
   `notif-tq`, registering both activity impls and both workflow impls via
   their `@ActivityImpl` / `@WorkflowImpl` annotations.

3. Trigger a workflow execution. Either use the `temporal` CLI:

   ```
   temporal workflow start \
     --task-queue notif-tq \
     --type OrderWorkflow \
     --workflow-id order-demo-1 \
     --input '{"id":"o-1","userId":"user-1","amountCents":1999}'

   temporal workflow start \
     --task-queue notif-tq \
     --type PaymentWorkflow \
     --workflow-id payment-demo-1 \
     --input '{"id":"p-1","userEmail":"alice@example.com","amountCents":4200}'
   ```

   or call from your own `WorkflowClient` code — the starter exposes
   `WorkflowClient` as a Spring bean.

## Tests

- `NotificationServiceTest` — plain JUnit; covers EMAIL and IN_APP routing
  and bad-recipient rejection. No Temporal classes touched.
- `NotifActivityImplTest` — Mockito; verifies `InvalidRecipientException`
  becomes an `ApplicationFailure` of type `INVALID_RECIPIENT` (non-retryable)
  and that `NotificationDeliveryException` bubbles up.
- `OrderWorkflowImplTest` — uses Temporal's `TestWorkflowExtension`; mocks
  `NotifActivity` to fail with a non-retryable `ApplicationFailure` and
  verifies the workflow still calls `OrderActivity.charge` and
  `OrderActivity.ship`.

Run tests:

```
mvn test
```

## Defaults / notes

- Temporal target is `127.0.0.1:7233`, namespace `default`. Override via
  `spring.temporal.connection.target` / `spring.temporal.namespace`.
- `NotificationService` mocks delivery with log statements.
- `OrderActivity` is a stubbed sample (charge/ship just log) so the project
  is self-contained.
- The pre-existing `org.example.*` classes in this repo are unrelated course
  exercises and left in place.
