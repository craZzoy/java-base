package com.optimize;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhengwz
 * @create: 2020/6/30 16:56
 **/
public class UnSafeDemo {
    public static void main(String[] args) {
        String s = "hello";
        AtomicInteger atomicInteger = new AtomicInteger(12);
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        try {
            Unsafe unsafe = (Unsafe) declaredField.get(null);
            long value = unsafe.objectFieldOffset
                    (atomicInteger.getClass().getDeclaredField("value"));
            System.out.println(value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
