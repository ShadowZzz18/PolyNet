package com.polytech.polynet.api;

import com.polytech.polynet.business.AccountService;
import com.polytech.polynet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/loginUser")
    public boolean login(@RequestBody User user) {
        boolean verif = accountService.login(user.getUsername(), user.getPassword());

        return verif;
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        System.out.println("Register : " + user.getUsername());
        user.setEnabled(1);

        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);

        accountService.register(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        System.out.println(accountService.getUsers());
        return accountService.getUsers();
    }

}
