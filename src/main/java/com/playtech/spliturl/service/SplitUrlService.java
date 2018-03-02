package com.playtech.spliturl.service;

import com.playtech.spliturl.model.AlgorithmsPerformanceStats;
import com.playtech.spliturl.model.URLModel;

/**
 * The interface declares method for finding out url details.
 * 
 * @author Saurabh Singh
 * @version 1.0
 */
public interface SplitUrlService {

	/**
	 * The method split the url using regular expression.
	 * 
	 * @param urlString
	 * @return URLModel
	 */
	URLModel splitUrlByRegex(String urlString);

	/**
	 * The method split the url using state machine.
	 * 
	 * @param urlString
	 * @return URLModel
	 */
	URLModel splitUrlByStateMachine(String urlString);
	
	/**
	 * The method check the performance of the algorithm for specified iterations and return the stats.
	 * 
	 * @param urlString
	 * @param iteration
	 * @return URLModel
	 */
	AlgorithmsPerformanceStats getAlgorithmsPerformanceStats(String urlString, int iteration);

}
