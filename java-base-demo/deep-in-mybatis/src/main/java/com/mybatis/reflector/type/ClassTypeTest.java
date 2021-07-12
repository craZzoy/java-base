package com.mybatis.reflector.type;


public class ClassTypeTest {

    public static void main(String[] args) {
        String[] strs = new String[]{"key","name"};
        Integer[] ints = new Integer[]{1,2,3};
        Integer[] ints1 = new Integer[]{1,2,3};
        System.out.println(strs.getClass());
        System.out.println(ints.getClass());
        System.out.println(ints1.getClass());
    }

}
