package com.afa.repositories;

import com.afa.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDescriptorRelationshipRepository extends JpaRepository<UserDescriptorRelationshipEntity, Integer> {
    @Query("SELECT udr FROM UserDescriptorRelationshipEntity udr WHERE udr.user.email = :email AND udr.descriptor.descriptor = :descriptor")
    UserDescriptorRelationshipEntity findByDescriptorAndUser(@Param("descriptor") String descriptor, @Param("email") String email);

    @Query("SELECT udr.descriptor FROM UserDescriptorRelationshipEntity udr WHERE udr.user.email = :email")
    List<PersonalDescriptorEntity> findDescriptorsByUser(@Param("email") String email);

    @Query("SELECT udr.user FROM UserDescriptorRelationshipEntity udr WHERE udr.descriptor.descriptor = :descriptor")
    List<UserEntity> findUsersByDescriptor(@Param("descriptor") String descriptor);
}