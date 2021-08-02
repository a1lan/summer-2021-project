package com.afa.repositories;

import com.afa.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    CourseEntity findByCourse(String name);
}