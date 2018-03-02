package com.playtech.spliturl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.playtech.spliturl.config.AppConfig;
import com.playtech.spliturl.model.AlgorithmsPerformanceStats;
import com.playtech.spliturl.service.SplitUrlService;

/**
 * This is the main class to run the application.
 * 
 * @author Saurabh Singh
 * @version 1.0
 */
public class Application {

	public static void main(String[] args) throws Exception {
		
		try {
		
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			SplitUrlService splitUrlService = (SplitUrlService) context.getBean(SplitUrlService.class);
			
			if (args.length != 1) {
				
				throw new RuntimeException("Invalid program argument");
			}
			
			String urlString = args[0];
			
			AlgorithmsPerformanceStats algorithmsPerformanceStats = splitUrlService.getAlgorithmsPerformanceStats(urlString, 10000);
			
			System.out.println(algorithmsPerformanceStats.getUrlModel());
			System.out.println("Regex: " + algorithmsPerformanceStats.getTimeTakenByRegExp() + "msec");
			System.out.println("State: " + algorithmsPerformanceStats.getTimeTakenByStateMachine() + "msec");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
