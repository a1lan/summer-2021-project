package com.afa.springserver.repositories;

import com.afa.model.PersonalDescriptorEntity;
import com.afa.repositories.PersonalDescriptorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class PersonalDescriptorRepositoryTests implements RepositoryTestInterface {

    PersonalDescriptorEntity testEntity = new PersonalDescriptorEntity("TestEntity");
    PersonalDescriptorEntity response;

    @Autowired
    private PersonalDescriptorRepository repo;

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
        response = repo.findByDescriptor(testEntity.getDescriptor());
        assertThat(testEntity.equals(response));
        repo.delete(testEntity);
    }

    @Test
    public void testDrop() {
        repo.saveAndFlush(testEntity);
        repo.delete(testEntity);
        response = repo.findByDescriptor(testEntity.getDescriptor());
        assertThat(response).isNull();
    }
}


