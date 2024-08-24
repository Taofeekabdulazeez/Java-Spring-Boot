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
    private Coach anotherCoach;


//    Define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach thecoach,
                          @Qualifier("trackCoach") Coach theanothercoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = thecoach;
        anotherCoach = theanothercoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return  "Compare beans: mycoach == anothercoach "+ (myCoach == anotherCoach);
    }
}
