package com.alexandrepossari.springproject.adapter.out.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {
    private String email;
    private String password;
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static class Builder {
        private final UserEntity entity = new UserEntity();

        public Builder id(long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder email(String email) {
            entity.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            entity.setPassword(password);
            return this;
        }

        public UserEntity build() {
            return entity;
        }
    }
}
