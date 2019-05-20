package com.polytech.polynet.business;

import com.polytech.polynet.model.User;

import java.util.List;

public interface AccountService {

    void register(User user);

    List<User> getUsers();

}
