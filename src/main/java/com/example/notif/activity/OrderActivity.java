package com.example.notif.activity;

import com.example.notif.activity.payload.Order;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface OrderActivity {

    void charge(Order order);

    void ship(Order order);
}
