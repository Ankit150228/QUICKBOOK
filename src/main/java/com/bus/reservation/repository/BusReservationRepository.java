package com.bus.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.reservation.entities.BusReservation;

public interface BusReservationRepository extends JpaRepository<BusReservation,Long> {

}
