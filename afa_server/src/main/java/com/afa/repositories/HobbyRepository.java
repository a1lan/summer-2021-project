package com.afa.repositories;

import com.afa.model.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer> {
    HobbyEntity findByHobby(String hobby);
}