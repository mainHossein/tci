package com.example.tcp.dto;

import com.example.tcp.entity.User;

public interface Mapper {
    public UserDTO mapToDTO(User user);
    public User mapToUser(UserDTO userDTO);
}
