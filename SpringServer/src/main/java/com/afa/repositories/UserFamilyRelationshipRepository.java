package com.afa.repositories;

import com.afa.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserFamilyRelationshipRepository extends JpaRepository<UserFamilyRelationshipEntity, Integer> {
    @Query("SELECT ufr FROM UserFamilyRelationshipEntity ufr WHERE ufr.user.email = :email AND ufr.family.name = :family")
    UserFamilyRelationshipEntity findByFamilyAndUser(@Param("family") String family, @Param("email") String email);

    @Query("SELECT ufr.family FROM UserFamilyRelationshipEntity ufr WHERE ufr.user.email = :email")
    List<FamilyEntity> findFamiliesByUser(@Param("email") String email);

    @Query("SELECT ufr.user FROM UserFamilyRelationshipEntity ufr WHERE ufr.family.name = :family")
    List<UserEntity> findUsersByFamily(@Param("family") String family);

    @Query("SELECT ufr.user FROM UserFamilyRelationshipEntity ufr WHERE ufr.family.name = :family AND ufr.role = :role")
    List<UserEntity> findUsersByFamilyAndRole(@Param("family") String family, @Param("role") FamilyRole role);
}