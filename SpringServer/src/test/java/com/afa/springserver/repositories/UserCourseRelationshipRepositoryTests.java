package com.afa.springserver.repositories;

import com.afa.model.CourseEntity;
import com.afa.model.FamilySize;
import com.afa.model.UserCourseRelationshipEntity;
import com.afa.model.UserEntity;
import com.afa.repositories.CourseRepository;
import com.afa.repositories.UserCourseRelationshipRepository;
import com.afa.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Need to set up in-memory database, but too much effort right now.
 */
@SpringBootTest
class UserCourseRelationshipRepositoryTests {

    UserEntity testUserEntity = new UserEntity("TestEntity@aol.com", "test", LocalDate.now(), FamilySize.SMALL);
    UserEntity userResponse;

    CourseEntity testCourseEntity = new CourseEntity("TestEntity");
    CourseEntity courseResponse;

    UserCourseRelationshipEntity testEntity = new UserCourseRelationshipEntity(testUserEntity, testCourseEntity);
    UserCourseRelationshipEntity response;

    @Autowired
    private UserCourseRelationshipRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired CourseRepository courseRepo;

    @BeforeEach
    void addUserAndCourse() {
        userRepo.saveAndFlush(testUserEntity);
        courseRepo.saveAndFlush(testCourseEntity);
    }

    @AfterEach
    void removeUserAndCourse() {
        userRepo.delete(testUserEntity);
        courseRepo.delete(testCourseEntity);
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
        response = repo.findByCourseAndUser(testEntity.getCourseName(), testEntity.getUserEmail());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testGetCoursesByUser() {
        repo.saveAndFlush(testEntity);
        courseResponse = repo.findCoursesByUser(testEntity.getUserEmail()).get(0);
        assertThat(testCourseEntity.equals(courseResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testUsersByCourse() {
        repo.saveAndFlush(testEntity);
        userResponse = repo.findUsersByCourse(testEntity.getCourseName()).get(0);
        assertThat(testUserEntity.equals(userResponse));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByCourseAndUser(testEntity.getCourseName(), testEntity.getUserEmail());
        assertThat(response).isNull();
    }
}


