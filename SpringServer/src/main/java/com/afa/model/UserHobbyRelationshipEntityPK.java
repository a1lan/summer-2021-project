package com.afa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserHobbyRelationshipEntityPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="hobby", referencedColumnName="hobby")
    private HobbyEntity hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;



    public String getHobby() {
        return hobby.getHobby();
    }

    public void setHobby(HobbyEntity hobby) {
        this.hobby = hobby;
    }

    public HobbyEntity getHobbyEntity() { return this.hobby; }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserEmail(UserEntity newUser) {
        this.user = newUser;
    }

    public UserEntity getUserEntity() { return this.user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHobbyRelationshipEntity that = (UserHobbyRelationshipEntity) o;
        return Objects.equals(hobby.getHobby(), that.getHobby()) && Objects.equals(user.getEmail(), that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobby.getHobby(), user.getEmail());
    }
}
