package com.springmart.springmartbackend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringUserUpdate {
    Long id;
    String email;
    String password;
    String firstName;
    String lastName;
    String address;
    String postalCode;
    String unitNo;
    boolean optMarketing;
    LocalDate joinDate;
}
