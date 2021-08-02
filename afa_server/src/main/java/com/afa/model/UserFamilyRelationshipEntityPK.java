package com.afa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserFamilyRelationshipEntityPK implements Serializable {
    private String family;
    private String user;

    public UserFamilyRelationshipEntityPK() {
    }

    public UserFamilyRelationshipEntityPK(String user, String family) {
        this.user = user;
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFamilyRelationshipEntityPK that = (UserFamilyRelationshipEntityPK) o;
        return Objects.equals(family, that.family) && Objects.equals(user,
                that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, user);
    }
}
