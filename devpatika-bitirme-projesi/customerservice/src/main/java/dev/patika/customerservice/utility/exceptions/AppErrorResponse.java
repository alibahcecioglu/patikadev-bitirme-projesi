package dev.patika.customerservice.utility.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
