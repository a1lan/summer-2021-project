package com.afa.repositories;

import com.afa.model.CourseEntity;
import com.afa.model.UserCourseRelationshipEntity;
import com.afa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCourseRelationshipRepository extends JpaRepository<UserCourseRelationshipEntity, Integer> {
    @Query("SELECT ucr FROM UserCourseRelationshipEntity ucr WHERE ucr.user.email = :email AND ucr.course.course = :course")
    UserCourseRelationshipEntity findByCourseAndUser(@Param("course") String course, @Param("email") String email);

    @Query("SELECT ucr.course FROM UserCourseRelationshipEntity ucr WHERE ucr.user.email = :email")
    List<CourseEntity> findCoursesByUser(@Param("email") String email);

    @Query("SELECT ucr.user FROM UserCourseRelationshipEntity ucr WHERE ucr.course.course = :course")
    List<UserEntity> findUsersByCourse(@Param("course") String course);
}