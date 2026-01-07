package com.example.tcp.controller;

import com.example.tcp.Meta;
import com.example.tcp.Result;
import com.example.tcp.Status;
import com.example.tcp.dto.UserDTO;
import com.example.tcp.repository.ResultRepository;
import com.example.tcp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("service.tci.ir/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ResultRepository resultRepository;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("{nationalCode}" )
    public ResponseEntity<Result> getUserByNationalCode(@PathVariable long nationalCode) {
        boolean exists = userService.existsUserByNationalCode(nationalCode);
        UserDTO user = null;
        Status status = new Status();
        Meta meta = new Meta();
        Result result = new Result();
        Result newResult = new Result();
        if (exists) {
            user = userService.getUserByNationalCode(nationalCode);
            status.setCode(200);
            status.setMessage("OK!");
            newResult.setMeta(meta);
            newResult.setUser(user);
            newResult.setStatus(status);
            newResult.setUserNationalId(nationalCode);
            Result savedResult = resultRepository.save(newResult);
            savedResult.getMeta().setTransactionId(savedResult.getId());
            return ResponseEntity.ok(savedResult);
        }else  {
            status.setCode(404);
            status.setMessage("Not Found!");
            newResult.setMeta(meta);
            newResult.setUser(user);
            newResult.setStatus(status);
            newResult.setUserNationalId(null);
            Result savedResult = resultRepository.save(newResult);
            savedResult.getMeta().setTransactionId(savedResult.getId());
            return new ResponseEntity<>(savedResult, HttpStatus.NOT_FOUND);
        }
    }
}
