package com.afa.springserver.repositories;

import com.afa.model.HobbyEntity;
import com.afa.model.PersonalDescriptorEntity;
import com.afa.repositories.HobbyRepository;
import com.afa.repositories.PersonalDescriptorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Need to set up in-memory database, but too much effort right now.
 */
@SpringBootTest
class HobbyRepositoryTests {

    HobbyEntity testEntity = new HobbyEntity("TestEntity");
    HobbyEntity response;

    @Autowired
    private HobbyRepository repo;

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
        response = repo.findByHobby(testEntity.getHobby());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByHobby(testEntity.getHobby());
        assertThat(response).isNull();
    }
}


