package com.affluence.java.pages;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;



/**
 * @author satheesh.guduru
 *
 */
public class LoginPage extends Page {
	
	@FindBy(name="user[email]")
    public  WebElement userName;
	
	@FindBy(name="user[password]")
    public  WebElement password;
	
	@FindBy(css="button.btn")
	public  WebElement LoginButton;
	
	
	public LoginPage()
	{   
		System.out.println(LoginPage.class.getSimpleName()+" created");	
		
	}
	
	/**
	 * @param testName
	 */
	public  void verifyLoginPage(){
		
		PageActions.doAction(userName, PageActions.PRESENT,PageActions.PARAMETERNOTREQUIRED,"verify loginPage");
		
	}
		
	/**
	 * @param user_Name
	 * @param Password
	 * @param testName
	 */
	public  void enterLoginDetails(String user_Name,String Password){
		PageActions.doAction(userName, PageActions.TEXT,user_Name,"Entered user name");
	    PageActions.doAction(password, PageActions.TEXT,Password,"Entered password");
	    PageActions.doAction(LoginButton, PageActions.SUBMIT,PageActions.PARAMETERNOTREQUIRED,"Submit login page");
	}
	
	


}
