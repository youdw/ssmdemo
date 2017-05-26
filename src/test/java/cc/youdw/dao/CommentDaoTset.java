package cc.youdw.dao;

import cc.youdw.common.BaseTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by youdw on 2017/4/26.
 */
public class CommentDaoTset extends BaseTest{

    @Autowired
    private CommentDao commentDao;

    @Test
    public void queryTest(){
        List<Comment> comments = commentDao.queryList("fa941a56263811e7979f00163e1038f9");
        String jsonObject = JSON.toJSONString(comments);
        System.out.println(jsonObject+">>>");
    }
}
