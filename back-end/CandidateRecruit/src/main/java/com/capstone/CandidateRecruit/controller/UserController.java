package com.capstone.CandidateRecruit.controller;

import com.capstone.CandidateRecruit.dto.CandidateDTO;
import com.capstone.CandidateRecruit.dto.LoginRequest;
import com.capstone.CandidateRecruit.dto.UserDTO;
import com.capstone.CandidateRecruit.model.LoginResponse;
import com.capstone.CandidateRecruit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @CrossOrigin to allow all types of requests when connecting the api to angular front end
     */
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginDTO){
        return new ResponseEntity<>(userService.login(loginDTO.getUserId(),loginDTO.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO),HttpStatus.CREATED);
    }
}
