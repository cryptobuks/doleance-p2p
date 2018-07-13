package com.greenfoxacademy.chat.Controllers;

import com.greenfoxacademy.chat.Models.User;
import com.greenfoxacademy.chat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    LogController logController;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndex() {
        System.out.println(logController.writeLog("INFO", "/", "GET", "no data"));
        if (userService.countUser() > 0) {
            return "main";
        } else {
            return "register";
        }
    }

    @PostMapping("/register")
    public String register(@ModelAttribute String username) {
        if (username == null) {
            System.out.println(logController.writeLog("ERROR", "/register", "POST", "username=null"));
            return "redirect:register";
        } else {
            User newUser = new User(username);
            userService.saveUser(newUser);
            return "redirect:main";
        }
    }

    @GetMapping("/main")
    public String chat(Model model) {
        System.out.println(logController.writeLog("INFO", "/main", "GET", "no data"));
        if (userService.countUser() > 0) {
            User currentUser = userService.getUserById(1L);
            model.addAttribute("username", currentUser);
        }
        return "main";
    }
}
