package com.afa.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "bp50_afa", catalog = "")
public class UserEntity {
    private String email;
    private String forename;
    private Date dateOfBirth;
    private String profilePicLink;
    private Object idealFamilySize;

    @Id
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
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "profile_pic_link")
    public String getProfilePicLink() {
        return profilePicLink;
    }

    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink = profilePicLink;
    }

    @Basic
    @Column(name = "ideal_family_size")
    public Object getIdealFamilySize() {
        return idealFamilySize;
    }

    public void setIdealFamilySize(Object idealFamilySize) {
        this.idealFamilySize = idealFamilySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(forename, that.forename) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(profilePicLink, that.profilePicLink) && Objects.equals(idealFamilySize, that.idealFamilySize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, forename, dateOfBirth, profilePicLink, idealFamilySize);
    }
}
