package com.pattern.proxy.gupao.jdk;

import com.pattern.proxy.gupao.statics.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理创建类
 */
public class JdkMatchMaker implements InvocationHandler {

    private Person target;

    public JdkMatchMaker(Person target) {
        this.target = target;
    }

    public Object getInstance(){
        Class<? extends Person> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(proxy.toString());
        System.out.println("我是金牌媒婆，帮你找对象，服务好包满意");
        Object invoke = method.invoke(target, args);
        System.out.println("找到合适的给个好评啊");
        return invoke;
    }
}
