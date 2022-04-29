package com.example.frameworks.domain.core;

public class MalformedPayloadException extends DomainException {
    public MalformedPayloadException(String message) {
        super(message);
    }
}
