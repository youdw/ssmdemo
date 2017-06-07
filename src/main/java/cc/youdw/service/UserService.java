package cc.youdw.service;

import cc.youdw.dao.UserDao;
import cc.youdw.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by east on 16/9/20.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

//    @Cacheable("usersCache")//缓存这个方法的结果
    public List<User> getUsers(){
        logger.info("=======");
        return userDao.getByConditions(null);
    }


    /**
     * 缓存查找的用户，key默认为id(默认基于方法的参数确定)
     * @param id
     * @return
     */
    @Cacheable("userCache")
    public User findOne(Integer id){
        return userDao.selectByPrimaryKey(id);
    }

    /**
     *  缓存新添加的用户，指定为user.id
     *  id < 10的关闭缓存
     *
     *  unless 和 condition 区别：
     *  unless 接收一个SPEL 表达式 返回false，阻止对象放入缓存,调方法的时候会在缓存中查找
     *  condition 接收一个SPEL 表达式 返回false，禁止缓存
     * @param user
     * @return
     */
    @CachePut(value = "userCache",key = "#result.id",condition = "#result.id >= 10")
    public User save(User user){
        if(userDao.insertSelective(user) > 0){
            return user;
        }else {
            return null;
        }
    }

    /**
     * 移除缓存条目
     * @param id
     * @return
     */
    @CacheEvict(value = "userCache")
    public boolean deleteOne(Integer id){
        if(userDao.deleteByPrimaryKey(id) > 0){
            return true;
        }else {
            return false;
        }
    }

}
