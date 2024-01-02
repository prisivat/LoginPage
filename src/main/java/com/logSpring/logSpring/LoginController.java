package com.logSpring.logSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(String username, String password, Model model) {
        List<LoginUser> logUsers = addNewUser();
        LoginUser validUser = logUsers.stream().filter(i->i.getUserName().equals(username)
                && i.getPassword().equals(password))
                .findFirst().orElse(null);
        if (Objects.nonNull(validUser)) {
            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
    public List<LoginUser> addNewUser(){
        List<LoginUser> logUSers = new ArrayList<>();
        LoginUser logUser = new LoginUser("Priya", "123Abc");
        LoginUser logUser1 = new LoginUser("Swetha", "swe123");
        LoginUser logUser2 = new LoginUser("Padmanaban", "Padm123");
        LoginUser logUser3 = new LoginUser("HariNa", "Har123");
        LoginUser logUser4 = new LoginUser("Makesh", "Mak123");
        logUSers.add(logUser);
        logUSers.add(logUser1);
        logUSers.add(logUser2);
        logUSers.add(logUser3);
        logUSers.add(logUser4);


        return logUSers;
    }


}