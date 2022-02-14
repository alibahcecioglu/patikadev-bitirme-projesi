package dev.patika.customerservice.utility.exceptions;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
