package com.pattern.proxy.xiaofu;

import com.pattern.proxy.xiaofu.agent.Select;

public interface IUserDao {

    @Select("select username form user where id =#{uid}")
    String queryUserInfo(String uid);

}
