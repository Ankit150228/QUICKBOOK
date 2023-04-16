package com.bus.reservation.service;

import java.util.List;

import com.bus.reservation.dto.BusDetailsDto;
import com.bus.reservation.entities.BusDetails;
import com.bus.reservation.entities.Passenger;
import com.bus.reservation.search.SearchCriteria;

public interface BusDetailsService {

	public BusDetailsDto createBusDetail(BusDetailsDto busDetailsDto);

	public List<BusDetailsDto> getAllBusDetail();

	public BusDetailsDto findBusDetail(String busNumber);
	
	public BusDetailsDto updateBusDetail(long id,BusDetailsDto busDetailsDto);

	public void deleteBusDetail(long id);

	public List<BusDetails> findBus(SearchCriteria search);

	public List<Passenger> getAllPassengers(String busNumber);

	

}
