package com.demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class URLAndURITest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://foo.com/hello%20world");
        URI uri = url.toURI();
        System.out.println(uri);
    }

}
