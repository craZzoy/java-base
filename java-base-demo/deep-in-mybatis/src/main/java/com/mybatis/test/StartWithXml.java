package com.mybatis.test;


import com.mybatis.domain.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过xml配置启动使用mybatis
 */
public class StartWithXml {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(resource);
        //加载config配置文件，并创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        Blog blog = (Blog) sqlSession.selectOne("com.mybatis.mapper.BlogMapper.selectBlogDetail", param);
        System.out.println(blog);
    }

}
