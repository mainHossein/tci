package com.example.tcp.repository;

import com.example.tcp.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultRepository extends JpaRepository<Result, UUID> {
}
