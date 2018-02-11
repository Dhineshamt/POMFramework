package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Create Lead Page", "FAIL");
		}
	}
	
	
	public CreateLeadPage enterCompanyName(String companyName) {
		enterById("createLeadForm_companyName", companyName);		
		return this;		
	}
	
	public CreateLeadPage enterFirstName(String firstName) {
		enterByXpath("//*[@id='createLeadForm_firstName'][1]", firstName);		
		return this;		
	}
	
	public CreateLeadPage enterLastName(String lastName) {
		enterByXpath("//*[@id='createLeadForm_lastName'][1]", lastName);		
		return this;		
	}
	
	public ViewLeadPage clickCreateLeadButton() {
		clickByClassName("smallSubmit");
		return new ViewLeadPage(driver,test);		
	}
	
	
	

}














