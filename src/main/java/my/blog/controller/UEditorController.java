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
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String saveBlog(Blog blog){
        //ClassUtils和ResourceUtils获取路径有什么不同
//        String resourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        int uid = 1;
        blog.setUid(uid);
        blog.setCreateTime(new Date());
        //blog.setContent(content);
//        System.out.println(blog.getTitle());
//        System.out.println(blog.getContent());
        blogService.insertBlog(blog);
//        File file = new File(resourcePath+"/templates/blogs/"+ID);
//        if (!file.exists()){
//            file.mkdir();
//        }
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String fileName = simpleDateFormat.format(date);
//        try{
//                BufferedWriter blogHTML = new BufferedWriter(new FileWriter(resourcePath+"/static/blogs/"+ID+"/"+fileName+".html"));
//                blogHTML.write(content);
//                blogHTML.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "success";
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
    public String deleteBlog(@PathVariable int ID){
        blogService.deleteBlog(ID);
        return "success";
    }
}
