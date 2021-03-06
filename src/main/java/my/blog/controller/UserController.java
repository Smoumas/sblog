package my.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import my.blog.aspect.anno.SysLogAnno;
import my.blog.domain.Blog;
import my.blog.domain.User;
import my.blog.service.BlogService;
import my.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/signUp")
    public String signUp(User user){
        int result = userService.insertUser(user);
        if(result == 0) {
            User existUser = userService.getUserByUsername(user.getUsername());
            return "redirect:/blogs/"+existUser.getId();
        }else{
            return "error";
        }

    }

    @SysLogAnno("test")
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User existUser = userService.userLogin(user);
        if(existUser != null ){
            session.setAttribute("ID",existUser.getId());
            session.setAttribute("name",existUser.getUsername());
            session.setAttribute("page",1);
            return "redirect:/blogs/"+existUser.getId();
        }else{
            return "error";
        }
    }

    @RequestMapping("/logout")
    public String loginOut(HttpSession session){
        if(session.getAttribute("ID") != null){
            session.removeAttribute("ID");
        }
        if(session.getAttribute("name") != null){
            session.removeAttribute("name");
        }
        return "redirect:/blogs/1";
    }
}
