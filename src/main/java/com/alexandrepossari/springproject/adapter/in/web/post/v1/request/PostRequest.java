package com.alexandrepossari.springproject.adapter.in.web.post.v1.request;

public class PostRequest {
    public String content;
    public long userId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
