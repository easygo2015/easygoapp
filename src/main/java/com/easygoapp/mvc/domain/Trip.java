package com.easygoapp.mvc.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Markov on 24.02.2015.
 */
@Entity
@Table(name = "TRIP")
public class Trip implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(name = "start_trip", nullable = false)
    private Timestamp startTime;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User driver;

    @Column(name = "car_capacity", nullable = false)
    private Integer carCapacity;
    @Column(name = "price")
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RATIO",
            joinColumns = {@JoinColumn(name = "trip_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Collection<User> companions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TRIP_POINTS",
            joinColumns = {@JoinColumn(name = "trip_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "pnp_id")})
    private Collection<PassengerNodePoint> passengerNodePoints;

    public Collection<PassengerNodePoint> getPassengerNodePoints() {

        return passengerNodePoints;
    }

    public void setPassengerNodePoints(Collection<PassengerNodePoint> passengerNodePoints) {
        this.passengerNodePoints = passengerNodePoints;
    }

    public Collection<User> getCompanions() {
        return companions;
    }

    public void setCompanions(Collection<User> companions) {
        this.companions = companions;
    }

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "carCapacity=" + carCapacity +
                ", id=" + id +
                ", startTime=" + startTime +
                ", driver=" + driver +
                ", price=" + price +
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
        Trip rhs = (Trip) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.startTime, rhs.startTime)
                .append(this.driver, rhs.driver)
                .append(this.carCapacity, rhs.carCapacity)
                .append(this.price, rhs.price)
                .append(this.passengerNodePoints, rhs.passengerNodePoints)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(startTime)
                .append(driver)
                .append(carCapacity)
                .append(price)
                .append(passengerNodePoints)
                .toHashCode();
    }
}
