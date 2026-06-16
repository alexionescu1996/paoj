package com.example.notif.config;

import org.springframework.context.annotation.Configuration;

/**
 * Worker + task-queue registration is driven by the temporal-spring-boot-starter.
 * Workers are declared in application.yml under spring.temporal.workers.
 * NotifActivityImpl and OrderActivityImpl carry @ActivityImpl(taskQueues = "notif-tq"),
 * OrderWorkflowImpl and PaymentWorkflowImpl carry @WorkflowImpl(taskQueues = "notif-tq"),
 * so the starter wires them into the "notif-tq" worker automatically.
 */
@Configuration
public class TemporalConfig {
}
