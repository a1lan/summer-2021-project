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

    public String getCourse() {
        return course.getCourse();
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public CourseEntity getCourseEntity() { return this.course; }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserEmail(UserEntity newUser) {
        this.user = newUser;
    }

    public UserEntity getUserEntity() { return this.user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseRelationshipEntity that = (UserCourseRelationshipEntity) o;
        return Objects.equals(course, that.course) && Objects.equals(user.getEmail(), that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, user.getEmail());
    }
}
