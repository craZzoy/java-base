package com.mybatis.reflector.type;

import org.apache.ibatis.reflection.TypeParameterResolver;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeTest {

    SubClassA<Long> as = new SubClassA<>();

    public static void main(String[] args) throws Exception {
        SubClassA<Long> as = new SubClassA<>();
        ClassA a = new ClassA();
        System.out.println(a.getClass().isAssignableFrom(SubClassA.class));

        Field f = ClassA.class.getDeclaredField("map");
        System.out.println(f.getGenericType()); // java.util.Map<K, V>
        System.out.println(f.getGenericType() instanceof ParameterizedType); // true

        Type type = TypeParameterResolver.resolveFieldType(f,
                ParameterizedTypeImpl.make(SubClassA.class, new Type[]{Long.class}, TypeTest.class));
        Type type1 = TypeParameterResolver.resolveFieldType(f, TypeTest.class.getDeclaredField("as").getGenericType());
        System.out.println(type.getClass()); //class org.apache.ibatis.reflection.TypeParameterResolver$ParameterizedTypeImpl
        System.out.println(type1.getClass()); //class org.apache.ibatis.reflection.TypeParameterResolver$ParameterizedTypeImpl

        ParameterizedType p = (ParameterizedType) type;
        System.out.println(p.getOwnerType()); // null
        System.out.println(p.getRawType()); // interface java.util.Map
        for (Type t : p.getActualTypeArguments()){
            System.out.println(t);
            //class java.lang.Long
            //class java.lang.Long
        }

    }

}
