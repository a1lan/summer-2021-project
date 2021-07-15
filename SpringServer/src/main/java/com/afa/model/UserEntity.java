package com.afa.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "bp50_afa", catalog = "")
public class UserEntity {

    @Id
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "forename")
    private String forename;

    @Basic(optional = false)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Basic(optional = true)
    @Column(name = "profile_pic_link")
    private String profilePicLink;

    @Basic(optional = false)
    @Column(name = "ideal_family_size")
    @Enumerated(EnumType.STRING)
    private FamilySize idealFamilySize;

    @Basic
    @Column(name = "cookie")
    private String cookie;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePicLink() {
        return profilePicLink;
    }

    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink = profilePicLink;
    }

    public Object getIdealFamilySize() {
        return idealFamilySize;
    }

    public void setIdealFamilySize(FamilySize idealFamilySize) {
        this.idealFamilySize = idealFamilySize;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(forename, that.forename) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(profilePicLink, that.profilePicLink) &&
                idealFamilySize.equals(that.idealFamilySize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, forename, dateOfBirth, profilePicLink, idealFamilySize);
    }
}


enum FamilySize { SMALL, MEDIUM, LARGE };