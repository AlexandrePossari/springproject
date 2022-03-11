package com.alexandrepossari.springproject.adapter.out.mysql.entity;

import com.alexandrepossari.springproject.application.domain.User;

import javax.persistence.*;

@Entity
public class PostEntity {
    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private UserEntity userEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static class Builder {
        private final PostEntity entity = new PostEntity();

        public PostEntity.Builder content(String content) {
            entity.setContent(content);
            return this;
        }

        public PostEntity.Builder id(long id) {
            entity.setId(id);
            return this;
        }

        public PostEntity.Builder userEntity(UserEntity userEntity) {
            entity.setUserEntity(userEntity);
            return this;
        }


        public PostEntity build() {
            return entity;
        }
    }
}
