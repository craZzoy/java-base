package com.pattern.proxy.gupao.jdk;

import com.pattern.proxy.gupao.cglib.CglibMatchMaker;

import java.lang.reflect.Proxy;

public class NoInterfaceProxyTest {

    public static void main(String[] args) throws Exception {

        ProxyClass cglibProxy = (ProxyClass) new CglibMatchMaker().getInstance(ProxyClass.class);
        cglibProxy.say();

        ProxyClass proxyClass = new ProxyClass();
        ProxyClass proxy1 = (ProxyClass)Proxy.newProxyInstance(proxyClass.getClass().getClassLoader(),
                new Class[]{ProxyClass.class},
                (proxy, method, args1) -> {
                    System.out.println("pre execute");
                    Object invoke = method.invoke(proxyClass, args1);
                    System.out.println("after execute");
                    return invoke;
                }
        );
        proxy1.say();
    }


}
