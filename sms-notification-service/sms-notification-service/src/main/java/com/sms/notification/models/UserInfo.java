package com.sms.notification.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;

    @Size(min=1,max = 40,message = "Enter the name as per policy(minimum 1 letter and maximum 40 letters)")
    @NotNull(message = "name is mandatory field")
    private String name;

    @Email(message = "email is mandatory/valid field")
    private String email;
    @NotNull(message = "city is mandatory field")
    private String city;
    @NotNull(message = "phone is mandatory field")
    private String phone;
    @NotNull(message = "temperature is mandatory field")
    private Integer temperature;

}
