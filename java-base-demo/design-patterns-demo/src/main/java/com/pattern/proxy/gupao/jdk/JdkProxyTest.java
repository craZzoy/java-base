package com.pattern.proxy.gupao.jdk;

import com.pattern.proxy.gupao.statics.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JdkProxyTest {

    public static void main(String[] args) {
        Person person = (Person) new JdkMatchMaker(new LaoWang()).getInstance();
        System.out.println(person.getClass());
        person.findObject();

        //查看源代码
        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            os.write(bytes);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
