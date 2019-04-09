package my.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@Controller
@RequestMapping("/editor")
public class UEditorController {

    @RequestMapping("/ueditor")
    public String edit(){
        return "test";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String content(@RequestParam String content){
        System.out.println(content);
        return "success";
    }
}
