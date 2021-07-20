package com.afa.repositories;

import com.afa.model.FamilyEntity;
import com.afa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<FamilyEntity, Integer> {
    FamilyEntity findByName(String name);
}