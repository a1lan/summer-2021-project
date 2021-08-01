package com.afa.springserver.repositories;

import com.afa.model.CourseEntity;
import com.afa.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

/**
 * Need to set up in-memory database, but too much effort right now.
 */
@SpringBootTest
class CourseRepositoryTests {

    CourseEntity testEntity = new CourseEntity("TestEntity");
    CourseEntity response;

    @Autowired
    private CourseRepository repo;

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
        response = repo.findByCourse(testEntity.getCourse());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByCourse(testEntity.getCourse());
        assertThat(response).isNull();
    }
}


