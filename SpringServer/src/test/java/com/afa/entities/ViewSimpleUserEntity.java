package com.afa.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "view_simple_user", schema = "bp50_afa", catalog = "")
public class ViewSimpleUserEntity {
    private String email;
    private String forename;
    private String profilePicLink;

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
        ViewSimpleUserEntity that = (ViewSimpleUserEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(forename, that.forename) && Objects.equals(profilePicLink, that.profilePicLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, forename, profilePicLink);
    }
}
