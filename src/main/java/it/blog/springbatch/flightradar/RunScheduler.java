package it.blog.springbatch.flightradar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	private static final Log logger = LogFactory.getLog(RunScheduler.class);

	public void run() {

		try {
			
			Map<String, JobParameter> parameters = 
                    new HashMap<String, JobParameter>();
 
			File folder = new File("C:/progetti/Blog/SpringBatchFlightRadar/input/");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
			    if (file.isFile()) {
			    	parameters.put("filename", new JobParameter(file.getName()));
			    }
			}

			/* In order to avoid duplicate job instance already exists */
			parameters.put("executionTime", new JobParameter(System.currentTimeMillis()));
			
			JobExecution execution = jobLauncher.run(job, 
                    new JobParameters(parameters));

            logger.info("Exit Status : " + execution.getStatus());
            logger.info("Exit Status : " + execution.getAllFailureExceptions());
            System.out.println(execution.getAllFailureExceptions());

		} catch (Exception e) {
			logger.error(e);

		}

	}
}
