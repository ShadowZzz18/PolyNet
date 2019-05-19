package com.polytech.polynet.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private int authority;

    public Authority() {}

    public Authority(String username, int authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

}
