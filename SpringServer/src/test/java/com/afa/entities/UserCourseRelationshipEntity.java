package com.afa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_course_relationship", schema = "bp50_afa", catalog = "")
@IdClass(UserCourseRelationshipEntityPK.class)
public class UserCourseRelationshipEntity {
    private String course;
    private String userEmail;

    @Id
    @Column(name = "course")
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseRelationshipEntity that = (UserCourseRelationshipEntity) o;
        return Objects.equals(course, that.course) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, userEmail);
    }
}
