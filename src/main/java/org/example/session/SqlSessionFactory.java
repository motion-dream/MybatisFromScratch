package org.example.session;

/**
 * @author MirrorML
 * @date 2025/4/13
 * @description
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
