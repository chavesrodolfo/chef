package com.chavesrodolfo.chef.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String getlayoutIndex() {
        return "index";
    }

}
