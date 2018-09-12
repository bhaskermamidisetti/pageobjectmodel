package com.affluence.java.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class PhotoStreamPage extends Page {
	
	@FindBy(css="html body div.container-fluid div.row-fluid div.span9 div.row-fluid div h1")
	public  WebElement invitesDiv;
	/**
	 * @param driver
	 */
	public PhotoStreamPage()
	{   
		System.out.println(PhotoStreamPage.class.getSimpleName()+" created");	
		
	}
	
	/**
	 * @param testName
	 * 
	 */
	public void verifyPhotoStreamPage(){
		
		PageActions.doAction(invitesDiv, PageActions.VERIFYTEXTINELEMET,"Photo Stream","verify photo stream page");
 		
	}
	
}
