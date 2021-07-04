package com.example.demo.CompleteOrder;

public class CompleteOrderNotFoundException extends RuntimeException {
    public CompleteOrderNotFoundException(Long id) {
        super("Could not find completeOrder " + id);
    }
}
