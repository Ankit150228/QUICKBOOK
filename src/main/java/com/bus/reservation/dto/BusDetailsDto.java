package com.bus.reservation.dto;

import java.time.LocalDateTime;

public class BusDetailsDto {
	private long id;
	private String busNumber;
	private String operatingBus;
	private String departureCity;
	private String arrivalCity;
	private LocalDateTime dateOfDeparture;
	private LocalDateTime estimatedDepartureTime;
	private String fare;
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
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
