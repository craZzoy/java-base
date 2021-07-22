package com.mybatis.codeprocess.ognl;

import com.mybatis.domain.Author;
import com.mybatis.domain.Blog;
import com.mybatis.domain.Post;
import ognl.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OGNL表达式测试
 */
public class OgnlTest {

    private static Blog blog;

    private static Author author;

    private static List<Post> posts;

    private static OgnlContext ognlContext;

    @Before
    public void start(){
        Blog.staticField = "static field";
        author = new Author(1, "username1", "password1", "email");
        Post post = new Post();
        post.setContent("PostContent");
        post.setAuthor(author);
        posts = new ArrayList<>();
        posts.add(post);
        blog = new Blog(1, "title", author, posts);
        //实例化一个OGNL上下文
        MemberAccess memberAccess = new AbstractMemberAccess() {
            public boolean isAccessible(Map context, Object target, Member member, String propertyName) {
                int modifiers = member.getModifiers();
                return Modifier.isPublic(modifiers);
            }
        };
        ognlContext = new OgnlContext(new DefaultClassResolver(), new DefaultTypeConverter(), memberAccess);
        ognlContext.put("blog", blog);
        //blog设为root对象
        ognlContext.setRoot(blog);
    }

    /**
     * 测试访问root对象和非root对象
     */

    public void testAccessRootAndNotRootObj() throws OgnlException {
        //访问root对象
        Object root = ognlContext.getRoot();
        System.out.println(root);

        //访问root对象的属性，author是root对象（Blog）的属性
        Object author = Ognl.getValue(Ognl.parseExpression("author"), ognlContext, ognlContext.getRoot());
        System.out.println(author);

        Object value = Ognl.getValue(Ognl.parseExpression("author.username"), ognlContext, ognlContext.getRoot());
        System.out.println(value);

        //访问非root对象，以#开头
        Author author2 = new Author(2, "username2", "password2", "email2");
        ognlContext.put("author2", author2);

        Object value1 = Ognl.getValue(Ognl.parseExpression("#author2.username"), ognlContext, ognlContext.getRoot());
        System.out.println(value1);

    }

    /**
     * 测试访问方法、静态属性
     * @throws OgnlException
     */

    public void testAccessMethodAndStaticField() throws OgnlException {
        //调用方法
        Object value = Ognl.getValue(Ognl.parseExpression("author.getEmail()"), ognlContext, ognlContext.getRoot());
        System.out.println(value);

        //调用静态方法
        Object value1 = Ognl.getValue(Ognl.parseExpression("@com.mybatis.domain.Blog@staticMethod()"), ognlContext, ognlContext.getRoot());
        System.out.println(value1);

        //访问静态字段
        Object value2 = Ognl.getValue(Ognl.parseExpression("@com.mybatis.domain.Blog@staticField"), ognlContext, ognlContext.getRoot());
        System.out.println(value2);

    }

    /**
     * 测试访问集合
     */
    @Test
    public void testAccessCollection() throws OgnlException {
        Object value = Ognl.getValue("posts[0]", ognlContext, ognlContext.getRoot());
        System.out.println(value);

        Map<Object, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        ognlContext.put("map", map);
        Object value1 = Ognl.getValue("#map['k2']", ognlContext, ognlContext.getRoot());
        System.out.println(value1);
    }

}
