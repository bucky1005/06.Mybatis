package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // inputStream이라는 설계도 가지고 build해라!
            SqlSession session = sqlSessionFactory.openSession(false);      // 쿼리가 드나드는 통로이자 실행하는 역할을 수행

            java.util.Date date = session.selectOne("mapper.selectNow");
            System.out.println("date = " + date);

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
