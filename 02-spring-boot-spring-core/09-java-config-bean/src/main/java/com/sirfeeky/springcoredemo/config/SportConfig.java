package com.sirfeeky.springcoredemo.config;

import com.sirfeeky.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public SwimCoach swimCoach(){
        return new SwimCoach();
    }
}
