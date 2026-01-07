package com.example.tcp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long nationalCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private String zipCode;
    @Version
    private int version;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;
}
