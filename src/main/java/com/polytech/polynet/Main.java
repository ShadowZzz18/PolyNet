package com.polytech.polynet;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("admin");
        System.out.println(hash);
    }
}
