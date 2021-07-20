package com.afa.springserver.repositories;

import com.afa.enums.FamilySize;
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
class UserHobbyRelationshipRepositoryTests {

    UserEntity testUserEntity = new UserEntity("TestEntity@aol.com", "test", LocalDate.now(), FamilySize.SMALL);
    UserEntity userResponse;

    HobbyEntity testHobbyEntity = new HobbyEntity("TestEntity");
    HobbyEntity hobbyResponse;

    UserHobbyRelationshipEntity testEntity = new UserHobbyRelationshipEntity(testUserEntity, testHobbyEntity);
    UserHobbyRelationshipEntity response;

    @Autowired
    private UserHobbyRelationshipRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    HobbyRepository hobbyRepo;

    @BeforeEach
    void addUserAndCourse() {
        userRepo.saveAndFlush(testUserEntity);
        hobbyRepo.saveAndFlush(testHobbyEntity);
    }

    @AfterEach
    void removeUserAndCourse() {
        userRepo.delete(testUserEntity);
        hobbyRepo.delete(testHobbyEntity);
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
        response = repo.findByHobbyAndUser(testEntity.getHobbyName(), testEntity.getUserEmail());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testGetCoursesByUser() {
        repo.saveAndFlush(testEntity);
        hobbyResponse = repo.findHobbiesByUser(testEntity.getUserEmail()).get(0);
        assertThat(testHobbyEntity.equals(hobbyResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testUsersByCourse() {
        repo.saveAndFlush(testEntity);
        userResponse = repo.findUsersByHobby(testEntity.getHobbyName()).get(0);
        assertThat(testUserEntity.equals(userResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByHobbyAndUser(testEntity.getHobbyName(), testEntity.getUserEmail());
        assertThat(response).isNull();
    }
}


