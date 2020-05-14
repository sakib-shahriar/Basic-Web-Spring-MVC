package com.example.springmvcweb.controller;

import com.example.springmvcweb.dto.AuthenticationDTO;
import com.example.springmvcweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return this.userService.isUserLoggedIn(request) ? "redirect:/home" : "redirect:/login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request, @RequestParam(name = "loggedIn", required = false) Boolean loggedIn, Model model) {
        if(!this.userService.isUserLoggedIn(request)) {
            return "redirect:/login";
        }
        if(loggedIn != null && loggedIn) {
            model.addAttribute("message", "Login successful");
        }
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        if(this.userService.isUserLoggedIn(request)) {
            return "redirect:/home";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView authenticate(@ModelAttribute AuthenticationDTO authenticationDTO, HttpServletRequest request) {
        if(!authenticationDTO.isEmailValid()) {
            RedirectView redirectView = new RedirectView("/error", true);
            redirectView.addStaticAttribute("message", "Invalid email address");
            return redirectView;
        }
        else {
            Boolean validUser = this.userService.authenticate(authenticationDTO, request);
            String url = validUser ? "/home" : "/error";
            RedirectView redirectView = new RedirectView(url, true);
            redirectView.addStaticAttribute("loggedIn", validUser);
            return redirectView;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        this.userService.logout(request);
        return "redirect:/login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String loginError(@RequestParam(name = "message", required = false) String message, Model model) {
        message = message != null ? message : "Log in failed";
        model.addAttribute("message", message);
        return "error";
    }
}
