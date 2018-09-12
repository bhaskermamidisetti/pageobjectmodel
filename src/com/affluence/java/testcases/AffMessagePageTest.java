package com.affluence.java.testcases;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.affluence.java.pages.HomePage;
import com.affluence.java.pages.LoginPage;
import com.affluence.java.pages.MessagePage;
import com.affluence.java.pages.DoLogOutPage;
import com.affluence.java.util.Page;
import com.affluence.java.util.SenecaTestRunner;
 



 

/**
 * @author satheesh.guduru
 *
 */
@RunWith(SenecaTestRunner.class)
public class AffMessagePageTest extends Page {
		
		private WebDriver driver;
		
	     
	  /**
	 * @throws Exception
	 */
	   @Before
	  public void setUp() throws Exception {
		  
		  driver=getDriver();
		
	  }

	  /**
	 * @throws Exception
	 */
	 @Test  
	  public void affMessagePageTest() throws Exception {
		  	
		  	
		    driver.get(base_url);
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
			loginPage.verifyLoginPage();
			loginPage.enterLoginDetails(basicuser,basicuserpwd);
            HomePage homePage=PageFactory.initElements(driver,HomePage.class);
            homePage.gotoMessagePage();
	  		MessagePage messagePage=PageFactory.initElements(driver,MessagePage.class);
	  		messagePage.verifyMessagePage();
	  		webpage=PageFactory.initElements(driver,DoLogOutPage.class);
	  		webpage.doSignOut();
	  }			

	  /**
	 * @throws Exception
	 */
	@After
	  public void tearDown() throws Exception {
		  driver.quit();
		  }
}

	                  