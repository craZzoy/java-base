package com.pattern.proxy;

import com.pattern.proxy.xiaofu.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIUserDao {

    private static Logger logger = LoggerFactory.getLogger(TestIUserDao.class);


    @org.junit.Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        context.refresh();
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        String s = userDao.queryUserInfo("10010");
        System.out.println("测试结果：" + s);
        logger.info("测试结果：{}", s);
        context.close();
    }

}
