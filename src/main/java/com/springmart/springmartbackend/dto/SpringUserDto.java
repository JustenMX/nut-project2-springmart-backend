package com.springmart.springmartbackend.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SpringUserDto {

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
