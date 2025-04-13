package org.example.binding;


import org.example.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author MirrorML
 * @date 2025/4/13
 * @description 映射器代理工厂
 */

public class MapperProxyFactory <T>{

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        // 创建代理对象
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        // 进行代理，返回代理对象
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
