package com.demo;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 15:47 2020/12/21
 */
public class IntegerDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "abc";
        String b = "abc";
        System.out.println("a=" + a + ",b=" + b);
        changeValueOfA(a, 4);
        System.out.println("a=" + a + ",b=" + b);
    }

    private static void changeValueOfA(String source, int a) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends String> aClass = source.getClass();
        Field field = aClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(source, "hhh".toCharArray());
    }

}
