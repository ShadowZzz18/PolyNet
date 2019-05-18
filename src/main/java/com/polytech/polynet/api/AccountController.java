package com.polytech.polynet.api;

import com.polytech.polynet.business.AccountService;
import com.polytech.polynet.business.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public void log(String username, String password) {

    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        System.out.println(user);
        accountService.register(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        System.out.println(accountService.getUsers());
        return accountService.getUsers();
    }

}
