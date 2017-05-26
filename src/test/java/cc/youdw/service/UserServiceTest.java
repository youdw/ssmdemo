package cc.youdw.service;

import cc.youdw.common.BaseTest;
import cc.youdw.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by youdw on 2017/4/19.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){
        List<User> l = userService.getUsers();

    }
}
