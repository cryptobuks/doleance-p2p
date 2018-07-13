package com.greenfoxacademy.chat.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    LogController logController;

    @GetMapping("/")
    public String getIndex() {
        System.out.println(logController.writeLog("INFO", "/", "GET", "no data"));
        return "index";
    }
}
