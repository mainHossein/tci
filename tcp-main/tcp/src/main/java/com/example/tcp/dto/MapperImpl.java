package com.example.tcp.dto;

import com.example.tcp.entity.User;

public class MapperImpl implements Mapper {
    @Override
    public UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setNationalCode(user.getNationalCode());
        userDTO.setZipCode(user.getZipCode());
        return userDTO;
    }

    @Override
    public User mapToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBirthDate(userDTO.getBirthDate());
        user.setNationalCode(userDTO.getNationalCode());
        user.setZipCode(userDTO.getZipCode());
        return user;
    }
}
