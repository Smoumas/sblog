package my.blog.controller;

import my.blog.domain.Blog;
import my.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/editor")
public class UEditorController {

    @Autowired
    private BlogService blogService;

    /**
     * 访问test页面
     * @return
     */
    @RequestMapping("/ueditor")
    public String edit(){
        return "test";
    }

    /**
     * 获取上传的blog页面，并保存
     * @param
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String saveBlog(Blog blog, HttpSession session){
        //ClassUtils和ResourceUtils获取路径有什么不同
//        String resourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        int uid = (int)session.getAttribute("ID");
        blog.setUid(uid);
        blog.setCreateTime(new Date());
        blogService.insertBlog(blog);
        return "success";
    }

    @RequestMapping(value = "/update/{ID}",method = RequestMethod.POST)
    public String updateBlog(@PathVariable int ID , Blog blog,Model model){
        blog.setID(ID);
        blog.setCreateTime(new Date());
        blogService.updateBlog(blog);
        model.addAttribute("blog",blog);
        return "redirect:/blog/"+ID;
    }


    //编辑功能，从数据库中获取对应blog，并填充到textarea中
    @RequestMapping(value = "/edit/{ID}")
    public String editBlog(@PathVariable int ID, Model model){
        Blog blog = blogService.getBlogByID(ID);
        model.addAttribute("blog",blog);
        return "edit";
    }

    //删除功能，根据ID删除blog
    @RequestMapping(value = "/delete/{ID}")
    public String deleteBlog(@PathVariable int ID,Model model){
        Blog blog = blogService.getBlogByID(ID);
        int uid = blog.getUid();
        blogService.deleteBlog(ID);
        List<Blog> blogList = blogService.getAllBlogs(uid);
        model.addAttribute("list",blogList);
        return "list";
    }
}
