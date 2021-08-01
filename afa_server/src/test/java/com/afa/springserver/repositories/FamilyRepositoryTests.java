package com.afa.springserver.repositories;

import com.afa.model.FamilyEntity;
import com.afa.repositories.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class FamilyRepositoryTests implements RepositoryTestInterface {
    FamilyEntity testEntity = new FamilyEntity("test");
    FamilyEntity response;

    @Autowired
    private FamilyRepository repo;

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
        response = repo.findByName(testEntity.getName());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByName(testEntity.getName());
        assertThat(response).isNull();
    }
}


