package com.afa.springserver.repositories;

import com.afa.model.CourseEntity;
import com.afa.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class CourseRepositoryTests implements RepositoryTestInterface {

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


