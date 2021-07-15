package com.afa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "bp50_afa", catalog = "")
public class CourseEntity implements Serializable {
    @Id
    @Column(name = "course")
    private String course;

    public CourseEntity() {

    }

    public CourseEntity(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
