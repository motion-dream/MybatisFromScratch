package org.example.session.defaults;


import org.example.binding.MapperRegistry;
import org.example.session.SqlSession;

/**
 * @author MirrorML
 * @date 2025/4/13
 * @description SqlSession默认实现类
 */

public class DefaultSqlSession  implements SqlSession {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法："+ statement + "入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
