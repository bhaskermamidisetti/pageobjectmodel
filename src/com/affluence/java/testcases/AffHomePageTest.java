package com.affluence.java.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.affluence.java.pages.HomePage;
import com.affluence.java.pages.LoginPage;
import com.affluence.java.pages.DoLogOutPage;
import com.affluence.java.util.Page;
import com.affluence.java.util.SenecaParameterizedTestRunner;
import com.affluence.java.util.SpreadsheetData;
import com.affluence.java.util.SenecaParameterizedTestRunner.Parameters;


 

@RunWith(SenecaParameterizedTestRunner.class)
public class AffHomePageTest extends Page {
		
		private WebDriver driver;
	    private String User_Name;
	    private String User_Password;
	    private String req_Id;
	   
	    /**
	     * @return
	     * @throws IOException
	     */
	    @SuppressWarnings("rawtypes")
		@Parameters
	    public static Collection spreadsheetData() throws IOException {
	   
	        InputStream spreadsheet = new FileInputStream(dataPath);
	        return new SpreadsheetData(spreadsheet,AffHomePageTest.class.getSimpleName()).getData();
	    }
	   
	    /**
	     * @param a
	     * @param b
	     */
	    public AffHomePageTest(String a, String b,String c) {
	        super();
	        this.User_Name = a;
	        this.User_Password = b;
	        this.req_Id=c;
	        
	   }
	   
	  /**
	 * @throws Exception
	 */
	@Before
	  public void setUp() throws Exception {
		  driver=getDriver();
		  setReqID(req_Id);
	  }

	  /**
	 * @throws Exception
	 */
	@Test  
	  public void affHomePageTest() throws Exception {
		    driver.get(base_url);
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
			loginPage.verifyLoginPage();
			loginPage.enterLoginDetails(User_Name,User_Password);
            HomePage homePage=PageFactory.initElements(driver,HomePage.class);
            homePage.VerifyHomePage();
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

	                  