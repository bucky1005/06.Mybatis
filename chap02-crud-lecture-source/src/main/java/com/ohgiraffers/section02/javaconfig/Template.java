package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "swcamp";
    private static String password = "swcamp";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        /* 설명. 싱글톤으로 생성하기 위해 해당 객체가 한번도 생성되지 않은 겨웅에만 실행 */
        if(sqlSessionFactory == null) {
            Environment environment =
                    new Environment("dev",
                            new JdbcTransactionFactory(),
                            new PooledDataSource(driver, url, user, password));

            /* 설명. Mapper용 인터페이스를 추가 */
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);
    }
}
