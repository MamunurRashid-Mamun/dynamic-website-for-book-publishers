package com.bookpublisher.bookpublisher.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeConroller {
    @RequestMapping("/")
    public String showHome(){
        return "login";
    }
}
