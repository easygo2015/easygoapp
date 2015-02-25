package com.easygoapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Padonag on 24.02.2015.
 */
@Entity
@Table(name = "PNP")
public class PNP {
    private Long pnpId;
    private Double latitude;
    private Double longitude;
    private String description;
    private boolean isLeft;

    @ManyToMany(mappedBy = "pnps")
    private Collection<Trip> trips;

    public PNP() {
    }

    public PNP(boolean isLeft, double latitude, double longitude) {
        this.isLeft = isLeft;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "isleft", nullable = false)
    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    @Column(name = "latitude", nullable = false)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude", nullable = false)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    @Id
    @Column(name = "trip_id", nullable = false, unique = true)
    @GeneratedValue
    public Long getPnpId() {
        return pnpId;
    }

    public void setPnpId(Long pnpId) {
        this.pnpId = pnpId;
    }

    @Override
    public String toString() {
        return "PNP{" +
                "isLeft=" + isLeft +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", pnpId=" + pnpId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PNP)) return false;

        PNP pnp = (PNP) o;

        if (isLeft != pnp.isLeft) return false;
        if (description != null ? !description.equals(pnp.description) : pnp.description != null) return false;
        if (!latitude.equals(pnp.latitude)) return false;
        if (!longitude.equals(pnp.longitude)) return false;
        if (!pnpId.equals(pnp.pnpId)) return false;
        if (trips != null ? !trips.equals(pnp.trips) : pnp.trips != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pnpId.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isLeft ? 1 : 0);
        result = 31 * result + (trips != null ? trips.hashCode() : 0);
        return result;
    }
}
