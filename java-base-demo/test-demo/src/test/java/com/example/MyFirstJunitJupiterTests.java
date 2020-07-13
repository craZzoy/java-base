package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Description: A first test case
 * @Author : 郑玮泽
 * @Date : 11:33 2020/7/7
 */
public class MyFirstJunitJupiterTests {

    private final Calculator calculator = new Calculator();

    @Test
    void addition(){
        Assertions.assertEquals(2, calculator.add(1, 1));
    }

}
