package com.afa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserFamilyRelationshipEntityPK implements Serializable {
    private String familyName;
    private String userEmail;

    @Column(name = "family_name")
    @Id
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
        UserFamilyRelationshipEntityPK that = (UserFamilyRelationshipEntityPK) o;
        return Objects.equals(familyName, that.familyName) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, userEmail);
    }
}
