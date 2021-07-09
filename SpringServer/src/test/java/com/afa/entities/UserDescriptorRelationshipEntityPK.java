package com.afa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserDescriptorRelationshipEntityPK implements Serializable {
    private String descriptor;
    private String userEmail;

    @Column(name = "descriptor")
    @Id
    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
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
        UserDescriptorRelationshipEntityPK that = (UserDescriptorRelationshipEntityPK) o;
        return Objects.equals(descriptor, that.descriptor) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptor, userEmail);
    }
}
