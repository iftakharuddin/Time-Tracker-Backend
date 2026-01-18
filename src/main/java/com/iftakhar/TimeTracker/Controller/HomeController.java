package com.iftakhar.TimeTracker.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

    @GetMapping("/")
    private String HomeMessage() {
        return "Welcome to Time Tracker Application!";
    }
}
