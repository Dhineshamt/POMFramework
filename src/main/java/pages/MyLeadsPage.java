package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyLeadsPage extends LeafTapsWrappers{

	public MyLeadsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not MyLeads Page", "FAIL");
		}
	}

	
	public CreateLeadPage clickCreateLead() {
		clickByLink("Create Lead");
		return new CreateLeadPage(driver,test);
	}
	
	
	public FindLeadPage clickFindLead() {
		clickByLink("Find Leads");	
		return new FindLeadPage(driver,test);		
	}
	
	public MergeLeadPage clickMergeLead() {
		clickByLink("Merge Leads");
		return new MergeLeadPage(driver, test);
		
	}
	

}














