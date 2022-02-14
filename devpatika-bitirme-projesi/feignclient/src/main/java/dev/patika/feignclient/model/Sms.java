package dev.patika.feignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sms {
    private long id;
    private Long timestamp;
    private String ssid;
    private String phoneNo;
    private String message;
    private int creditScore;
    private double salary;
    private double creditLimit;
    private boolean creditStatus;

}
