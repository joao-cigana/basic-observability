package dev.cigana.observabilitybasics.exceptions;

public class DomainBaseException extends RuntimeException{

    public DomainBaseException(String message) {
        super(message);
    }

    public DomainBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
