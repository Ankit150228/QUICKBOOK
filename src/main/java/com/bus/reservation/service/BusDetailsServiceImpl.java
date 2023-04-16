package com.bus.reservation.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.repository.BusDetailsRepository;
import com.bus.reservation.repository.PassengerRepository;
import com.bus.reservation.dto.BusDetailsDto;
import com.bus.reservation.entities.BusDetails;
import com.bus.reservation.entities.Passenger;
import com.bus.reservation.search.SearchCriteria;

@Service
public class BusDetailsServiceImpl implements BusDetailsService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BusDetailsRepository busDetailsRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Override
	public BusDetailsDto createBusDetail(BusDetailsDto busDetailsDto) {
		BusDetails busDetails = mapToEntity(busDetailsDto);
		BusDetails details = busDetailsRepo.save(busDetails);
		BusDetailsDto dto = mapToDto(details);
		return dto;
	}
	@Override
	public List<BusDetailsDto> getAllBusDetail() {
		List<BusDetails> findAll = busDetailsRepo.findAll();
		List<BusDetailsDto> lists = findAll.stream().map(x->mapToDto(x)).collect(Collectors.toList());
		return lists;
	}
	@Override
	public BusDetailsDto findBusDetail(String busNumber) {
		
		Optional<BusDetails> details = busDetailsRepo.findByBusNumber(busNumber);
		 BusDetails busDetails = details.get();
		return mapToDto(busDetails);
	}
	@Override
	public BusDetailsDto updateBusDetail(long id,BusDetailsDto busDetailsDto) {
		 BusDetails busDetails = busDetailsRepo.findById(id).get();
		 busDetails.setArrivalCity(busDetailsDto.getArrivalCity());
		 busDetails.setDepartureCity(busDetailsDto.getDepartureCity());
		 busDetails.setBusNumber(busDetailsDto.getBusNumber());
		 busDetails.setDateOfDeparture(busDetailsDto.getDateOfDeparture());
		 busDetails.setEstimatedDepartureTime(busDetailsDto.getEstimatedDepartureTime());
		 busDetails.setOperatingBus(busDetailsDto.getOperatingBus());
		 
		 return mapToDto(busDetailsRepo.save(busDetails));
	}
	@Override
	public void deleteBusDetail(long id) {
		 busDetailsRepo.findById(id).get();
		busDetailsRepo.deleteById(id);
	}
	
	
	public BusDetails mapToEntity(BusDetailsDto busDetailsDto) {
		BusDetails busDetails = mapper.map(busDetailsDto, BusDetails.class);
		return busDetails;
	}
	
	public BusDetailsDto mapToDto(BusDetails busDetails) {
		 BusDetailsDto busDetailsDto = mapper.map(busDetails, BusDetailsDto.class);
		return busDetailsDto;
	}
	@Override
	public List<BusDetails> findBus(SearchCriteria search) {
		List<BusDetails> findBus = busDetailsRepo.findBus(search.getFrom(),search.getTo(),search.getDepartureDate());
		return findBus;
	}
	@Override
	public List<Passenger> getAllPassengers(String busNumber) {
		List<Passenger> allPassenger = passengerRepo.getAllPassenger(busNumber);
		return allPassenger;
	}
	
	
	
	

	

}
