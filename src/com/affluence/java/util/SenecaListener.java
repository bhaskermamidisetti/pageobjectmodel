package com.affluence.java.util;


import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import com.affluence.java.util.reports.GenerateHTMLReport;
import com.affluence.java.util.reports.GenerateReport;

public class SenecaListener extends RunListener
{
	
	 TestDataBean testDataBean=null;
		boolean flag=true;
		boolean flag2=true;
		boolean testResult=false;
	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		System.out.println("Number of testcases to execute : " + description.testCount());
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		
		System.out.println("Number of testcases executed : " + result.getRunCount());
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		  Page.cretaeResultTestDataMap();
		  Page.getscreenShotPackageName(description.getClassName());
		  Page.cretaeScreebDetailsMap();
		  Page.setTestName(description.getMethodName());
		  Page.cretaeCurrentStepsMap();
		System.out.println("Starting execution of test case : "+ description.getMethodName());
	}

	/**
	 *  Called when an atomic test has finished, whether the test succeeds or fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception
	{
		 testDataBean =new TestDataBean();
		  testDataBean.setReqId(Page.getReqID());
		  testDataBean.setTesName(description.getMethodName());
		  testDataBean.setTestResultHtmlPath(Page.getTestResultHtmlPath());
		  if(testResult){
			  testDataBean.setTestResult("failed");
		  }else{
			  testDataBean.setTestResult("passed");
		  }
		  @SuppressWarnings("rawtypes")
		  Map currentSteps=Page.getCurrentStepsMap();
		  testDataBean.setStepDetails(currentSteps);
		  GenerateReport.generatePdfReport(description.getMethodName());
		  GenerateHTMLReport.generateHtmlReport(description.getMethodName());
	      Page.addToresulTestData(testDataBean);
	      
		System.out.println("Finished execution of test case : "+ description.getMethodName());
	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		testResult=true;
		System.out.println("Execution of test case failed : "+ failure.getMessage());
	}

	/**
	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception
	{
		System.out.println("Execution of test case ignored : "+ description.getMethodName());
	}
}