package com.easygoapp.domain;

import com.easygoapp.type.Gender;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Markov on 24.02.2015.
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "car")
    private String car;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "driver")
    private List<Trip> tripsWhereUserDriver;

    @ManyToMany(mappedBy = "companions")
    private List<Trip> trips;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", car='" + car + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


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
                .append(this.id, rhs.id)
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
                .append(id)
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
