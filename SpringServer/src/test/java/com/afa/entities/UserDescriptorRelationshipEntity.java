package com.afa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_descriptor_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserDescriptorRelationshipEntityPK.class)
public class UserDescriptorRelationshipEntity {
    private String descriptor;
    private String userEmail;

    @Id
    @Column(name = "descriptor")
    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Id
    @Column(name = "user_email")
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
        UserDescriptorRelationshipEntity that = (UserDescriptorRelationshipEntity) o;
        return Objects.equals(descriptor, that.descriptor) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptor, userEmail);
    }
}
