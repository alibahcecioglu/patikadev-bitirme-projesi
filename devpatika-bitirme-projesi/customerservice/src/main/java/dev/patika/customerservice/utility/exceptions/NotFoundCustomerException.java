package dev.patika.customerservice.utility.exceptions;

public class NotFoundCustomerException extends RuntimeException {
    public NotFoundCustomerException(String message) {
        super(message);
    }
}
