package it.blog.springbatch.flightradar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProcessFlight {

	public static void main(String[] args) {

		ProcessFlight obj = new ProcessFlight();
		obj.run();

	}

	private void run() {

		String[] springConfig = {"config/database.xml" , "config/context.xml", "config/component.xml", "job/job.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		
//		RunScheduler runner = context.getBean("runScheduler", RunScheduler.class);
		
//		runner.run();
		

	}
}
