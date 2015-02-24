package com.easygoapp.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Padonag on 24.02.2015.
 */
@Entity
@Table(name = "TRIP")
public class Trip {
    private Long id;
    private Date startTime;
    private User driver;
    private Integer carCapacity;
    private Double price;

    @JoinTable(name = "TRIP_POINTS")
    @ManyToMany
    private Collection<PNP> pnps;

    @Column(name = "car_capacity", nullable = false)
    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    @OneToOne
    @JoinColumn(name="user_id", unique= true, nullable=true, insertable=true, updatable=true)
    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }


    @Id
    @Column(name = "trip_id", nullable = false)
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "start_trip", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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
        return result;
    }
}
