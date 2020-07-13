package com.example;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @Description: 生命周期
 * @Author : 郑玮泽
 * @Date : 9:43 2020/7/8
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycleDemo {

    @Test
    void test1(){
        System.out.println("current instance:" + this);
    }

    @Test
    void test2(){
        System.out.println("current instance:" + this);
    }

    @Test
    void test3(){
        System.out.println("current instance:" + this);
    }


}
