package com.affluence.java.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;


public class DiscussionPage extends Page {
	
	@FindBy(css="html body div.container-fluid div.row-fluid div.span9 h1")
	public  WebElement discussionDiv;
	
	
	
	
	public DiscussionPage()
	{   
		System.out.println(DiscussionPage.class.getSimpleName()+" created");		
		
	}
	
	/**
	 * @param testName
	 */
	public void verifyDiscussionPage(){
		
		PageActions.doAction(discussionDiv, PageActions.VERIFYTEXTINELEMET,"Discussions","verify discussion Page");
 		
	}
	
	
	
}
