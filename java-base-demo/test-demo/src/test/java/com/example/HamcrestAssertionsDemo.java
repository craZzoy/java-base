package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * @Description: Hamcrest框架示例
 * @Author : 郑玮泽
 * @Date : 15:57 2020/7/7
 */
public class HamcrestAssertionsDemo {

    private Calculator calculator = new Calculator();

    @Test
    void assertWithHamcrestMatcher() {
        MatcherAssert.assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }

}
