package com.afa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_course_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserCourseRelationshipEntityPK.class)
public class UserCourseRelationshipEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="course", referencedColumnName="course")
    private CourseEntity course;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name="user_email", referencedColumnName="email")
    private UserEntity user;

    public UserCourseRelationshipEntity() {
    }

    public UserCourseRelationshipEntity(UserEntity user, CourseEntity course) {
        this.user = user;
        this.course = course;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public String getCourseName() { return course.getCourse(); }

    public UserEntity getUser() { return this.user; }

    public void setUser(UserEntity newUser) { this.user = newUser; }

    public String getUserEmail() { return user.getEmail(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseRelationshipEntity that = (UserCourseRelationshipEntity) o;
        return Objects.equals(course, that.course) && Objects.equals(user, that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, user);
    }
}
