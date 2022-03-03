package com.alexandrepossari.springproject.application.domain;

import java.time.LocalDateTime;

public class User {
    private String email;
    private String password;
    private String nome;
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
        private User user = new User();

        public Builder id(long id) {
            user.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            user.setNome(nome);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public User build() {
            return user;
        }

    }
}
