package com.afa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserFamilyRelationshipEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="family_name", referencedColumnName="name")
    private FamilyEntity family;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;


    public String getFamilyName() {
        return this.family.getName();
    }

    public void setFamily(FamilyEntity newFamily) {
        this.family = newFamily;
    }

    public String getUserEmail() {
        return this.user.getEmail();
    }

    public void setUser(UserEntity newUser) {
        this.user = newUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFamilyRelationshipEntityPK that = (UserFamilyRelationshipEntityPK) o;
        return Objects.equals(family.getName(), that.family.getName()) && Objects.equals(user.getEmail(),
                that.user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(family.getName(), user.getEmail());
    }
}
