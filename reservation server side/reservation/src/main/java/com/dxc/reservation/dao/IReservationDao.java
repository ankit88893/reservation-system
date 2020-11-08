package com.dxc.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
//import org.springframework.data.jpa.repository.Query;

import com.dxc.reservation.entities.Reservation;

public interface IReservationDao extends JpaRepository<Reservation,Integer> {
	
	
	 // @Query(value = "SELECT * FROM reservations WHERE email = ?0", nativeQuery = true)
	
	  Reservation findByPnr(int pnr);


}
