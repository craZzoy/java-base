package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @Description: disable class 一般需在@Disabled中注明为何原因
 * @Author : 郑玮泽
 * @Date : 16:17 2020/7/7
 */
@Disabled("Disabled until bug #99 has been fixed")
public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }


}
