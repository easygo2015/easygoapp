package com.easygoapp.mvc.domain;

import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Created by Padonag on 24.02.2015.
 */
public class PNP {
    private Long pnpId;
    private double latitude;
    private double longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Long getPnpId() {
        return pnpId;
    }

    public void setPnpId(Long pnpId) {
        this.pnpId = pnpId;
    }
}
