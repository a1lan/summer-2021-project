package com.family_server.model;

import javax.persistence.Entity;


public class TestResponse {

    private final long id;
    private final String content;

    public TestResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}