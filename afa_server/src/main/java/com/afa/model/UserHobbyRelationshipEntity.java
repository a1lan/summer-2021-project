package com.afa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_hobby_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserHobbyRelationshipEntityPK.class)
public class UserHobbyRelationshipEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="hobby", referencedColumnName="hobby")
    private HobbyEntity hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;

    public UserHobbyRelationshipEntity() {
    }

    public UserHobbyRelationshipEntity(UserEntity user, HobbyEntity hobby) {
        this.user = user;
        this.hobby = hobby;
    }

    public String getHobbyName() {
        return hobby.getHobby();
    }

    public void setHobby(HobbyEntity hobby) {
        this.hobby = hobby;
    }

    public HobbyEntity getHobby() { return this.hobby; }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUser(UserEntity newUser) {
        this.user = newUser;
    }

    public UserEntity getUser() { return this.user; }

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
