package com.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 14:01 2021/3/17
 */
public class OptionalDemo {

    public static void main(String[] args) {
        final Optional<Integer> num = Optional.of("123").map(s -> Integer.valueOf(s));
        

        List<String> strs = new ArrayList<>();
        final Stream<String> stream = strs.stream();

        testFlatMap();
        
        testOptionalMap();
    }

    private static void testOptionalMap() {
        String name = "Jack";
        final Optional<String> s1 = Optional.ofNullable(name).map(s -> s + "!");
    }


    /**
     * flatmap 示例
     */
    public static void testFlatMap(){
        String[] arrayOfWords = {"Goodbye", "World"};
        final List<Stream<String>> collect = Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }


    public static void testPeek(){
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

}
