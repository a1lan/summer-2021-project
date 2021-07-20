package com.afa.springserver.repositories;

import com.afa.model.CourseEntity;
import com.afa.model.FamilySize;
import com.afa.model.UserEntity;
import com.afa.repositories.CourseRepository;
import com.afa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Need to set up in-memory database, but too much effort right now.
 */
@SpringBootTest
class UserRepositoryTests {
    UserEntity testEntity = new UserEntity("TestEntity@aol.com", "test", LocalDate.now(), FamilySize.SMALL);
    UserEntity response;

    @Autowired
    private UserRepository repo;

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
        response = repo.findByEmailIs(testEntity.getEmail());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByEmailIs(testEntity.getEmail());
        assertThat(response).isNull();
    }
}


