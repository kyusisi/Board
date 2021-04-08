package com.board.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DBConfigurationTest {
    
    @Autowired
    ApplicationContext ac;
    
    @Autowired
    SqlSessionFactory sessionFactory;
    
    @Test
    void contextLoads() {
        
    }
    
    @Test
    @DisplayName("sqlSession 빈등록 확인")
    public void testByApplicationContext() {
        try {
            System.out.println("=========================");
            System.out.println(ac.getBean("sqlSessionFactory"));
            System.out.println("=========================");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBySqlSessionFactory() {
        try {
            System.out.println("=========================");
            System.out.println(sessionFactory.toString());
            System.out.println("=========================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}