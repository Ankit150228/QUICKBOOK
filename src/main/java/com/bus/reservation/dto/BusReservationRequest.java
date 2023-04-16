package com.bus.reservation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BusReservationRequest {
	private String busNumber;
	@NotEmpty(message="FIRST NAME IS MANDATORY")
	private String firstName;
	@NotEmpty(message="LAST NAME IS MANDATORY")
	private String lastName;
	@Email(message="INVALID EMAIL")
	private String email;
	@NotEmpty
	@Size(min=10,message="PHONE NUMBER SHOULD BE 10 DIGITS")
	private String phone;
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
