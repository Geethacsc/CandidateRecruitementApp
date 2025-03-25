package com.capstone.CandidateRecruit.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    @Size(min = 3,max = 20)
    @NotBlank
    private String firstName;

    private String middleName;
    @Size(min=3,max = 20)
    @NotBlank
    private String lastName;
    @Email
    @NotBlank
    private String emailId;
    @Size(min=10,max=13,message="enter a valid mobile no")
    private String mobileNo;
    @NotBlank
    private String qualification;
    private String organization;
    @NotEmpty
    private int noticePeriod;
    @NotEmpty
    private double currentCTC;
    @NotEmpty
    @NumberFormat
    private float experience;


}
