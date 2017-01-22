

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
//读取spring-mvc的配置文件
@ContextConfiguration(locations = { "classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
//声明一个事务管理,对每个单元测试进行回滚，避免测试数据入库 ，如某些方法不需要回滚则在方法添加注解：@Rollback(false)
@Transactional
//applicationContext.xml中声明的事务管理器
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class BaseTest {
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception {
    }

}