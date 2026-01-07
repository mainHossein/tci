package com.example.tcp;

import com.example.tcp.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Result {
    @Transient
    private Meta meta;
    @Transient
    private UserDTO user;
    private Status status;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_id")
    private UUID id;
    @JsonIgnore
    private Long userNationalId;
    @JsonIgnore
    @CreationTimestamp
    private Timestamp created;

}
