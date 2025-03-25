package com.capstone.CandidateRecruit.service;

import com.capstone.CandidateRecruit.dto.CandidateDTO;
import com.capstone.CandidateRecruit.dto.UserDTO;
import com.capstone.CandidateRecruit.entity.GroupId;
import com.capstone.CandidateRecruit.entity.User;
import com.capstone.CandidateRecruit.exception.CustomUserException;
import com.capstone.CandidateRecruit.model.LoginResponse;
import com.capstone.CandidateRecruit.repo.UserDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDAO userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginResponse login(String userId, String password) {
        if(userId.isBlank() ||password.isBlank()){
            System.out.println("inside user null");
            throw new NullPointerException("username or password cannot be null");
        }
         User user=userRepo.findByUserIdAndPassword(userId,password);
         if(user==null)
             throw new CustomUserException("invalid user credentials");
         return new LoginResponse("User Login Success");
    }

    @Override
    public CandidateDTO updateProfile(CandidateDTO candidateDTO) {
        return null;
    }

    @Override
    public String register(UserDTO userDTO) {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword()))
            throw new CustomUserException("password doesn't match");
        try {
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setPassword(userDTO.getPassword());
            user.setGroupId(String.valueOf(GroupId.CANDIDATE));
            userRepo.save(user);
            return "User registered Successfully";
        }
        catch (DataIntegrityViolationException ex){
            System.out.println("inside duplicate user");
            ex.printStackTrace();
            throw new CustomUserException("user already exists");
        }
        catch (Exception exception){
            exception.printStackTrace();
            throw new CustomUserException("internal server error"+exception.getMessage());
        }
    }
}
