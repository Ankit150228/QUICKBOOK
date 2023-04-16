package com.bus.reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.reservation.dto.BusReservationRequest;
import com.bus.reservation.entities.BusReservation;
import com.bus.reservation.service.BusReservationService;

@RestController
@RequestMapping("/api/bus/reservation")
public class BusReservationController {
	
	@Autowired
	private BusReservationService busReservationService;
	
	
	//BOOK RESERVATION OF BUS
	@PostMapping
	public ResponseEntity<?> createReservation(@Valid @RequestBody BusReservationRequest request,BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
		}else {
		try {
		BusReservation reservation = busReservationService.createReservation(request);
		return new ResponseEntity<BusReservation>(reservation,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("INVALID BUS NUMBER",HttpStatus.BAD_REQUEST);
			}
			}
		}
	
	//GET RESERVATION DETAILS USING RESERVATION ID
	@GetMapping("/{id}")
	public ResponseEntity<?>findReservation(@PathVariable("id")long id){
		try {
		BusReservation reservation = busReservationService.findReservation(id);
		return new ResponseEntity<BusReservation>(reservation,HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>("INVALID RESERVATION ID",HttpStatus.BAD_REQUEST);
			}
	}
	
	//DELETE RESERVATION DETAILS USING RESERVATION ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?>DeleteReservation(@PathVariable("id")long id){
		try {
				busReservationService.deleteReservation(id);
		return new ResponseEntity<>("RESERVATION CANCELED",HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>("INVALID RESERVATION ID",HttpStatus.BAD_REQUEST);
			}
	}
	
	//UPDATE RESERVATION DETAILS USING RESERVATION ID
	@PutMapping("/{id}")
	public ResponseEntity<?>UpdateReservation(@PathVariable("id")long id,@RequestBody BusReservationRequest request){
		try {
				busReservationService.updateReservation(id,request);
		return new ResponseEntity<>("RESERVATION UPDATED",HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>("INVALID RESERVATION ID",HttpStatus.BAD_REQUEST);
			}
	}

	
}
