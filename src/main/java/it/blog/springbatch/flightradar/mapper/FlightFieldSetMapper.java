package it.blog.springbatch.flightradar.mapper;

import it.blog.springbatch.flightradar.bean.Flight;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class FlightFieldSetMapper implements FieldSetMapper<Flight>{

	@Override
	public Flight mapFieldSet(FieldSet fieldSet) throws BindException {
		Flight flight = new Flight();
		flight.setFlightNumber(fieldSet.readString("field17"));
		flight.setTo(fieldSet.readString("field12"));
		flight.setFrom(fieldSet.readString("field13"));
		return flight;
	}
}
