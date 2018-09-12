package com.affluence.java.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class MessagePage extends Page {
	
	@FindBy(css="html body div.container-fluid div.row-fluid div.span9 div.start_new h1")
	public  WebElement messageDiv;
	/**
	 * @param driver
	 */
	public MessagePage()
	{   
		System.out.println(MessagePage.class.getSimpleName()+" created");	
		
	}
	
	/**
	 * @param testName
	 * @param userName
	 */
	public void verifyMessagePage(){
		
		PageActions.doAction(messageDiv, PageActions.VERIFYTEXTINELEMET,"Messages","verify Message Page");
 		
	}
	
}
