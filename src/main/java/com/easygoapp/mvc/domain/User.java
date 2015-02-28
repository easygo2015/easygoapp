package com.easygoapp.mvc.domain;

import com.easygoapp.mvc.type.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Padonag on 24.02.2015.
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver_id")
    private List<Trip> trips;

    public User() {
    }

    public User(Gender gender, String name, String password) {
        this.gender = gender;
        this.name = name;
        this.password = password;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (car != null ? !car.equals(user.car) : user.car != null) return false;
        if (gender != user.gender) return false;
        if (!id.equals(user.id)) return false;
        if (!login.equals(user.login)) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (!password.equals(user.password)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (trips != null ? !trips.equals(user.trips) : user.trips != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + login.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (trips != null ? trips.hashCode() : 0);
        return result;
    }
}
