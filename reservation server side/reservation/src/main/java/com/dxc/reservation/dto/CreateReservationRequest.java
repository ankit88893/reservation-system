package com.dxc.reservation.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateReservationRequest {
	@NotBlank
	private String name;
	
	//@Size(min=10,max=12)
	private long mobileNumber;
	@Email
	private String email;
	@NotBlank
	private String fromSource;
	@NotBlank
	private String toDestination;
	@NotBlank
	private String trainName;
	
	private LocalDate arrivalDate;
	// here validation is done automatically by LocalDate
	private LocalDate departureDate;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFromSource() {
		return fromSource;
	}

	public void setFromSource(String fromSource) {
		this.fromSource = fromSource;
	}

	public String getToDestination() {
		return toDestination;
	}

	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	
}
