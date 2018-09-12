package com.affluence.java.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.affluence.java.util.Page;
import com.affluence.java.util.PageActions;

/**
 * @author satheesh.guduru
 *
 */
public class HomePage extends Page {
	
	
	public HomePage()
	{   
		System.out.println(HomePage.class.getSimpleName()+" created");		
		
	}
	
	
	@FindBy(css="img[alt='Logout']")
	public  WebElement logOutButton;
	
	@FindBy(id="homeTabs")
	public  WebElement ulElement;
	
	@FindBy(css="img[alt='Nav02-profile']")
    public WebElement profileIcon;
	
	@FindBy(css="img[alt='Nav01-home']")
    public WebElement homeIcon;
	
	@FindBy(css="img[alt='Nav03-messages']")
    public WebElement messageIcon;
	
	@FindBy(css="img[alt='Nav04-discussion']")
    public WebElement discussionIcon;
	
	@FindBy(css="img[alt='Nav06-members']")
    public WebElement membersIcon;
	
	@FindBy(css="img[alt='Nav07-invites']")
    public WebElement invitesIcon;
	
	@FindBy(css="img[alt='Nav05-photos']")
    public WebElement photoStreamIcon;
	
	

	
	/**
	 * @param testName
	 */
	public void VerifyHomePage(){
		PageActions.doAction(ulElement, PageActions.PRESENT,PageActions.PARAMETERNOTREQUIRED,"Verify home page");
	}
		
	/**
	 * @return
	 */
	public void gotoMessagePage()
	{   
		
        PageActions.doAction(messageIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on message icon");
		
				
	}
	
	/**
	 * @return
	 */
	public void gotoHomePage()
	{   
				
               PageActions.doAction(homeIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on home icon");
		       
	}
	/**
	 * @param testName
	 */
	public void gotoProfilePage()
	{   
		
			PageActions.doAction(profileIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on profile icon");
		
		}
	/**
	 * @param testName
	 */
	public void gotoDiscussiongePage()
	{   
		
			PageActions.doAction(discussionIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on discussion icon");
		}	
	
	/**
	 * @param testName
	 */
	public void gotoMembersPage()
	{   
		
			PageActions.doAction(membersIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on members icon");
			
		
		}	
	/**
	 * @param testName
	 */
	public void gotoInvitesPage(String testName)
	{   
		
			PageActions.doAction(invitesIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on invites icon");
	}	
	/**
	 * @param testName
	 */
	public void gotoPhotoStreamPage()
	{   
		
		PageActions.doAction(photoStreamIcon, PageActions.CLICK,PageActions.PARAMETERNOTREQUIRED,"Click on photo stream icon");
		
	}	
	
	
	/*
	
	public EventsPage gotoEventsPage()
	{   
		rep.Reporting();
		topmenu.eventsLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isEventsPage()){rep.message("Click on Events link, Events page loaded successfully"); return new EventsPage(driver);}
		else{rep.errorMessage("Click on Events link, Problem in Loading Events Page");return null;}
		
	}
	
	public OffersPage gotoOffersPage()
	{   
		rep.Reporting();
		topmenu.offersLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isOffersPage()){rep.message("Click on Offers link, Offers page loaded successfully"); return new OffersPage(driver);}
		else{rep.errorMessage("Click on Offers link, Problem in Loading Offers Page");return null;}
		
	}
	
	public SettingsPage gotoSettingsPage()
	{   
		rep.Reporting();
		topmenu.accountLink.click();
		topmenu.settingsLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isSettingsPage()){rep.message("Click on Settings link, Settings page loaded successfully"); return new SettingsPage(driver);}
		else{rep.errorMessage("Click on Settingse link, Problem in Loading Settings Page"); return null;}
		
	
	}
	
	public PrivacyPage gotoPrivacyPage()
	{   
		rep.Reporting();
		topmenu.accountLink.click();
		topmenu.privacyLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isSettingsPage()){rep.message("Click on Privacy link, Privacy page loaded successfully"); return new PrivacyPage(driver);}
		else{rep.errorMessage("Click on Privacy link, Problem in Loading Privacy Page");return null;}
		
	
	}
	
		
	public  LandingPage clickSignOut()
	{   
		rep.Reporting();
		topmenu.accountLink.click();
		topmenu.signoutLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isLandingPage()){rep.message("Click on SignOut link, Signed Out successfully"); isLoggedin=false; return new LandingPage(driver);  }
		else{rep.errorMessage("Click on SignOut link, Problem in Signing out");driver.get("http://affluence2-staging.herokuapp.com/"); return null;}
		
	}
	
	public HomePage gotoWhatsnewPage()
	{   
		rep.Reporting();
		leftmenu.whatsnewLink.click();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		if(webpage.isHomePage()){rep.message("Click on Whats New link, Home page loaded successfully"); return new HomePage(driver);}
		else{rep.errorMessage("Click on Home link, Problem in Loading Home Page");return null;}
		
	}
	
*/
}
