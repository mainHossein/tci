package com.example.tcp.dto;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserDTO {
    private long nationalCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private String zipCode;
}
