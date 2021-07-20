package com.afa.model;

import java.io.Serializable;
import java.util.Objects;

public class UserHobbyRelationshipEntityPK implements Serializable {
    private String hobby;
    private String user;

    public UserHobbyRelationshipEntityPK() {
    }

    public UserHobbyRelationshipEntityPK(String user, String hobby) {
        this.user = user;
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHobbyRelationshipEntity that = (UserHobbyRelationshipEntity) o;
        return Objects.equals(hobby, that.getHobbyName()) && Objects.equals(user, that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobby, user);
    }
}
