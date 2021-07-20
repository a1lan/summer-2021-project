package com.afa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserCourseRelationshipEntityPK implements Serializable {
    private String course;
    private String user;


    public UserCourseRelationshipEntityPK() {
    }

    public UserCourseRelationshipEntityPK(String user, String course) {
        this.user = user;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseRelationshipEntity that = (UserCourseRelationshipEntity) o;
        return Objects.equals(course, that.getCourse()) && Objects.equals(user, that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, user);
    }
}