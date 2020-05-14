package com.example.springmvcweb.dto;

import com.example.springmvcweb.model.User;
import java.io.Serializable;


public class UserDTO implements Serializable {
    private User user;
    private boolean isLoggedIn;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
