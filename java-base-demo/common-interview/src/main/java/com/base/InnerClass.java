package com.base;

public class InnerClass {

    class InnerClassA{

        void method(){}

        Integer method(String val){return null;}

    }

    InnerClassA getInstance(){
        return new InnerClassA();
    }

    static class InnerStaticClassA {

    }

    static class A extends InnerStaticClassA{

    }

}
