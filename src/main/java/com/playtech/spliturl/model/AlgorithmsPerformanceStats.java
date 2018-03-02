package com.playtech.spliturl.model;

public class AlgorithmsPerformanceStats {
	
	private long timeTakenByRegExp;
	private long timeTakenByStateMachine;
	
	private URLModel urlModel;
	
	public AlgorithmsPerformanceStats(long timeTakenByRegExp, long timeTakenByStateMachine, URLModel urlModel) {
		super();
		this.timeTakenByRegExp = timeTakenByRegExp;
		this.timeTakenByStateMachine = timeTakenByStateMachine;
		this.urlModel = urlModel;
	}

	public long getTimeTakenByRegExp() {
		return timeTakenByRegExp;
	}

	public long getTimeTakenByStateMachine() {
		return timeTakenByStateMachine;
	}

	public URLModel getUrlModel() {
		return urlModel;
	}

}
