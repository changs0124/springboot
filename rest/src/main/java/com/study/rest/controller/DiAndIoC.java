package com.study.rest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiAndIoC {

    @GetMapping("/di")
    public Object di() {
        return null;
    }
}
