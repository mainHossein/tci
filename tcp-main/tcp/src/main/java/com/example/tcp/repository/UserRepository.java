package com.example.tcp.repository;

import com.example.tcp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNationalCode(long nationalCode);

    boolean existsByNationalCode(long nationalCode);
}
