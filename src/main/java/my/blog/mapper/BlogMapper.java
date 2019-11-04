package my.blog.mapper;

import my.blog.domain.Blog;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface BlogMapper {

    @Select("SELECT * FROM blogs WHERE uid = #{uid} ORDER BY createTime DESC")
    @Results({@Result(property = "ID", column = "id"),@Result(property = "uid", column = "uid"),@Result(property = "content",column = "content")})
    List<Blog> getAllBlogs(int uid);

    @Insert("INSERT INTO blogs(uid,content,title,createTime) VALUES(#{uid},#{content},#{title},#{createTime})")
    void insertBlog(Blog blog);

    @Select("SELECT * FROM blogs WHERE id = #{id}")
    @Results({@Result(property = "ID", column = "id"),@Result(property = "uid", column = "uid"),@Result(property = "content",column = "content")})
    Blog getBlogByID(int ID);

    @Delete("DELETE FROM blogs WHERE id = #{id}")
    void deleteBlog(int ID);

    @Update("UPDATE blogs SET content=#{content},createTime=#{createTime},title=#{title} WHERE id=#{ID}")
    void updateBlog(Blog blog);
}
