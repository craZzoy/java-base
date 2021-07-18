package com.test.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        System.out.println(ClassLoader.getSystemClassLoader());

        //自定义类加载器实现
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object o = classLoader.loadClass("java.lang.StringBuffer").newInstance();
        System.out.println(o);
        Object obj = classLoader.loadClass("com.test.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass()); //class com.loader.ClassLoaderTest
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj.getClass().getClassLoader().getParent());
        System.out.println(obj instanceof ClassLoaderTest);  //false
    }

}
