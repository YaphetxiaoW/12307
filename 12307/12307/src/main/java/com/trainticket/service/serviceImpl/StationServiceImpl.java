package com.trainticket.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trainticket.dao.StationDao;
import com.trainticket.service.StationService;



@Service("stationService")
public class StationServiceImpl implements StationService {

	@Autowired
	@Qualifier("stationDao")
	private StationDao stationDao;
	 
	@Override
	public List<String> getStation(String station) {
		return stationDao.getStation(station);
	}

}
