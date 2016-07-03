package com.shacham.amit.gymglishtest;

public class Website {

    private String mName;
    private String mUrl;

    public Website(String name, String url) {
        mName = name;
        mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }
}
