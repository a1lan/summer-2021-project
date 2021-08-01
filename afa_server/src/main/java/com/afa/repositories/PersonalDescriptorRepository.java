package com.afa.repositories;

import com.afa.model.PersonalDescriptorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDescriptorRepository extends JpaRepository<PersonalDescriptorEntity, Integer> {
    PersonalDescriptorEntity findByDescriptor(String descriptor);
}