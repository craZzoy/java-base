package com.base;

import com.domain.User;

import java.lang.reflect.Field;

/**
 * 参数传递
 */
public class ParameterPass {

    public static void main(String[] args) throws Exception {
        int a = 4;
        Integer inta = 290;
        String s = "Hello";
        User user = new User("Jack", 29, "jack@163.com");
        testPass(a, s, user, inta);
        System.out.println(a);
        System.out.println(s);
        System.out.println(user);
        System.out.println(inta);
    }

    private static void testPass(int a, String s, User user, Integer inta) throws Exception {
        a = 5;
        s = "World";
        user.setAge(30);
        inta = 23;
        Field value = inta.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(inta, 350);
    }




}
