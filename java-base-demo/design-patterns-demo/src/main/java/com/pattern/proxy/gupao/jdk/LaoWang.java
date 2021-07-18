package com.pattern.proxy.gupao.jdk;

import com.pattern.proxy.gupao.statics.Person;

public class LaoWang implements Person {
    @Override
    public void findObject() {
        System.out.println("老王是高富帅，身高180，有8块腹肌");
    }

    @Override
    public void findJob() {
        System.out.println("活少钱多离家近");
    }

    @Override
    public void rentHouse() {
        System.out.println("要海景别墅");
    }
}
