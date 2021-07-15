package com.afa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_descriptor_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserDescriptorRelationshipEntityPK.class)
public class UserDescriptorRelationshipEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="descriptor", referencedColumnName="descriptor")
    private PersonalDescriptorEntity descriptor;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;

    public String getDescriptor() {
        return descriptor.getDescriptor();
    }

    public void setDescriptor(PersonalDescriptorEntity descriptor) {
        this.descriptor = descriptor;
    }

    public PersonalDescriptorEntity getDescriptorEntity() { return this.descriptor; }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserEmail(UserEntity newUser) {
        this.user = newUser;
    }

    public UserEntity getUserEntity() { return this.user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDescriptorRelationshipEntity that = (UserDescriptorRelationshipEntity) o;
        return Objects.equals(descriptor.getDescriptor(), that.getDescriptor()) &&
                Objects.equals(user.getEmail(), that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptor, user.getEmail());
    }
}
