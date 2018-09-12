package com.affluence.java.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class ProfilePage extends Page {
	
	@FindBy(className="profileName")
	public  WebElement profileName;
	
	
	public ProfilePage()
	{   
		System.out.println(ProfilePage.class.getSimpleName()+" created");
		
	}
	
	/**
	 * @param testName
	 * @param userName
	 */
	public void verifyProfileName(String userName){
		
		PageActions.doAction(profileName, PageActions.VERIFYTEXTINELEMET,userName.split("@")[0],"Verify profile name"); 
				
	}
	
}
