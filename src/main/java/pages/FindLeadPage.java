package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadPage extends LeafTapsWrappers {
	
	private FindLeadPage text;

	public FindLeadPage(RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is not Find Leads Page", "FAIL");
		}
	}
	
	public FindLeadPage enterLeadID(String leadID) {
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input[1]",leadID);
		return this;
	}
	
	public FindLeadPage enterfirstName (String firstName) {
		enterByXpath("(//input[@name='firstName'])[3]",firstName);
		return this;
	}
	
	public FindLeadPage clickFindLeadButton () {
		clickByXpath("//button[contains(text(),'Find Leads')]");
		sleep(2000);
		return this;
		
	}
	
	
	public FindLeadPage clickEmailTab () {
		clickByXpath("//span[contains(text(),'Email')]");
		return this;
		
	}
	
	public FindLeadPage enterEmailID (String email) {
		enterByName("emailAddress",email);
		return this;
	}
	
	public FindLeadPage clickPhoneTab () {
		clickByXpath("//span[text()='Phone']");
		return this;
	}
	
	public FindLeadPage enterPhoneNumber (String phoneNumber) {
		enterByXpath("//input[@name='phoneNumber']", phoneNumber);
		return this;
	}
	
	public String getLeadID() {
		String leadID = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		return  leadID;	
	}
	
	public String getLeadIDForDeletion () {
		String  leadIdForDeletion = getTextByXpath("(//a[@class='linktext'])[4]");
		return  leadIdForDeletion;
		
	}
	
	public String getFirstName() {
		String companyName = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		return companyName;	
	}
	
	public FindLeadPage verifyNoRecordMessage () {
		verifyTextByXpath("//div[contains(text(),'No records to display')]","No records to display");
		return this;
	}
	
	
	public ViewLeadPage clickLeadID () {		
		clickByXpath("(//a[@class='linktext'])[4]");
		return new ViewLeadPage(driver,test);
	}
	
	
}
