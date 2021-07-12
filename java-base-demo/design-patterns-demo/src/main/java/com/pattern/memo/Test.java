package com.pattern.memo;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Admin admin = new Admin();
        //记录者
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("10001", "配置内容A=哈哈", new Date(), "小黑"));
        //保存配置
        admin.append(configOriginator.saveConfigMemento());
        configOriginator.setConfigFile(new ConfigFile("10002", "配置内容A=嘻嘻", new Date(), "小黑"));
        //保存配置
        admin.append(configOriginator.saveConfigMemento());
        configOriginator.setConfigFile(new ConfigFile("10003", "配置内容A=么么", new Date(), "小黑"));
        //保存配置
        admin.append(configOriginator.saveConfigMemento());
        configOriginator.setConfigFile(new ConfigFile("10004", "配置内容A=嘿嘿", new Date(), "小黑"));

        //历史配置（回滚）
        configOriginator.getMemento(admin.undo());
        System.out.printf("历史配置（回滚）undo：%s\n", configOriginator.getConfigFile().toString());

        //历史配置（回滚）
        configOriginator.getMemento(admin.undo());
        System.out.printf("历史配置（回滚）undo：%s\n", configOriginator.getConfigFile().toString());

        //历史配置（前进）
        configOriginator.getMemento(admin.redo());
        System.out.printf("历史配置（前进）redo：%s\n", configOriginator.getConfigFile().toString());

        //历史配置（获取）
        configOriginator.getMemento(admin.get("10002"));
        System.out.printf("历史配置（前进）redo：%s\n", configOriginator.getConfigFile().toString());

    }

}
