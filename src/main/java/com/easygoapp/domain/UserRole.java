package com.easygoapp.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Created by Kir Kolesnikov on 04.03.2015.
 */
@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint
                                                (columnNames = { "role", "login" }))
public class UserRole extends AbstractPersistable<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login", nullable = false)
    private User user;

    @Column(name = "role", nullable = false)
    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
