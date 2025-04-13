package org.example.binding;


import org.example.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author MirrorML
 * @date 2025/4/13
 * @description 映射器代理
 */

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -642454912998906586L;

    // 模拟sqlSession
    // 每个接口的方法对应一个sql执行等
    private SqlSession sqlSession;
    // 接口
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断是否是Object类中的方法
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
            // 核心代理
            if(args  == null){
                return sqlSession.selectOne(method.getName());
            }
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
