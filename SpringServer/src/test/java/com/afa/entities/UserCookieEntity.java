package com.afa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_cookie", schema = "bp50_afa", catalog = "")
public class UserCookieEntity {
    private String userEmail;
    private String cookie;

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "cookie")
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCookieEntity that = (UserCookieEntity) o;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(cookie, that.cookie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, cookie);
    }
}
