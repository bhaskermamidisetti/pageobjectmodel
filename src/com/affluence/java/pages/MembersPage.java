package com.affluence.java.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class MembersPage extends Page {
	
	@FindBy(css="html body div.container-fluid div.row-fluid div.span9 h1")
	public  WebElement membersDiv;
	
	/**
	 * @param driver
	 */
	public MembersPage()
	{   
		System.out.println(MembersPage.class.getSimpleName()+" created");	
		
	}
	
	/**
	 * @param testName
	 */
	public void verifyMembersPage(){
		PageActions.doAction(membersDiv, PageActions.VERIFYTEXTINELEMET,"Members","verify members Page");
 		
	}
	
}
