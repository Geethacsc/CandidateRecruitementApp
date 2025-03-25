package com.capstone.CandidateRecruit.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandidateConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }


}
