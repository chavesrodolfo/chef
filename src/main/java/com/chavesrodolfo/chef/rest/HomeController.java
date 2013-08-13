package com.chavesrodolfo.chef.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping("/layout")
    public String getlayoutHome() {
        return "home/layout";
    }
}
