package com.alexandrepossari.springproject.adapter.in.web.user.v1.response;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;

public class UserResponse {
    private String email;
    private String nome;
    private long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static class Builder{
        private UserResponse response = new UserResponse();

        public UserResponse.Builder setId(long id) {
            response.setId(id);
            return this;
        }

        public UserResponse.Builder setEmail(String email) {
            response.setEmail(email);
            return this;
        }

        public UserResponse.Builder setNome(String nome) {
            response.setNome(nome);
            return this;
        }

        public UserResponse build(){
            return response;
        }
    }
}
