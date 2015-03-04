package com.easygoapp.domain;

import com.easygoapp.type.Gender;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created by Markov on 24.02.2015.
 */

@Entity
@Table(name = "USER")
public class User extends AbstractPersistable<Long>{

    @NotNull
    @Size(min = 2, message = "Длина имени должны содержать как минимум 2 символа")
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 3, message = "Длина логина должны содержать как минимум 3 символа")
    @Column(name = "login", nullable = false)
    private String login;

    @NotNull
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotNull
    @Size(min = 6, message = "Длина пароля должна содержать как минимум 6 символов")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(min = 6, message = "Длина номера телефона должна содержать как минимум 6 символов")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "car")
    private String car;

    @NotNull
    @Size(min = 6, message = "Длина электронной почты должна содержать как минимум 6 символов")
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$",
            message = "заданный имэйл не может существовать")
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "driver")
    private List<Trip> tripsWhereUserDriver;

    @ManyToMany(mappedBy = "companions")
    private List<Trip> trips;
//Security
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserRole> userRole = new ArrayList<>(0);

    public User() {
    }

    public User(Gender gender, String name, String password) {
        this.gender = gender;
        this.name = name;
        this.password = password;
    }

    public List<Trip> getTripsWhereUserDriver() {
        return tripsWhereUserDriver;
    }

    public void setTripsWhereUserDriver(List<Trip> tripsWhereUserDriver) {
        this.tripsWhereUserDriver = tripsWhereUserDriver;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", car='" + car + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    //TODO change set to list roles
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        User rhs = (User) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(rhs))
                .append(this.name, rhs.name)
                .append(this.login, rhs.login)
                .append(this.gender, rhs.gender)
                .append(this.password, rhs.password)
                .append(this.phoneNumber, rhs.phoneNumber)
                .append(this.car, rhs.car)
                .append(this.trips, rhs.trips)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(name)
                .append(login)
                .append(gender)
                .append(password)
                .append(phoneNumber)
                .append(car)
                .append(trips)
                .toHashCode();
    }
}
