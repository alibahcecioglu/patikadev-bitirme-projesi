package dev.patika.applyservice.model;

import dev.patika.applyservice.model.enums.Gender;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
    @Enumerated(EnumType.STRING)
    private Gender gender;
}