package dev.cigana.observabilitybasics.exceptions;

public class InvalidDataException extends DomainBaseException{

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
