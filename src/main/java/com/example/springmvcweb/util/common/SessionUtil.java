package com.example.springmvcweb.util.common;

import com.example.springmvcweb.dto.UserDTO;
import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static UserDTO getUserDTO(HttpServletRequest request) {
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
        if (userDTO == null) {
            userDTO = new UserDTO();
            request.getSession().setAttribute("userDTO", userDTO);
        }
        return userDTO;
    }

    public static void setUserDTO(HttpServletRequest request, UserDTO userDTO) {
        request.getSession().setAttribute("userDTO", userDTO);
    }
}
