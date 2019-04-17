package my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/signUp")
    public String signUp(){
        return "sign-up";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
