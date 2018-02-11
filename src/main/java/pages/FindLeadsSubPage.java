package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadsSubPage extends LeafTapsWrappers {

	public FindLeadsSubPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Find Leads")){
			reportStep("This is not Find Leads Sub Window", "FAIL");
		}		
	
	}
	
	public String getLeadIDInSubWindow () {
		String leadID = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[4]/a");
		return leadID;
	}
	
	public FindLeadsSubPage clickFindLeadsButtonInSubWindow() {
		clickByXpath("//button[contains(text(),'Find Leads')]");
		return this;
	}
	
	public MergeLeadPage clickFromLeadID() {
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[4]/a");
		switchToParentWindow();
		sleep(4000);
		return new MergeLeadPage(driver, test);
	}
	
	public MergeLeadPage clickToLeadID() {
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[5]/a");
		switchToParentWindow();
		sleep(4000);
		return new MergeLeadPage(driver, test);
	} 
	
	public MergeLeadPage switchToMergeLeadPage () {
		switchToParentWindow();
		return new MergeLeadPage(driver,test);
	}
	
}
