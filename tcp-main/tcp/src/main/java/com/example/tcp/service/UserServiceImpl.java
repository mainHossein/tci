package com.example.tcp.service;

import com.example.tcp.dto.Mapper;
import com.example.tcp.dto.MapperImpl;
import com.example.tcp.dto.UserDTO;
import com.example.tcp.entity.User;
import com.example.tcp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Mapper mapper = new MapperImpl();
    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(mapper.mapToDTO(user)));
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(int id) {
        return mapper.mapToDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserDTO getUserByNationalCode(long nationalCode) {
        return mapper.mapToDTO(userRepository.findByNationalCode(nationalCode));
    }

    @Override
    public boolean existsUserByNationalCode(long nationalCode) {
        return userRepository.existsByNationalCode(nationalCode);
    }
}
