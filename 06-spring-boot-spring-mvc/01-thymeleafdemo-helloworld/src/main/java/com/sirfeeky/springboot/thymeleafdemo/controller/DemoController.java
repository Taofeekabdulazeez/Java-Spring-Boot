package com.sirfeeky.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";
    }
}
