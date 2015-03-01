package com.easygoapp.mvc.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Padonag on 24.02.2015.
 */
@Entity
@Table(name = "TRIP")
public class Trip implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_trip", nullable = false)
    private Timestamp startTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private User driver;
    @Column(name = "car_capacity", nullable = false)
    private Integer carCapacity;
    @Column(name = "price")
    private Double price;
    @JoinTable(name = "TRIP_POINTS",
            joinColumns = {@JoinColumn(name = "trip_id")},
            inverseJoinColumns = {@JoinColumn(name = "pnp_id")})
    @JoinColumn(name = "trip_id")
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<PassengerNodePoint> passengerNodePoints;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;

        Trip trip = (Trip) o;

        if (!carCapacity.equals(trip.carCapacity)) return false;
        if (!driver.equals(trip.driver)) return false;
        if (!id.equals(trip.id)) return false;
        if (!passengerNodePoints.equals(trip.passengerNodePoints)) return false;
        if (price != null ? !price.equals(trip.price) : trip.price != null) return false;
        if (!startTime.equals(trip.startTime)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + driver.hashCode();
        result = 31 * result + carCapacity.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + passengerNodePoints.hashCode();
        return result;
    }
}
