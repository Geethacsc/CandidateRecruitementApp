package com.capstone.CandidateRecruit.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    @Email
    private String userId;
    @NotBlank
    @Size(min=12,max = 20)
    private String password;
    @NotBlank
    @Size(min=12,max = 20)
    private String confirmPassword;
}
