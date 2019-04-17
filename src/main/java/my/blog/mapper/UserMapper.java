package my.blog.mapper;

import my.blog.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({@Result(property = "id", column = "id"),@Result(property = "username", column = "username"),@Result(property = "password",column = "password")
            ,@Result(property = "email",column = "email")})
    List<User> getUsers();

    @Insert("INSERT INTO user(username,password,email) VALUES(#{username},#{password},#{email})")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results({@Result(property = "id", column = "id"),@Result(property = "username", column = "username"),@Result(property = "password",column = "password")
            ,@Result(property = "email",column = "email")})
    User getUserByUsername(String username);

    @Delete("DELETE FROM user WHERE username = #{username}")
    void deleteUser(String username);
}
