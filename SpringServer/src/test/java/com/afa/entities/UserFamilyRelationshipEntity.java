package com.afa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_family_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserFamilyRelationshipEntityPK.class)
public class UserFamilyRelationshipEntity {
    private String familyName;
    private String userEmail;
    private Object role;

    @Id
    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "role")
    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFamilyRelationshipEntity that = (UserFamilyRelationshipEntity) o;
        return Objects.equals(familyName, that.familyName) && Objects.equals(userEmail, that.userEmail) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, userEmail, role);
    }
}
