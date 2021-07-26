package com.serialize;

import com.domain.Address;
import com.domain.User;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("GD");
        User user = new User("Tom", 30, "tom@163.com", address);
        //浅克隆
        User clone = user.clone();
        System.out.println(user);
        System.out.println(clone);

        User user1 = user.deepClone();
        System.out.println(user1);

    }

}
