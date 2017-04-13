package com.trainticket.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trainticket.dao.StationDao;

@Repository("stationDao")
public class StationDaoImpl implements StationDao {
	
	@Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate template;

	@Override
	public List<String> getStation(String station) {
		 return (List<String>) template.queryForList("select Sname from tx_train_station where Sname like ?",   
		 new Object[]{station+"%"}, String.class);

	}

}
