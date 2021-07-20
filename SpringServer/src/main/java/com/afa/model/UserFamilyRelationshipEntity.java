package com.afa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_family_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserFamilyRelationshipEntityPK.class)
public class UserFamilyRelationshipEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="family_name", referencedColumnName="name")
    private FamilyEntity family;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;

    @Basic(optional = false)
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private FamilyRole role;

    public UserFamilyRelationshipEntity() {
    }

    public UserFamilyRelationshipEntity(UserEntity user, FamilyEntity family, FamilyRole role) {
        this.user = user;
        this.family = family;
        this.role = role;
    }

    public String getFamilyName() {
        return this.family.getName();
    }

    public void setFamily(FamilyEntity newFamily) {
        this.family = newFamily;
    }

    public FamilyEntity getFamily() { return this.family; }

    public String getUserEmail() {
        return this.user.getEmail();
    }

    public void setUser(UserEntity newUser) {
        this.user = newUser;
    }

    public UserEntity getUser() { return this.user; }

    public FamilyRole getRole() {
        return role;
    }

    public void setRole(FamilyRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFamilyRelationshipEntity that = (UserFamilyRelationshipEntity) o;
        return Objects.equals(this.family.getName(), that.family.getName()) && Objects.equals(user.getEmail(),
                that.user.getEmail()) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family.getName(), user.getEmail(), role);
    }
}