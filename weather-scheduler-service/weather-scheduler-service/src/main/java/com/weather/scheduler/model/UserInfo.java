package com.weather.scheduler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;
    @Column(name = "temperature")
    private Integer temperature;
    @Column(name = "is_sms")
    private Boolean smsEnabled;

    @Column(name = "is_email")
    private Boolean emailEnabled;

    @Column(name = "is_app")
    private Boolean appEnabled;

}
