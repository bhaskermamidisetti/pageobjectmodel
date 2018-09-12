package com.affluence.java.util;

import java.util.Map;

public class TestDataBean {
	
	private  String tesName;
	private  String testResult;
	private  String reqId;
	private  String testType;
	
	private  String testResultHtmlPath;
	
	public String getTestResultHtmlPath() {
		return testResultHtmlPath;
	}
	public void setTestResultHtmlPath(String testResultHtmlPath) {
		this.testResultHtmlPath = testResultHtmlPath;
	}
	
	public void setTestType(String testType) {
		this.testType = testType;
	}
	@SuppressWarnings("rawtypes")
	private  Map stepDetails;
	
	@SuppressWarnings("rawtypes")
	public Map getStepDetails() {
		return stepDetails;
	}
	@SuppressWarnings("rawtypes")
	public void setStepDetails(Map stepDetails) {
		this.stepDetails = stepDetails;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public  String getTestResult() {
		return testResult;
	}
	public  void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public  String getTesName() {
		return tesName;
	}
	public  void setTesName(String tesName) {
		this.tesName = tesName;
	}
	

}
