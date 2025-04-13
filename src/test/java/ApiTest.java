import com.alibaba.fastjson.JSON;
import dao.IUserDao;
import org.example.binding.MapperProxyFactory;
import org.example.binding.MapperRegistry;
import org.example.session.SqlSession;
import org.example.session.SqlSessionFactory;
import org.example.session.defaults.DefaultSqlSession;
import org.example.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory(){
        // 1. 注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("dao");
        // 2. 从SqlSession工厂获取SqlSession
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 4. 测试验证
        String result = userDao.queryUserName();
        logger.info("测试结果:{}" , JSON.toJSONString(result));
    }
    @Test
    public void test_proxy_class(){
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                (((proxy, method, args) -> "你被代理来了"))
        );

        String result = userDao.queryUserName("");
        logger.info("测试结果:{}" , JSON.toJSONString(result));
    }
}
