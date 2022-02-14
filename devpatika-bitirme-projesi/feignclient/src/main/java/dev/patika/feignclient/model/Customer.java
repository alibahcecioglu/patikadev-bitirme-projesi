package dev.patika.feignclient.model;

import dev.patika.feignclient.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long id;
    private String fullName;
    private String ssid;
    private String email;
    private String phoneNo;
    private double salary;
    private Gender gender;
}
