package org.example.session.defaults;


import org.example.binding.MapperRegistry;
import org.example.session.SqlSession;
import org.example.session.SqlSessionFactory;

/**
 * @author MirrorML
 * @date 2025/4/13
 * @description 默认的SqlSession工厂
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}

