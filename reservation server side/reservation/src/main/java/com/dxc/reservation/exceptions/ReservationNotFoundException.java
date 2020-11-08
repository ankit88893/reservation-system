package com.dxc.reservation.exceptions;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String msg){
        super(msg);
    }

}
