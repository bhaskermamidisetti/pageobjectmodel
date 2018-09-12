package com.affluence.java.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;


/**
 * @author satheesh.guduru
 *
 */
public class DoLogOutPage extends Page {

	@FindBy(css="img[alt='Logout']")
	public  WebElement logOutButton;

	
	//Selenium rcdriver=new WebDriverBackedSelenium(driver,driver.getCurrentUrl());

    /**
     * @param testName
     * @param fromPage
     * @throws InterruptedException
     */
    public void doSignOut() throws InterruptedException
    {   	
    	PageActions.doAction(logOutButton, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on log out button");
    	
  }

	}


