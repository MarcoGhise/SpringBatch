package it.blog.springbatch.flightradar;

import it.blog.springbatch.flightradar.bean.Company;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;

public class FlightWriter extends FlatFileItemWriter<Company> implements FlatFileFooterCallback
{

	private static Map<String, Company> company = new HashMap<String, Company>();
	    
	@Override
	public void write(List<? extends Company> items) throws Exception {
		
        for (Company item : items) {
        	
            // Check the key
            if (company.containsKey(item.getName()))
            {
            	Company temp = company.get(item.getName());
            	temp.setCounter(temp.getCounter() + item.getCounter());
            }
            else
            {
            	company.put(item.getName(), item);
            }
        }
	}
	
	@Override
	public void writeFooter(Writer writer) throws IOException {
		
		List<Company> companies = new ArrayList<Company>(company.values());
		
		for (Company item : companies)
			writer.write(item.getName() + " - " + item.getCounter() + "\r\n");
	}
}
