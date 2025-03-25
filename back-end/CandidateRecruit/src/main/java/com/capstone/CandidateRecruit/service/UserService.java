package com.capstone.CandidateRecruit.service;

import com.capstone.CandidateRecruit.dto.CandidateDTO;
import com.capstone.CandidateRecruit.dto.UserDTO;
import com.capstone.CandidateRecruit.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    LoginResponse login(String userId, String password);
    CandidateDTO updateProfile(CandidateDTO candidateDTO);
    String register(UserDTO userDTO);
}
