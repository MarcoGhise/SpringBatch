package it.blog.springbatch.flightradar.process;

import it.blog.springbatch.flightradar.bean.Flight;

import org.springframework.batch.item.ItemProcessor;

public class FlightProcessor implements ItemProcessor<Flight, Flight>{

	private String fileImport;
	
	@Override
	public Flight process(Flight item) throws Exception {
		item.setFileImport(fileImport);
		return item;
	}

	public String getFileImport() {
		return fileImport;
	}

	public void setFileImport(String fileImport) {
		this.fileImport = fileImport;
	}
}
