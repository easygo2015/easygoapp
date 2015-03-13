package com.easygoapp.domain;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.domain.Persistable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGER_LANDING")
public class PassengerLanding implements Persistable<Long> {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "trip_passenger_id")
	private Trip trip;

	@OneToOne
	@JoinColumn(name = "passenger_id")
	private User passenger;

	@Column(name = "description", nullable = false)
	private String description;

	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return getId() == null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public User getUser() {
		return passenger;
	}

	public void setUser(User user) {
		this.passenger = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
