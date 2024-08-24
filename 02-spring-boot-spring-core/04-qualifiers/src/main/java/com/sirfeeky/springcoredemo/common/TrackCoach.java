package com.sirfeeky.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Run hard 5 kilometer";
    }
}
