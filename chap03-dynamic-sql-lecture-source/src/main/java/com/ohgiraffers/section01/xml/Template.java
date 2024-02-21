package com.ohgiraffers.section01.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /* 메모. session을 생성하기 위한 설계도 */

    /* 메모. DAO와 mapper의 경로가 일치해야하고 */
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return sqlSessionFactory.openSession();
    }
}
