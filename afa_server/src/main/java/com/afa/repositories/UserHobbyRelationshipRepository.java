package com.afa.repositories;

import com.afa.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserHobbyRelationshipRepository extends JpaRepository<UserHobbyRelationshipEntity, Integer> {
    @Query("SELECT uhr FROM UserHobbyRelationshipEntity uhr WHERE uhr.user.email = :email AND uhr.hobby.hobby = :hobby")
    UserHobbyRelationshipEntity findByHobbyAndUser(@Param("hobby") String hobby, @Param("email") String email);

    @Query("SELECT uhr.hobby FROM UserHobbyRelationshipEntity uhr WHERE uhr.user.email = :email")
    List<HobbyEntity> findHobbiesByUser(@Param("email") String email);

    @Query("SELECT uhr.user FROM UserHobbyRelationshipEntity uhr WHERE uhr.hobby.hobby = :hobby")
    List<UserEntity> findUsersByHobby(@Param("hobby") String hobby);
}