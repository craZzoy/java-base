package com.pattern.proxy.gupao.intr;

import com.pattern.proxy.gupao.statics.Person;

/**
 * 码农对象，实现Person接口
 */
public class Acmen implements Person {
    @Override
    public void findObject() {
        //码农没时间找对象
        System.out.println("码农找对象，要求肤白貌美大长腿");
    }

    @Override
    public void findJob() {

    }

    @Override
    public void rentHouse() {

    }
}
