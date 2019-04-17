package my.blog.controller;

import my.blog.config.ServerConfig;
import my.blog.domain.Blog;
import my.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private ServerConfig serverConfig;  //serverConfig用于获取服务器IP和端口

    @Autowired
    private BlogService blogService;

    /**
     * 展示用户blog
     * @param uid    用户ID
     * @param model
     * @return
     */
    @RequestMapping("/{uid}")
    public String listBlogs(@PathVariable int uid,Model model){
//        String resourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        File file = new File(resourcePath+"static/blogs/"+ID);
//        File []blogs = file.listFiles();
//        for(File blog:blogs){
//            String fileName = blog.getName();
//            String []results = resourcePath.split("classes");
//            String filePath = serverConfig.getURL()+results[1]+"/blogs/"+ID+"/"+fileName;
//            fileMap.put(fileName,filePath);
//        }

        List<Blog> blogList = blogService.getAllBlogs(uid);
        model.addAttribute("list",blogList);
        return "list";
    }

    @RequestMapping("/uid/{uid}")
    public String getAllBlog(@PathVariable int uid){
        List<Blog> blogList = blogService.getAllBlogs(uid);
        for(Blog blog:blogList){
            System.out.println(blog.getID()+":"+blog.getUid()+":"+blog.getContent());
        }
        return "success";
    }

    @RequestMapping("/blog/{ID}")
    public String getBlogByID(@PathVariable int ID,Model model){
        Blog blog = blogService.getBlogByID(ID);
        model.addAttribute("blog",blog);
        return "blog";
    }
}
