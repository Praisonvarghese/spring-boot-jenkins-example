package com.codeconcepts.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/greet/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + " welcome to Coding Concepts";
    }
}
