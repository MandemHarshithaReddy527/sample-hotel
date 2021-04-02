package com.cg.hbm.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IHotelRepository;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelNotFoundException;

/*package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.dao.IHotelRepository;

@Service
public class IHotelServiceImpl implements IHotelService{
	@Autowired
	IHotelRepository iDao;
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */
	/*@Override
	public Hotel addHotel(Hotel hotel) {
		return iDao.save(hotel);
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */
	

	/*@Override
	public Hotel updateHotel(Hotel hotel) {
		return iDao.saveAndFlush(hotel);
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */

	/*@Override
	public Hotel removeHotel(Hotel hotel) {
		iDao.deleteById(hotel.getHotel_id());
		return hotel;
	}
	/**
	 * @author Harshitha
	 * @return List<Hotel>
	 * 
	 */
	

	/*@Override
	public List<Hotel> showAllHotels() {
		return iDao.findAll();
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel_id
	 */

	/*@Override
	public Hotel showHotel(int hotel_id) {
		return iDao.findById(hotel_id).get();
	}

}*/
@Service
@Transactional
public class IHotelServiceImpl implements IHotelService {
	@Autowired
	IHotelRepository hDao;
	@Override
	public Hotel addHotel(Hotel hotel) throws HotelNotFoundException{
		Optional<Hotel> h = hDao.findById(hotel.getHotel_id());
		if (h.isEmpty()) {
			return hDao.saveAndFlush(hotel);
		} else {
			throw new HotelNotFoundException("Hotel already exists");
		}
	}
	

	@Override
	public Hotel updateHotel(int hotelId, Hotel hotel) throws HotelNotFoundException {
		// TODO Auto-generated method stub
		Optional<Hotel> h = hDao.findById(hotelId);
		if (h.isEmpty()) {
			throw new HotelNotFoundException("Hotel not found");
		}
		else
		hDao.save(hotel);
		return hotel;
		
	}
	
	


	@Override
	public Hotel removeHotel(int hotel_id) throws HotelNotFoundException{
			Optional<Hotel> op=hDao.findById(hotel_id);
			if(op.isPresent()) {
				hDao.deleteById(hotel_id);
				return op.get();
			}
			else throw new HotelNotFoundException("Hotel with given Id doesn't exist.");
			
	}
	
    @Override
	public List<Hotel> showAllHotels() throws HotelNotFoundException{
    	List<Hotel> h = hDao.findAll();
		if (h.isEmpty()) {
			throw new HotelNotFoundException("Hotel not found");
		}
		return h;
	}


	

	@Override
	public Hotel showHotel(int hotel_id) throws HotelNotFoundException{
		
		  /*if(hDao.findById(hotel_id).isPresent()) {
		  
		  return hDao.findById(hotel_id).get();
		  
		 } 
		  else 
			  return null;
			 // throw new HotelNotFoundException(" Hotel not found with such HotelID..!" );
		  }*/
		
		Optional<Hotel> h=hDao.findById(hotel_id);
		if(h.isEmpty()) {
			throw new HotelNotFoundException("Given HotelId does not exist");
		}
		return h.get();
			
		
		
		 
		}

		 
	
	}
	

