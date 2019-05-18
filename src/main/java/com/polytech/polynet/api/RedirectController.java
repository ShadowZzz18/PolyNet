package com.polytech.polynet.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/test")
    public String login() {
        return "/login.html";
    }

}
