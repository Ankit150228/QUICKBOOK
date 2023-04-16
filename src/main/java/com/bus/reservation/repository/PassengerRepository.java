package com.bus.reservation.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.reservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
	@Transactional
	@Modifying
	@Query("from Passenger where busNumber=:busNumber")
	List<Passenger>getAllPassenger(@Param("busNumber")String busNumber);

}
