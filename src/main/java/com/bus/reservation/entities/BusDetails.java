package com.bus.reservation.entities;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus_details")
public class BusDetails implements  Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 @Column(nullable=false)
	private String busNumber;
	 @Column(nullable=false)
	private String operatingBus;
	 @Column(nullable=false)
	private String departureCity;
	 @Column(nullable=false)
	private String arrivalCity;
	 @Column(nullable=false)
	private String fare;
	
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	private LocalDateTime dateOfDeparture;
	private LocalDateTime estimatedDepartureTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getOperatingBus() {
		return operatingBus;
	}
	public void setOperatingBus(String operatingBus) {
		this.operatingBus = operatingBus;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public LocalDateTime getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(LocalDateTime dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public LocalDateTime getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(LocalDateTime estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
}
