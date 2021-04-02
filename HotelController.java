package com.cg.hbm.controller;
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

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.service.IHotelService;

/*package com.cg.hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.Hotel;

import com.cg.hbm.exceptions.HotelNotFoundException;

import com.cg.hbm.service.IHotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	IHotelService hSer;
	
	/**
	 * 
	 * @param hotel
	 * @return Hotel
	 */
	
	/*@PostMapping("/add")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hSer.addHotel(hotel);
	}
	/**
	 * 
	 * @param hotel
	 * @return Hotel
	 */
	
	
	/*@PutMapping("/update")
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		return hSer.updateHotel(hotel);
	}
	/**
	 * 
	 * @param hotel
	 * @return Hotel
	 * @throws HotelNotFoundException
	 */
	
	
	/*@DeleteMapping("/remove")
	public Hotel removeHotel(@RequestBody Hotel hotel)throws HotelNotFoundException {
	
		try {
		return hSer.removeHotel(hotel);
		}catch(Exception e)
     	{
		throw new HotelNotFoundException("hotel_id not available please enter a valid number");
	    }
	}
	/**
	 * 
	 * @return List<Hotel>
	 */
	
	

	/*@GetMapping("/all")
	public List<Hotel> showAllHotels(){
		return hSer.showAllHotels();
	}
	
	/**
	 * 
	 * @param hotel_id
	 * @return Hotel
	 * @throws HotelNotFoundException
	 */
	
	/*@GetMapping("/{hotel_id}")
	public Hotel showHotel(@PathVariable int hotel_id)throws HotelNotFoundException {
		
		try {
		return hSer.showHotel(hotel_id);
		}catch(Exception e){
			throw new HotelNotFoundException("hotelid not available.....give valid number");
		}
	}
	
}*/
@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	IHotelService hService;
	/**
	 * 
	 * @param hotel
	 * @return 
	 * @throws HotelNotFoundException
	 */
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) throws HotelNotFoundException  {
		Hotel resulthotel=hService.addHotel(hotel);
		return new ResponseEntity<Hotel>(resulthotel,HttpStatus.OK) ;
	}
	@DeleteMapping("/{hotel_id}")
	public Hotel removeHotel(@PathVariable int hotel_id) throws HotelNotFoundException {
		return hService.removeHotel(hotel_id);
	}
	@PutMapping("/hotel")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) throws HotelNotFoundException {
		Hotel resultHotel = hService.updateHotel(hotel.getHotel_id(),hotel);
		return new ResponseEntity<Hotel>(resultHotel, HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> showAllHotels() throws HotelNotFoundException{
		List<Hotel> resultHotel=hService.showAllHotels();
		return new ResponseEntity<List<Hotel>>(resultHotel, HttpStatus.OK);
	}
	@GetMapping("/{hotel_id}")
	public ResponseEntity<Hotel>showHotel(@PathVariable int hotel_id) throws HotelNotFoundException {
		Hotel h=hService.showHotel(hotel_id);
		if(h!=null) {
			return new ResponseEntity<Hotel>(h,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
		}
		
	}

}
	

