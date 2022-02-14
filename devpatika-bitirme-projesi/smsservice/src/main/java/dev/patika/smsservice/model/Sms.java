package dev.patika.smsservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sms")
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long timestamp;
    private String ssid;
    private String phoneNo;
    private String message;
    private int creditScore;
    private double salary;
    private double creditLimit;

    public Sms(String s) {
        this.ssid = s;
    }
}
