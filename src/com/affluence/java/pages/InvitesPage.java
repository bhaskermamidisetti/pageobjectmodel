package com.affluence.java.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class InvitesPage extends Page {
	
	@FindBy(css="html body div.container-fluid div.row-fluid div.span9 div.row div.span9 h2.padding0")
	public  WebElement invitesDiv;
	/**
	 * @param driver
	 */
	public InvitesPage()
	{   
		System.out.println(InvitesPage.class.getSimpleName()+" created");
		
	}
	
	/**
	 * @param testName
	 * 
	 */
	public void verifyInvitesPage(){
		
		PageActions.doAction(invitesDiv, PageActions.VERIFYTEXTINELEMET,"Invite Friends","verify Invites Page");
 		
	}
	
}
