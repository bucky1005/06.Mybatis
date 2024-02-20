package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {
        /* 메모. session은 service와 db 사이에서 sql쿼리를 전달하는 통로로 사용되므로 service 계층에서 호출 */
        /* 메모. sqlSessionFactory가 한번도 생성된적 없을 때에만 실행, 해당 메소드는 Service ㄱㅖ층에서 호출됨
            Factorysms config파일 정보를 가지고 Session을 build 할 수 있음
         */
        if (sqlSessionFactory == null) {
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);          // 설계도를 가지고 오는 역할
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);      // 설계도 가져와서 만들라고 함
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}
