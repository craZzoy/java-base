package com.pattern.proxy.gupao.statics;

/**
 * 媒婆，静态代理码农去找对象
 */
public class MatchMaker {

    private Person person;

    public MatchMaker(Person person){
        this.person = person;
    }

    public void findObject(){
        System.out.println("媒婆帮你找对象");
        this.person.findObject();
        System.out.println("双方决定合不合适");
    }

}
