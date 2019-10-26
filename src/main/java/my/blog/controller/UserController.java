package my.blog.controller;

import my.blog.domain.Blog;
import my.blog.domain.User;
import my.blog.service.BlogService;
import my.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

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
    public String login(User user, Model model){
        User existUser = userService.userLogin(user);
        if(existUser != null ){
            List<Blog> blogList = blogService.getAllBlogs(existUser.getId());
            model.addAttribute("list",blogList);
            return "list";
        }else{
            return "error";
        }
    }
}
