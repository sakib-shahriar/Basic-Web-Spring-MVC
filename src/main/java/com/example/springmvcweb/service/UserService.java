package com.example.springmvcweb.service;

import com.example.springmvcweb.dao.UserDao;
import com.example.springmvcweb.dto.AuthenticationDTO;
import com.example.springmvcweb.dto.UserDTO;
import com.example.springmvcweb.model.User;
import com.example.springmvcweb.util.common.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.servlet.http.HttpServletRequest;

@Repository
public class UserService {
    @Autowired
    private UserDao userDao;
    public boolean authenticate(AuthenticationDTO authenticationDTO, HttpServletRequest request) {
        UserDTO userDTO = SessionUtil.getUserDTO(request);
        User user = this.userDao.isValidUser(authenticationDTO);
        boolean valid = user != null;
        userDTO.setUser(user);
        userDTO.setLoggedIn(valid);
        return valid;
    }

    public void logout(HttpServletRequest request) {
        UserDTO userDTO = SessionUtil.getUserDTO(request);
        userDTO.setUser(null);
        userDTO.setLoggedIn(false);
        SessionUtil.setUserDTO(request, userDTO);
    }

    public Boolean isUserLoggedIn(HttpServletRequest request) {
        UserDTO userDTO = SessionUtil.getUserDTO(request);
        return userDTO.isLoggedIn();
    }
}
