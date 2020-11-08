package com.dxc.reservation.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private long mobileNumber;
	private String email;
	private String fromSource;
	private String toDestination;
	private String trainName;
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private int pnr;

	public Reservation() {

	}

	public Reservation(String name, long mobileNumber, String email, String fromSource, String toDestination,
			String trainName, LocalDate arrivalDate, LocalDate departureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.email = email;
		this.fromSource = fromSource;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.toDestination = toDestination;
		this.trainName = trainName;
		// this.pnr=pnr;

	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Reservation that = (Reservation) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
