package com.dxc.reservation.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dxc.reservation.dao.IReservationDao;
import com.dxc.reservation.entities.Reservation;
import com.dxc.reservation.exceptions.InvalidArgumentException;
import com.dxc.reservation.exceptions.ReservationNotFoundException;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	private static final Logger Log = LoggerFactory.getLogger(ReservationServiceImpl.class);

	private int generatePnr() {
		Random randNum = new Random();
		int generate = randNum.nextInt(1000000);
		return generate;
	}

	@Autowired
	private IReservationDao dao;

	@Override
	public Reservation findById(Integer id) {
		Log.info("***service class,inside findResevationById ,id=" + id);
		validate(id);
		Optional<Reservation> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new ReservationNotFoundException("reservation for passanger is not found for id=" + id);
		}
		return optional.get();
	}

	/*
	 * @Override public Reservation save(Reservation reservation) {
	 * validate(reservation);servation; } int pnr = generatePnr();
	 * reservation.setPnr(pnr); reservation = dao.save(reservation); return re
	 * 
	 * @Override public Reservation update(Reservation reservation) {
	 * validate(reservation); int pnr = generatePnr(); reservation.setPnr(pnr);
	 * reservation = dao.save(reservation); return reservation; }
	 */
	@Override
	public ResponseEntity save(Reservation reservation) {

		try {
			
			int pnr = generatePnr();
			reservation.setPnr(pnr);
			dao.save(reservation);
			return new ResponseEntity("Successfully inserted!!", HttpStatus.ACCEPTED);
		} catch (Exception e) {

		}
		return new ResponseEntity("Process not completed ... Please contact the administrator!!",
				HttpStatus.METHOD_FAILURE);
	}

	@Override
	public ResponseEntity update(Reservation reservation) {

		try {
		
			int pnr = generatePnr();
			reservation.setPnr(pnr);
			dao.save(reservation);
			return new ResponseEntity("Successfully updated!!", HttpStatus.ACCEPTED);
		} catch (Exception e) {

		}
		return new ResponseEntity("Process not completed ... Please contact the administrator!!",
				HttpStatus.METHOD_FAILURE);
	}

	@Override
	public void remove(int id) {
		validate(id);

		dao.deleteById(id);
	}
	
	
//	@Override
//	public ResponseEntity remove(int id) {
//
//		try {
//			
//			dao.deleteById(id);
//			return new ResponseEntity("Successfully Deleted!!", HttpStatus.GONE);
//		} catch (Exception e) {
//
//		}
//		return new ResponseEntity("Invalid Input ... Please contact the administrator!!",
//				HttpStatus.METHOD_FAILURE);
//	}

	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is invalid");
		}
	}

	@Override
	public List<Reservation> allReservations() {
		List<Reservation> list = dao.findAll();
		return list;
	}

	@Override
	public Reservation findByPnr(int pnr) {
		validate(pnr);
		Reservation reservation = dao.findByPnr(pnr);
		return reservation;
	}

}
