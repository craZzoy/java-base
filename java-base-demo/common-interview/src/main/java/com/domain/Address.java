package com.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Address(String content) {
        this.content = content;
    }

}
