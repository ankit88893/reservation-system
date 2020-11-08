package com.dxc.reservation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dxc.reservation.entities.Reservation;

public interface IReservationService {

//	Reservation save(Reservation reservation);

	void remove(int id);

	List<Reservation> allReservations();

	//Reservation update(Reservation reservation);

	Reservation findById(Integer id);

	Reservation findByPnr(int pnr);
	
	ResponseEntity save (Reservation reservation);
	ResponseEntity update (Reservation reservation);
	//ResponseEntity remove(int id);
}
