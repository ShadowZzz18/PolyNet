package com.polytech.polynet.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/login")
    public String login() {
        return "/login.html";
    }

    @GetMapping("/")
    public String home() {
        return "/index.html";
    }

    @GetMapping("/creation")
    public String creation() {
        return "/creation.html";
    }

}
