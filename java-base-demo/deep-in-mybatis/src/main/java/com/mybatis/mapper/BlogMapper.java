package com.mybatis.mapper;

import com.mybatis.domain.Blog;

public interface BlogMapper {

    Blog selectBlog(Integer id);

    Blog selectBlogDetail(Integer id);

    String getTime();

}
