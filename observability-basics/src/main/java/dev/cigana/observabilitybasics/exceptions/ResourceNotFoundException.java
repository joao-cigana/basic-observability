package dev.cigana.observabilitybasics.exceptions;

public class ResourceNotFoundException extends DomainBaseException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
