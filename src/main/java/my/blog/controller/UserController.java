package my.blog.controller;

import my.blog.domain.User;
import my.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public String signup(User user){
        int result = userService.insertUser(user);
        if(result == 0) {
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/login")
    public String login(User user){
        int result = userService.userLogin(user);
        if(result == 0 ){
            return "success";
        }else{
            return "error";
        }
    }
}
