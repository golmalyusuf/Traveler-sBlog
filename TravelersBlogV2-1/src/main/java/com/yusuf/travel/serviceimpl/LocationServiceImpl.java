package com.yusuf.travel.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yusuf.travel.model.Locations;
import com.yusuf.travel.repository.LocationsRepository;
import com.yusuf.travel.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationsRepository locationsRepository;
	
	@Override
	public List<String> getAllLocations() {
		return locationsRepository.findAllLocationNames();
	}

}
