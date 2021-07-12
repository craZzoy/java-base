package com.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayTest {

    static int[] arr = {1, 2};

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);
        System.out.println(atomicIntegerArray.get(0));
        //不改变原数组的值
        System.out.println(arr[0]);
    }

}
