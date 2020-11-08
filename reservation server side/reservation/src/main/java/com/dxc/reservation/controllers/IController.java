package com.dxc.reservation.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dxc.reservation.dto.CreateReservationRequest;
import com.dxc.reservation.dto.ReservationDto;
import com.dxc.reservation.dto.UpdateReservationRequest;
import com.dxc.reservation.entities.Reservation;

public interface IController {

	@PostMapping("/addpassanger")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity addPassanger(@RequestBody @Valid @NotNull CreateReservationRequest requestData);

	@PutMapping("/update")
	public ResponseEntity updatePassanger(@RequestBody @Valid @NotNull UpdateReservationRequest requestData);

	@GetMapping("/bypnr/{pnr}")
	public Reservation findByPnr(@Valid @NotNull @PathVariable("pnr") Integer pnr);

	@GetMapping("/get/{id}")
	public Reservation findPassangerById(@Valid @NotNull @PathVariable("id") Integer id);
//
//	@DeleteMapping("/delete/{id}")
//	public  ResponseEntity DeleteUserById(@Valid @NotNull @PathVariable("id") Integer id);

	@GetMapping("/allpassanger")
	public List<Reservation> allPassangers();
	

	@DeleteMapping("/delete/{id}")
	public  void DeleteUserById(@Valid @NotNull @PathVariable("id") Integer id);

	
	
}
