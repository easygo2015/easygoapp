package com.easygoapp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Markov on 24.02.2015.
 */
@Entity
@Table(name = "PNP")
public class PassengerNodePoint extends AbstractPersistable<Long> {

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "description")
    private String description;

    @Column(name = "isleft", nullable = false)
    private boolean isLeft;

    @ManyToMany(mappedBy = "passengerNodePoints")
    private List<Trip> trips;

    public PassengerNodePoint() {
    }

    public PassengerNodePoint(boolean isLeft, double latitude, double longitude) {
        this.isLeft = isLeft;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PNP{" +
                "isLeft=" + isLeft +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", id=" + getId() +
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
        PassengerNodePoint rhs = (PassengerNodePoint) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(rhs))
                .append(this.latitude, rhs.latitude)
                .append(this.longitude, rhs.longitude)
                .append(this.description, rhs.description)
                .append(this.isLeft, rhs.isLeft)
                .append(this.trips, rhs.trips)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(super.hashCode())
                .append(latitude)
                .append(longitude)
                .append(description)
                .append(isLeft)
                .append(trips)
                .toHashCode();
    }
}
