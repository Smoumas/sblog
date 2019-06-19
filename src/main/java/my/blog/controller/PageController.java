package my.blog.controller;

import my.blog.domain.Blog;
import my.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/signUp")
    public String signUp(){
        return "sign-up";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response){
        List<Blog> blogList = blogService.getAllBlogs(1);
        model.addAttribute("list",blogList);
        return "list";
    }

}
