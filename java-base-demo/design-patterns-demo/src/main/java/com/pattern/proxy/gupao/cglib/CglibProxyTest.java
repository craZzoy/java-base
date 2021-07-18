package com.pattern.proxy.gupao.cglib;

public class CglibProxyTest {

    public static void main(String[] args) {
        try {
            Wangwu wangwu = (Wangwu) new CglibMatchMaker().getInstance(Wangwu.class);

            wangwu.findObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
