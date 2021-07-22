package com.demo.enumdemo;

/**
 * @Description: enum类型valueOf方法
 * @Author : 郑玮泽
 * @Date : 10:12 2021/7/21
 */
public class EnumValueTest {

    public static void main(String[] args) {
        ParameterMode value = ParameterMode.valueOf("IN");
        ParameterMode value1 = ParameterMode.valueOf("OUT");
        System.out.println(value.ordinal());
        System.out.println(value1.ordinal());
        System.out.println(value);
    }


    public enum ParameterMode {
        IN,
        OUT,
        INOUT;

        private ParameterMode() {
        }
    }

}
