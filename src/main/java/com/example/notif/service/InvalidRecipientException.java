package com.example.notif.service;

public class InvalidRecipientException extends RuntimeException {

    public InvalidRecipientException(String message) {
        super(message);
    }
}
