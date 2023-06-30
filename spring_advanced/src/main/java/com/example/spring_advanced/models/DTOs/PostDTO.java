package com.example.spring_advanced.models.DTOs;

public class PostDTO {
    private String title;
    private String body;

    public PostDTO(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public PostDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
