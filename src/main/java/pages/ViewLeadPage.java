package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers{

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not View Lead Page", "FAIL");
		}
	}

	
	public ViewLeadPage verifyCompanyName(String companyName) {
		verifyTextContainsById("viewLead_companyName_sp", companyName);		
		return this;
	}
	
	public ViewLeadPage verifyLeadID(String leadID) {
		verifyTextContainsById("viewLead_companyName_sp", leadID);
		
		return this;
	}
	
	public ViewLeadPage verifyFirstName (String firstName) {
		verifyTextContainsById("viewLead_firstName_sp",firstName);
		return this;
		
	}
	
	/**
	 * @author Dhinesh
	 * @param companyName
	 * @return 
	 */
	public EditLeadPage clickEditButton () {
		clickByXpath("//a[text()='Edit']");
		return new EditLeadPage(driver, test);
	}
	
	
	public DuplicateLeadPage clickDuplicateButton ()  {
		clickByLink("Duplicate Lead");
		return new DuplicateLeadPage(driver, test);		
	}
	
	public MyLeadsPage clickDeleteButton () {
		clickByClassName("subMenuButtonDangerous");
		return new MyLeadsPage(driver, test);
		
	}

	public FindLeadPage clickFindLeads() {
		clickByLink("Find Leads");
		return new FindLeadPage(driver, test);
	}
	
}