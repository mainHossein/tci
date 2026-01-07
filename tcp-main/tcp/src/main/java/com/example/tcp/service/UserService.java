package com.example.tcp.service;

import com.example.tcp.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getUsers();
    public UserDTO getUserById(int id);
    public UserDTO getUserByNationalCode(long nationalCode);
    public boolean existsUserByNationalCode(long nationalCode);
}
