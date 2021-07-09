package com.afa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserHobbyRelationshipEntityPK implements Serializable {
    private String hobby;
    private String userEmail;

    @Column(name = "hobby")
    @Id
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Column(name = "user_email")
    @Id
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHobbyRelationshipEntityPK that = (UserHobbyRelationshipEntityPK) o;
        return Objects.equals(hobby, that.hobby) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobby, userEmail);
    }
}
