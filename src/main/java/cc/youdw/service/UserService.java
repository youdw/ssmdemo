package cc.youdw.service;

import cc.youdw.dao.UserDao;
import cc.youdw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by east on 16/9/20.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.getByConditions(null);
    }

}
