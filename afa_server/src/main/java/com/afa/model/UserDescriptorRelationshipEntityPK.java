package com.afa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserDescriptorRelationshipEntityPK implements Serializable {
    private String descriptor;
    private String user;

    public UserDescriptorRelationshipEntityPK() {
    }

    public UserDescriptorRelationshipEntityPK(String user, String descriptor) {
        this.user = user;
        this.descriptor = descriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDescriptorRelationshipEntity that = (UserDescriptorRelationshipEntity) o;
        return Objects.equals(descriptor, that.getDescriptorName()) &&
                Objects.equals(user, that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptor, user);
    }
}
