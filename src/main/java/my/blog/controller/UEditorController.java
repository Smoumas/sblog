package my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
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
     * @param content
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String saveBlog(@RequestParam String content){
        //ClassUtils和ResourceUtils获取路径有什么不同
        String resourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String  ID = "1";
        File file = new File(resourcePath+"/templates/blogs/"+ID);
        if (!file.exists()){
            file.mkdir();
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = simpleDateFormat.format(date);
        try{
                BufferedWriter blog = new BufferedWriter(new FileWriter(resourcePath+"/static/blogs/"+ID+"/"+fileName+".html"));
            blog.write(content);
                blog.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(content);
        return "success";
    }

    //使用数据库的方式，将页面内容保存至数据库中，编辑时直接从数据库中获取。避免要从HTML文件中获取数据

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editBlog(@RequestParam String content){

        return "success";
    }
}
