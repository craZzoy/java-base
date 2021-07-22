package com.mybatis.plugins;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 11:40 2021/7/21
 */
public class TestPlugins implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }
}
