package com.example.notif.activity;

import com.example.notif.activity.payload.Order;
import io.temporal.spring.boot.ActivityImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "notif-tq")
public class OrderActivityImpl implements OrderActivity {

    private static final Logger log = LoggerFactory.getLogger(OrderActivityImpl.class);

    @Override
    public void charge(Order order) {
        log.info("Charging order {} for {} cents", order.id(), order.amountCents());
    }

    @Override
    public void ship(Order order) {
        log.info("Shipping order {}", order.id());
    }
}
