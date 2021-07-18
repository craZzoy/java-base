package com.pattern.proxy.gupao.statics;

/**
 * 静态代理测试类
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        MatchMaker matchMaker = new MatchMaker(new com.pattern.proxy.gupao.intr.Acmen());
        matchMaker.findObject();
    }

}
