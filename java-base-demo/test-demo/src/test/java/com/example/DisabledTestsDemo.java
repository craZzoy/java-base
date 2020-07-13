package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @Description: disable method
 * @Author : 郑玮泽
 * @Date : 16:19 2020/7/7
 */
public class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }

}
