package com.polytech.polynet.business;

import java.util.List;

public interface AccountService {

    void register(User user);

    List<User> getUsers();

}
