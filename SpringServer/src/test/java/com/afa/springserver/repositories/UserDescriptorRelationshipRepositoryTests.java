package com.afa.springserver.repositories;

import com.afa.model.*;
import com.afa.repositories.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Need to set up in-memory database, but too much effort right now.
 */
@SpringBootTest
class UserDescriptorRelationshipRepositoryTests {

    UserEntity testUserEntity = new UserEntity("TestEntity@aol.com", "test", LocalDate.now(), FamilySize.SMALL);
    UserEntity userResponse;

    PersonalDescriptorEntity testDescriptorEntity = new PersonalDescriptorEntity("TestEntity");
    PersonalDescriptorEntity descriptorResponse;

    UserDescriptorRelationshipEntity testEntity = new UserDescriptorRelationshipEntity(testUserEntity, testDescriptorEntity);
    UserDescriptorRelationshipEntity response;

    @Autowired
    private UserDescriptorRelationshipRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PersonalDescriptorRepository descriptorRepo;

    @BeforeEach
    void addUserAndCourse() {
        userRepo.saveAndFlush(testUserEntity);
        descriptorRepo.saveAndFlush(testDescriptorEntity);
    }

    @AfterEach
    void removeUserAndCourse() {
        userRepo.delete(testUserEntity);
        descriptorRepo.delete(testDescriptorEntity);
    }

    @Test
    void repoIsNotNull() {
        assertThat(repo).isNotNull();
    }

    @Test
    public void testSave() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
    }

    @Test
    public void testRead() {
        repo.saveAndFlush(testEntity);
        response = repo.findByDescriptorAndUser(testEntity.getDescriptorName(), testEntity.getUserEmail());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testGetCoursesByUser() {
        repo.saveAndFlush(testEntity);
        descriptorResponse = repo.findDescriptorsByUser(testEntity.getUserEmail()).get(0);
        assertThat(testDescriptorEntity.equals(descriptorResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testUsersByCourse() {
        repo.saveAndFlush(testEntity);
        userResponse = repo.findUsersByDescriptor(testEntity.getDescriptorName()).get(0);
        assertThat(testUserEntity.equals(userResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByDescriptorAndUser(testEntity.getDescriptorName(), testEntity.getUserEmail());
        assertThat(response).isNull();
    }
}


