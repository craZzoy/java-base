package com.mybatis.domain;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

    private static final long serialVersionUID = 6353726313453073105L;

    public static String staticField;

    private Integer id;

    private String title;

    private Author author;

    private List<Post> posts;

    public static String staticMethod(){
        return "static method";
    }

    public Blog(Integer id, String title, Author author, List<Post> posts) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.posts = posts;
    }

    public Blog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author.toString() +
                ", posts=" + posts.toString() +
                '}';
    }
}
