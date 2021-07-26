package com.serialize;

import com.domain.User;

public class JavaSerializeTest {

    public static void main(String[] args) {
        User user = new User("Jack", 35, "jack@163.com");
        Serializer serializer = new JavaSerializer();
        //系列化
        byte[] serialize = serializer.serialize(user);
        System.out.println(serialize);
        //反系列化
        User user1 = serializer.deSerialize(serialize, User.class);
        System.out.println(user1);
    }

}
