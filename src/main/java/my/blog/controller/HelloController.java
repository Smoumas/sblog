package my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @ResponseBody
    @RequestMapping("/myblog")
    public String hello(){
        return "Welcome to my blog.";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
