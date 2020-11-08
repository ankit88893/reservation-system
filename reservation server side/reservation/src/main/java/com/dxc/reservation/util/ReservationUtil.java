package com.dxc.reservation.util;

import org.springframework.stereotype.Component;

import com.dxc.reservation.dto.ReservationDto;
import com.dxc.reservation.entities.Reservation;

@Component
public class ReservationUtil {

	public ReservationDto resevationDto(Reservation reservation) {
		ReservationDto dto = new ReservationDto(reservation.getId(), reservation.getName(),
				reservation.getMobileNumber(), reservation.getEmail(), reservation.getFromSource(), reservation.getToDestination(),
				reservation.getTrainName(), reservation.getArrivalDate(), reservation.getDepartureDate(),reservation.getPnr());
		return dto;
	}

}
