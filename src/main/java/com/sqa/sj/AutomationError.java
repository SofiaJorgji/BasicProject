package com.sqa.sj;

import org.openqa.selenium.*;

public class AutomationError extends AbstractTestOperation implements IAutomationError {

	private int errorId;

	private String timeStamp;

	private int numOfOccurrences;

	@Override
	public void createErrorReport() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see com.sqa.jf.AbstractTestOperation#debugTest()
	 */
	@Override
	public void debugTest() {
		// TODO Auto-generated method stub
	}

	@Override
	public WebDriver evalUsedDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the errorId
	 */
	@Override
	public int getErrorId() {
		return this.errorId;
	}

	/**
	 * @return the numOfOccurrences
	 */
	@Override
	public int getNumOfOccurrences() {
		return this.numOfOccurrences;
	}

	/**
	 * @return the timeStamp
	 */
	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}

	@Override
	public void recreateError() {
		// TODO Auto-generated method stub
	}

	/**
	 * @param errorId
	 *            the errorId to set
	 */
	@Override
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	/**
	 * @param numOfOccurrences
	 *            the numOfOccurrences to set
	 */
	@Override
	public void setNumOfOccurrences(int numOfOccurrences) {
		this.numOfOccurrences = numOfOccurrences;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	@Override
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}