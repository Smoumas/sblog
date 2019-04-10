package my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/blogs")
public class BlogController {

    @RequestMapping("/{ID}")
    public String listBlogs(@PathVariable String ID,Model model){
        String resourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        Map<String,String> fileMap = new HashMap<String,String>();
        File file = new File(resourcePath+"static/blogs/"+ID);
        File []blogs = file.listFiles();
        for(File blog:blogs){
            String fileName = blog.getName();
            String []results = resourcePath.split("classes");
            String filePath = results[1]+"/blogs/"+ID+"/"+fileName;
            System.out.println(filePath);
            fileMap.put(fileName,filePath);
        }
        model.addAttribute("map",fileMap);
        return "list";
    }
}
