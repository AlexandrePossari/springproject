package com.alexandrepossari.springproject.adapter.in.web.post.v1.response;

public class PostResponse {
    public String content;
    public long id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static class Builder{
        private PostResponse response = new PostResponse();

        public Builder setId(long id) {
            response.setId(id);
            return this;
        }

        public Builder setContent(String content) {
            response.setContent(content);
            return this;
        }

        public PostResponse build(){
            return response;
        }
    }
}
