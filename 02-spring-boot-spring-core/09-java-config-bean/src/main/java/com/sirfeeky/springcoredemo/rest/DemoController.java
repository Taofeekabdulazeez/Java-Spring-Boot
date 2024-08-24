package com.sirfeeky.springcoredemo.rest;

import com.sirfeeky.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;


//    Define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach thecoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = thecoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
