package com.polytech.polynet;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("test2");
        System.out.println(hash);
    }
}
