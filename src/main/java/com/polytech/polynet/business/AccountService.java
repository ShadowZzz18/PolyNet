package com.polytech.polynet.business;

import com.polytech.polynet.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService {

    void register(User user);

    List<User> getUsers();

    boolean login(String username, String password);

}
