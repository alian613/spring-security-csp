package com.alian.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
