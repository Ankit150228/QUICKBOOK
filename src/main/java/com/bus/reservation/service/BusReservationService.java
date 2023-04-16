package com.bus.reservation.service;

import com.bus.reservation.dto.BusReservationRequest;
import com.bus.reservation.entities.BusReservation;

public interface BusReservationService {

	BusReservation createReservation(BusReservationRequest request);

	BusReservation findReservation(long id);

	BusReservation deleteReservation(long id);

	void updateReservation(long id, BusReservationRequest request);

	

}
