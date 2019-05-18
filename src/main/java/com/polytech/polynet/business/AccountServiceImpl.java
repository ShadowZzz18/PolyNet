package com.polytech.polynet.business;

import com.polytech.polynet.model.User;
import com.polytech.polynet.repository.AccountRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void register(User user) {
        accountRepository.register(user);
    }

    @Override
    public List<User> getUsers() {
        return accountRepository.findAllUsers();
    }

    @Override
    public boolean login(String username, String password) {
        return accountRepository.login(username, password);
    }

}
