package my.blog.service;

import my.blog.domain.Blog;
import my.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getAllBlogs(int uid){
        return blogMapper.getAllBlogs(uid);
    }

    public void insertBlog(Blog blog){
        blogMapper.insertBlog(blog);
    }

    public Blog getBlogByID(int ID){
        return blogMapper.getBlogByID(ID);
    }

    public void deleteBlog(int ID){
        blogMapper.deleteBlog(ID);
    }

    public void updateBlog(Blog blog){
        blogMapper.updateBlog(blog);
    }

}
