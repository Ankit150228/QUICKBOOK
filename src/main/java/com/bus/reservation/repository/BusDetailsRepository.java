package com.bus.reservation.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.reservation.entities.BusDetails;

public interface BusDetailsRepository extends JpaRepository<BusDetails,Long> {
	
	public Optional<BusDetails>findByBusNumber(String busNumber);
	
	@Transactional
	@Modifying
	@Query("from BusDetails where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	public List<BusDetails> findBus(@Param("departureCity")String from,@Param("arrivalCity") String to,@Param("dateOfDeparture")LocalDateTime departureDate);
}
