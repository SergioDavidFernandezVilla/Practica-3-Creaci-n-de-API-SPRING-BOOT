package com.example.create_api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/home")
    public String getHome() {
        return "Hola";
    }
    
}
