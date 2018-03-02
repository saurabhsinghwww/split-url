package com.playtech.spliturl.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.playtech.spliturl.model.AlgorithmsPerformanceStats;
import com.playtech.spliturl.model.URLModel;
import com.playtech.spliturl.statemachine.URLState;

/**
 * The class implements the method for finding out url details.
 * 
 * @author Saurabh Singh
 * @version 1.0
 */
@Service("splitUrlService")
public class SplitUrlServiceImpl implements SplitUrlService {

	private static final Pattern URL_SPLIT_PATTERN = Pattern
			.compile("^(([^:/?#]+):)?(//([^/?#]*)/?)?([^?#]*)(\\?([^#]*)?)?");
	private static final String COLON = ":";

	/**
	 * The method split the url using regular expression.
	 * 
	 * @param urlString
	 * @return URLModel
	 */
	public URLModel splitUrlByRegex(String urlString) {

		Matcher matcher = URL_SPLIT_PATTERN.matcher(urlString);
		matcher.find();

		String socketAddress = matcher.group(4);
		String host = "";
		Integer port = null;

		if (socketAddress.contains(COLON)) {
			host = socketAddress.split(COLON)[0];
			port = Integer.valueOf(socketAddress.split(COLON)[1]);
		} else {
			host = socketAddress;
		}

		return URLModel.builder().setScheme(matcher.group(2)).setHost(host).setPort(port).setPath(matcher.group(5))
				.setParameters(matcher.group(7)).build();

	}

	/**
	 * The method split the url using state machine.
	 * 
	 * @param urlString
	 * @return URLModel
	 */
	public URLModel splitUrlByStateMachine(String urlString) {

		URLModel.URLModelBuilder urlModelBuilder = URLModel.builder();

		URLState state = URLState.START;

		try {

			URL url = new URL(urlString);

			while (!state.equals(URLState.END)) {
				state = state.next(url, urlModelBuilder);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		return urlModelBuilder.build();

	}

	/**
	 * The method check the performance of the algorithm for specified iterations.
	 * 
	 * @param urlString
	 * @param iteration
	 * @return URLModel
	 */
	public AlgorithmsPerformanceStats getAlgorithmsPerformanceStats(String urlString, int iteration) {

		Instant before = Instant.now();
		URLModel regexUrlModel = IntStream.range(0, iteration).mapToObj($ -> splitUrlByRegex(urlString))
				.findFirst().get();
		long regexElapsedTime = Duration.between(before, Instant.now()).toMillis();

		before = Instant.now();
		URLModel stateMachineURLResult = IntStream.range(0, iteration)
				.mapToObj($ -> splitUrlByStateMachine(urlString)).findFirst().get();
		long stateMachineElapsedTime = Duration.between(before, Instant.now()).toMillis();

		if (!regexUrlModel.equals(stateMachineURLResult)) {

			throw new RuntimeException("Algorithms returning different results.");
		}

		return new AlgorithmsPerformanceStats(regexElapsedTime, stateMachineElapsedTime, stateMachineURLResult);

	}

}
