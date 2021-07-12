package com.mybatis.domain;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

    private static final long serialVersionUID = 6353726313453073105L;

    private Integer id;

    private String title;

    private Author author;

    private List<Post> posts;

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


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
