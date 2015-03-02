package com.easygoapp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Markov on 24.02.2015.
 */
@Entity
@Table(name = "PNP")
public class PassengerNodePoint implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(name = "latitude", nullable = false)
    private Double latitude;
    @Column(name = "longitude", nullable = false)
    private Double longitude;
    @Column(name = "description")
    private String description;
    @Column(name = "isleft", nullable = false)
    private boolean isLeft;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TRIP_POINTS",
            joinColumns = {@JoinColumn(name = "pnp_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "trip_id")})
    private Collection<Trip> trips;

    public PassengerNodePoint() {
    }

    public PassengerNodePoint(boolean isLeft, double latitude, double longitude) {
        this.isLeft = isLeft;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Collection<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Collection<Trip> trips) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PNP{" +
                "isLeft=" + isLeft +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", id=" + id +
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
                .append(this.id, rhs.id)
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
                .append(id)
                .append(latitude)
                .append(longitude)
                .append(description)
                .append(isLeft)
                .append(trips)
                .toHashCode();
    }
}
