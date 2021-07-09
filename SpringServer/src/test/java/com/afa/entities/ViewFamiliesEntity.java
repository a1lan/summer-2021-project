package com.afa.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "view_families", schema = "bp50_afa", catalog = "")
public class ViewFamiliesEntity {
    private String familyName;
    private Object role;
    private String email;
    private String forename;
    private String profilePicLink;

    @Basic
    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "role")
    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "forename")
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name = "profile_pic_link")
    public String getProfilePicLink() {
        return profilePicLink;
    }

    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink = profilePicLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewFamiliesEntity that = (ViewFamiliesEntity) o;
        return Objects.equals(familyName, that.familyName) && Objects.equals(role, that.role) && Objects.equals(email, that.email) && Objects.equals(forename, that.forename) && Objects.equals(profilePicLink, that.profilePicLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, role, email, forename, profilePicLink);
    }
}
