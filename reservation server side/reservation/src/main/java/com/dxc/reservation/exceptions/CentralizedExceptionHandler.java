package com.dxc.reservation.exceptions;

import org.springframework.http.HttpStatus;  

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleReservationNotFound(ReservationNotFoundException e){
        System.out.println("inside handleReservationtNotFound");
        String msg=e.getMessage();
        return msg;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidArgument(InvalidArgumentException e){
        System.out.println("inside handleInvalidArgument");
        return e.getMessage();
    }
}
