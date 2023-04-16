package com.bus.reservation.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BusReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Passenger passenger;
	@OneToOne
	private BusDetails busDetails;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public BusDetails getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}
	
}
