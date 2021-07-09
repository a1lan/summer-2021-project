package com.family_server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_cookie")
public class UserCookie implements Serializable {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private User user;
}