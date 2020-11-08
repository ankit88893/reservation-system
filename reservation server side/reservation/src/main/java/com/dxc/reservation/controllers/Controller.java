package com.dxc.reservation.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.reservation.dto.CreateReservationRequest;
import com.dxc.reservation.dto.ReservationDto;
import com.dxc.reservation.dto.UpdateReservationRequest;
import com.dxc.reservation.entities.Reservation;
import com.dxc.reservation.service.IReservationService;
import com.dxc.reservation.util.ReservationUtil;

@Validated
@RestController
@RequestMapping("/reservation")
public class Controller implements IController {

	private static final Logger Log = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private IReservationService service;

	@Autowired
	private ReservationUtil util;

	@Autowired
	private RestTemplate rest;

	@Override
	public ResponseEntity addPassanger(CreateReservationRequest requestData) {
		Log.info("passanger registration is done");
		String name = requestData.getName();
		long mobileNumber = requestData.getMobileNumber();
		String email = requestData.getEmail();
		String fromSource = requestData.getFromSource();
		String toDestination = requestData.getToDestination();
		String trainName = requestData.getTrainName();
		LocalDate arrivalDate = requestData.getArrivalDate();
		LocalDate departureDate = requestData.getDepartureDate();
		// int pnr = requestData.getPnr();

		Reservation reservation = new Reservation(name, mobileNumber, email, fromSource, toDestination, trainName,
				arrivalDate, departureDate);
		return service.save(reservation);
		// ReservationDto response = util.resevationDto(reservation);
		// return response;
	}

	@Override
	public List<Reservation> allPassangers() {
		List<Reservation> list = service.allReservations();
		return list;

	}

//	@Override
//	public ResponseEntity DeleteUserById(Integer id) {
//		return service.remove(id);
//	}
	
	@Override
	public void DeleteUserById(Integer id) {
		service.remove(id);
		
	}

	@Override
	public Reservation findPassangerById(Integer id) {
		Log.info("deleted test id is:-" + id);
		Reservation reservation = service.findById(id);
		return reservation;
	}

	@Override
	public Reservation findByPnr(Integer pnr) {
		Reservation reservation = service.findByPnr(pnr);

		return reservation;
	}

	@Override
	public ResponseEntity updatePassanger(UpdateReservationRequest requestData) {

		Log.info("passangerupdation is done");

		int id = requestData.getId();
		String name = requestData.getName();
		long mobileNumber = requestData.getMobileNumber();
		String email = requestData.getEmail();
		String fromSource = requestData.getFromSource();
		String toDestination = requestData.getToDestination();
		String trainName = requestData.getTrainName();
		LocalDate arrivalDate = requestData.getArrivalDate();
		LocalDate departureDate = requestData.getDepartureDate();
		// int pnr = requestData.getPnr();
		Reservation reservation = new Reservation(name, mobileNumber, email, fromSource, toDestination, trainName,
				arrivalDate, departureDate);

		// reservation.setPnr(pnr);
		reservation.setId(id);
		return service.update(reservation);

	}

}
