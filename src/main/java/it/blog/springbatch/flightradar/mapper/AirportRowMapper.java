package it.blog.springbatch.flightradar.mapper;

import it.blog.springbatch.flightradar.bean.Airport;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AirportRowMapper implements RowMapper<Airport>{

	@Override
	public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Airport airport = new Airport();

		/*
		 * Column names
		 */
		ResultSetMetaData rsmd = rs.getMetaData();
		String name = rsmd.getColumnLabel(1);
		 
		if (name.equals("from"))
			airport.setFrom(rs.getString("from"));
		else
			airport.setTo(rs.getString("to"));
		
		airport.setCount(rs.getInt("counter"));

		return airport;
	}
}
