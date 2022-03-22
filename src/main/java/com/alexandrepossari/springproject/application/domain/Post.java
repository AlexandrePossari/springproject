package com.alexandrepossari.springproject.application.domain;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;

public class Post {
    public String content;
    public long id;
    public User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class Builder {
        private final Post post = new Post();

        public Post.Builder content(String content) {
            post.setContent(content);
            return this;
        }

        public Post.Builder id(long id) {
            post.setId(id);
            return this;
        }

        public Post.Builder user(User user) {
            post.setUser(user);
            return this;
        }


        public Post build() {
            return post;
        }

    }
}
