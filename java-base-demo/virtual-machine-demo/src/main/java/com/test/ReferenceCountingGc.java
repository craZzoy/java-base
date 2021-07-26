package com.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class ReferenceCountingGc {

    private Object instance = null;

    //用于占用内存，以便查看是否gc
    private byte[] bigSize = new byte[2 * _1MB];

    private static final int _1MB = 8 * 1024 * 1024;

    public static void main(String[] args) {
//        char ch = '你';
//        System.out.println(Character.valueOf(ch));
        testIsReferenceCountingGc();
        //testReference();
    }

    /**
     * 测试是否引用计数法
     * VM args：-XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     */
    public static void testIsReferenceCountingGc() {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }


    /**
     * 测试引用类型
     */
    public static void testReference() {
        String s = new String("Hello");
        Reference reference = new SoftReference(s);
        System.out.println(reference.get());

        ReferenceQueue referenceQueue = new ReferenceQueue();
        Reference phantomReference = new PhantomReference(s, referenceQueue);
        System.out.println(phantomReference.get());

    }


}
