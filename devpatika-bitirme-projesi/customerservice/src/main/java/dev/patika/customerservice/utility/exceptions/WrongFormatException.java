package dev.patika.customerservice.utility.exceptions;

public class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message) {
        super(message);
    }
}
