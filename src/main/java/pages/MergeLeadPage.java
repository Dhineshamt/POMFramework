package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeLeadPage extends LeafTapsWrappers{

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Merge Lead Page", "FAIL");
		}		
	}
		
	public FindLeadsSubPage clickFromlookUpLead() {
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		return new FindLeadsSubPage(driver, test);
	}
	
	public FindLeadsSubPage clickTolookUpLead() {
		clickByXpath("(//img[@alt='Lookup'])[2]");
	    switchToLastWindow();
		return new FindLeadsSubPage(driver, test);
	}	
	
	public FindLeadsSubPage switchToFindLeadsSubPage () {
		
		return new FindLeadsSubPage(driver, test);
		
	}
	
	public ViewLeadPage clickMergeButton() {
		clickByLinkNoSnap("Merge");
		acceptAlert();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ViewLeadPage(driver, test);
	}
}
