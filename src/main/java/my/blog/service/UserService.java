package my.blog.service;

import my.blog.domain.User;
import my.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    /**
     *
     * @param user
     * @return
     * 0 注册成功
     * 1 注册失败
     */
    public int insertUser(User user){
        User existUser = userMapper.getUserByUsername(user.getUsername());
        if (existUser == null) {
            userMapper.insertUser(user);
            return 0;
        }else{
            return 1;
        }
    }


    /**
     *
     * @param user
     * @return
     *
     */
    public User userLogin(User user){
        User existUser = userMapper.getUserByUsername(user.getUsername());
        if(existUser == null){
            return null;
        }
        if(existUser.getPassword().equals(user.getPassword())){
            return existUser;
        }
        return null;
    }

    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }

    public void deleteUser(String username){
        userMapper.deleteUser(username);
    }
}
