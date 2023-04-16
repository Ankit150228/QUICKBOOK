package com.bus.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.repository.BusDetailsRepository;
import com.bus.reservation.repository.BusReservationRepository;
import com.bus.reservation.repository.PassengerRepository;
import com.bus.reservation.dto.BusReservationRequest;
import com.bus.reservation.entities.BusDetails;
import com.bus.reservation.entities.BusReservation;
import com.bus.reservation.entities.Passenger;
import com.bus.reservation.util.EmailUtil;
import com.bus.reservation.util.PdfGenerator;

@Service
public class BusReservationServiceImpl implements BusReservationService {

	@Autowired
	private BusReservationRepository busReservationRepo;
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private BusDetailsRepository busRepo;
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public BusReservation createReservation(BusReservationRequest request) {
	
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passenger.setBusNumber(request.getBusNumber());
		
		passengerRepo.save(passenger);
		
		String busNumber = request.getBusNumber();
		BusDetails busDetails = busRepo.findByBusNumber(busNumber).get();
		
		BusReservation busReservation=new BusReservation();
		busReservation.setPassenger(passenger);
		busReservation.setBusDetails(busDetails);
		
		busReservationRepo.save(busReservation);
		
		String filePath="F:\\STS CODE\\QuickBook\\ticket\\"+request.getFirstName()+busReservation.getId()+".pdf";
		
		pdfGenerator.generatePDF(filePath,request.getFirstName(),request.getLastName(),request.getEmail(),request.getPhone(),busDetails.getBusNumber(),busDetails.getFare(),
				 			busDetails.getDateOfDeparture(),busDetails.getDepartureCity(),busDetails.getArrivalCity(),busDetails.getOperatingBus(),
				 			busReservation.getId());
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return busReservation;
	}

	@Override
	public BusReservation findReservation(long id) {
		BusReservation busReservation = busReservationRepo.findById(id).get();
		return busReservation;
	}

	@Override
	public BusReservation deleteReservation(long id) {
		busReservationRepo.deleteById(id);
		return null;
	}

	@Override
	public void updateReservation(long id, BusReservationRequest request) {
		Passenger passenger = passengerRepo.findById(id).get();
		
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
	}

	
	

}
