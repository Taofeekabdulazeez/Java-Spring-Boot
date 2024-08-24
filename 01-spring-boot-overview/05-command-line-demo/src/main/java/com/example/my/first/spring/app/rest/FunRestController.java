package com.example.my.first.spring.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${port.number}")
    private String portNumber;

    @GetMapping("/")
        public String sayHello(){

          return "Server listing to port: " + this.portNumber;
        }

        @GetMapping("/name")
    public String getName(){
        return "Taofeek";
        }

}



