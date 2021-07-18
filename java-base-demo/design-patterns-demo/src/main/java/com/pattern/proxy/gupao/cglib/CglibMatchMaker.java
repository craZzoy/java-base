package com.pattern.proxy.gupao.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMatchMaker implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();

        //设置即将生成类的父类
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆，我帮你找对象");

        methodProxy.invokeSuper(o,objects);

        System.out.println("帮你找到了，记得好评");

        return null;
    }
}
