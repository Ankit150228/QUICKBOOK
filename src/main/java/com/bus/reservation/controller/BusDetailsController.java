package com.bus.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.reservation.dto.BusDetailsDto;
import com.bus.reservation.entities.BusDetails;
import com.bus.reservation.entities.Passenger;
import com.bus.reservation.search.SearchCriteria;
import com.bus.reservation.service.BusDetailsService;

@RestController
@RequestMapping("/api/bus")
public class BusDetailsController {
		@Autowired
		private BusDetailsService busDetailsService;
		
		//ENTER THE DETAILS OF THE BUS
		@PostMapping
		public ResponseEntity<BusDetailsDto>createBusDetail(@RequestBody BusDetailsDto busDetailsDto){
			BusDetailsDto dto = busDetailsService.createBusDetail( busDetailsDto);
			return new ResponseEntity<>(dto,HttpStatus.CREATED);
		}
		
		//GET THE LIST OF ALL THE BUSES AND IT'S DETAILS
		@GetMapping
		public List<BusDetailsDto>getAllBusDetail(){
		List<BusDetailsDto> allBusDetail = busDetailsService.getAllBusDetail();
		return allBusDetail;
		}
		
		//GET THE DETAILS OF BUS USING BUS NUMBER
		@GetMapping("/{busNumber}")
		public ResponseEntity<?>getBusDetail(@PathVariable("busNumber")String busNumber){
		    try {
			BusDetailsDto dto = busDetailsService.findBusDetail(busNumber);
			return new ResponseEntity<>(dto,HttpStatus.FOUND);
		    }catch(Exception e) {
		    	return new ResponseEntity<>("BUS DETAILS NOT FOUND",HttpStatus.NOT_FOUND);
		    }
		}
		
		//UPDATE THE DETAILS OF BUS USING BUS NUMBER
		@PutMapping("/{id}")
		public ResponseEntity<?>updateBusDetail(@PathVariable("id")long id,@RequestBody BusDetailsDto busDetailsDto){
			try {
			BusDetailsDto dto = busDetailsService.updateBusDetail(id,busDetailsDto);
			return new ResponseEntity<>(dto,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>("BUS DETAILS NOT FOUND",HttpStatus.NOT_FOUND);
			}
			}
		
		//DELETE THE DETAILS OF BUS USING BUS NUMBER
		@DeleteMapping("/{id}")
		public ResponseEntity<String>deleteBusDetail(@PathVariable("id")long id){
			try {
			busDetailsService.deleteBusDetail(id);
			return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
			}catch(Exception e) {
			return new ResponseEntity<>("BUS DETAILS NOT FOUND",HttpStatus.NOT_FOUND);
			}
			}
		
		//SEARCH BUSES BETWEEN TWO CITIES
		@GetMapping("/findBus")
		public ResponseEntity<?> findBus(@RequestBody SearchCriteria search){
				try{
			List<BusDetails> findBus = busDetailsService.findBus(search);
			if(findBus.isEmpty()) {
				return new ResponseEntity<>("NO BUS FOUND",HttpStatus.NOT_FOUND);
			}else
			return new ResponseEntity<List<BusDetails>>(findBus,HttpStatus.OK);
				}catch(Exception e) {
					return new ResponseEntity<>("NO BUS FOUND",HttpStatus.NOT_FOUND);
				}
		}
		
		//GET PASSENGERS LIST USING BUS NUMBER
		@GetMapping("/passengers/{busNumber}")
		public ResponseEntity<?>getAllPassengers(@PathVariable("busNumber")String busNumber){
			List<Passenger> passengers = busDetailsService.getAllPassengers(busNumber);
			return new ResponseEntity<List<Passenger>>(passengers,HttpStatus.OK);
		}
			
			
}
