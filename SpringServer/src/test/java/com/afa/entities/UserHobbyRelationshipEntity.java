package com.afa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_hobby_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserHobbyRelationshipEntityPK.class)
public class UserHobbyRelationshipEntity {
    private String hobby;
    private String userEmail;

    @Id
    @Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Id
    @Column(name = "user_email")
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
        UserHobbyRelationshipEntity that = (UserHobbyRelationshipEntity) o;
        return Objects.equals(hobby, that.hobby) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobby, userEmail);
    }
}
