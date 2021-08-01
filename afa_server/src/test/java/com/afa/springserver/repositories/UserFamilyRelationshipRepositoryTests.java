package com.afa.springserver.repositories;

import com.afa.enums.FamilyRole;
import com.afa.enums.FamilySize;
import com.afa.model.FamilyEntity;
import com.afa.model.UserEntity;
import com.afa.model.UserFamilyRelationshipEntity;
import com.afa.repositories.FamilyRepository;
import com.afa.repositories.UserFamilyRelationshipRepository;
import com.afa.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UserFamilyRelationshipRepositoryTests implements RepositoryTestInterface {

    UserEntity testUserEntity = new UserEntity("TestEntity@aol.com", "test", LocalDate.now(), FamilySize.SMALL);
    UserEntity userResponse;

    FamilyEntity testFamilyEntity = new FamilyEntity("TestEntity");
    FamilyEntity familyResponse;

    FamilyRole testRole = FamilyRole.PARENT;

    UserFamilyRelationshipEntity testEntity = new UserFamilyRelationshipEntity(testUserEntity, testFamilyEntity, FamilyRole.PARENT);
    UserFamilyRelationshipEntity response;

    @Autowired
    private UserFamilyRelationshipRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FamilyRepository familyRepo;

    @BeforeEach
    void addUserAndCourse() {
        userRepo.saveAndFlush(testUserEntity);
        familyRepo.saveAndFlush(testFamilyEntity);
    }

    @AfterEach
    void removeUserAndCourse() {
        userRepo.delete(testUserEntity);
        familyRepo.delete(testFamilyEntity);
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
        response = repo.findByFamilyAndUser(testEntity.getFamilyName(), testEntity.getUserEmail());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testGetCoursesByUser() {
        repo.saveAndFlush(testEntity);
        familyResponse = repo.findFamiliesByUser(testEntity.getUserEmail()).get(0);
        assertThat(testFamilyEntity.equals(familyResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testUsersByCourse() {
        repo.saveAndFlush(testEntity);
        userResponse = repo.findUsersByFamily(testEntity.getFamilyName()).get(0);
        assertThat(testUserEntity.equals(userResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testUsersByRoleAndFamily() {
        repo.saveAndFlush(testEntity);
        userResponse = repo.findUsersByFamilyAndRole(testEntity.getFamilyName(),testRole).get(0);
        assertThat(testUserEntity.equals(userResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByFamilyAndUser(testEntity.getFamilyName(), testEntity.getUserEmail());
        assertThat(response).isNull();
    }
}


