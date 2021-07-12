package com.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    static AtomicReference<User> reference = new AtomicReference<>();

    static User initUser = new User("老王", 40);

    static AtomicMarkableReference<User> markableReference = new AtomicMarkableReference<>(initUser, true);

    public static void main(String[] args) {
        User user = new User("Jack", 30);
        reference.set(user);
        User updateUser = new User("Jerry", 25);
        reference.compareAndSet(user, updateUser);
        System.out.println(reference.get());

        User user1 = markableReference.get(new boolean[]{true});
        User user2 = markableReference.get(new boolean[]{false});
        System.out.println(user1);
        System.out.println(user2);
        //更新时需带上标记位
        User updateUser1 = new User("小花", 18);
        markableReference.compareAndSet(
                markableReference.getReference(),
                updateUser1,
                true,
                false
                );
        System.out.println(markableReference.getReference());
        System.out.println(markableReference.isMarked());
    }

}
