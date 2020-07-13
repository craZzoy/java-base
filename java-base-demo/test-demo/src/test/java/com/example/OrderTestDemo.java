package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @Description: 按顺序执行测试
 * @Author : 郑玮泽
 * @Date : 9:13 2020/7/8
 */
@TestMethodOrder(MethodOrderer.Random.class)
public class OrderTestDemo {

    @Test
    @Order(1)
    void test1(){
        System.out.println("test1...");
    }

    @Test
    @Order(3)
    void test2(){
        System.out.println("test2...");
    }

    @Test
    @Order(2)
    void test3(){
        System.out.println("test3...");
    }

}
