package com.example.notif.activity.options;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;

import java.time.Duration;

public final class NotifOptions {

    public static final ActivityOptions DEFAULT = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(30))
            .setRetryOptions(RetryOptions.newBuilder()
                    .setInitialInterval(Duration.ofSeconds(2))
                    .setMaximumAttempts(3)
                    .setDoNotRetry("INVALID_RECIPIENT")
                    .build())
            .build();

    public static final ActivityOptions CRITICAL = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(30))
            .setRetryOptions(RetryOptions.newBuilder()
                    .setInitialInterval(Duration.ofSeconds(2))
                    .setMaximumAttempts(10)
                    .setDoNotRetry("INVALID_RECIPIENT")
                    .build())
            .build();

    private NotifOptions() {
    }
}
