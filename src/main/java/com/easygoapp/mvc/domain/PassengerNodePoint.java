package com.easygoapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Padonag on 24.02.2015.
 */
@Entity
@Table(name = "PNP")
public class PassengerNodePoint {

    @Id
    @Column(name = "trip_id", nullable = false, unique = true)
    @GeneratedValue
    private Long id;
    @Column(name = "latitude", nullable = false)
    private Double latitude;
    @Column(name = "longitude", nullable = false)
    private Double longitude;
    @Column(name = "description")
    private String description;
    @Column(name = "isleft", nullable = false)
    private boolean isLeft;

    @ManyToMany(mappedBy = "pnps")
    private Collection<Trip> trips;

    public PassengerNodePoint() {
    }

    public PassengerNodePoint(boolean isLeft, double latitude, double longitude) {
        this.isLeft = isLeft;
        this.latitude = latitude;
        this.longitude = longitude;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerNodePoint)) return false;

        PassengerNodePoint passengerNodePoint = (PassengerNodePoint) o;

        if (isLeft != passengerNodePoint.isLeft) return false;
        if (description != null ? !description.equals(passengerNodePoint.description) : passengerNodePoint.description != null) return false;
        if (!latitude.equals(passengerNodePoint.latitude)) return false;
        if (!longitude.equals(passengerNodePoint.longitude)) return false;
        if (!id.equals(passengerNodePoint.id)) return false;
        if (trips != null ? !trips.equals(passengerNodePoint.trips) : passengerNodePoint.trips != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isLeft ? 1 : 0);
        result = 31 * result + (trips != null ? trips.hashCode() : 0);
        return result;
    }
}
