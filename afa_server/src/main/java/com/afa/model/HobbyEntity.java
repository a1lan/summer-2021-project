package com.afa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "hobby", schema = "bp50_afa", catalog = "")
public class HobbyEntity {
    @Id
    @Column(name = "hobby")
    private String hobby;

    public HobbyEntity() {
    }

    public HobbyEntity(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HobbyEntity that = (HobbyEntity) o;
        return Objects.equals(hobby, that.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobby);
    }
}
