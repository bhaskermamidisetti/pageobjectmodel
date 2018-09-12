package com.affluence.java.util;

/**
 * @author satheesh.guduru
 *
 */
public class ImageDetailsBean {
	
	private String purpose;
	private String imagePath;
	private String enteredDetails;
	private String fromTest;
	private String fromPage;
	private String stepDescription;
	private String stepExecutionTime;
	
	
	
	public String getStepExecutionTime() {
		return stepExecutionTime;
	}
	public void setStepExecutionTime(String stepExecutionTime) {
		this.stepExecutionTime = stepExecutionTime;
	}
	/**
	 * @return
	 */
	public String getStepDescription() {
		return stepDescription;
	}
	/**
	 * @param fromMethod
	 */
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}
	/**
	 * @return
	 */
	public String getFromPage() {
		return fromPage;
	}
	/**
	 * @param fromPage
	 */
	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}
	/**
	 * @return
	 */
	public String getFromTest() {
		return fromTest;
	}
	/**
	 * @param fromTest
	 */
	public void setFromTest(String fromTest) {
		this.fromTest = fromTest;
	}
	/**
	 * @return
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * @param imageDeatils
	 */
	public void setPurpose(String imageDeatils) {
		this.purpose = imageDeatils;
	}
	/**
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return
	 */
	public String getEnteredDetails() {
		return enteredDetails;
	}
	/**
	 * @param enteredDetails
	 */
	public void setEnteredDetails(String enteredDetails) {
		this.enteredDetails = enteredDetails;
	}
	

}
