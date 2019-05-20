package com.polytech.polynet.repository;

import com.polytech.polynet.model.User;

import java.util.List;

public interface AccountRepository {

    List<User> findAllUsers();

    void register(User user);

}
