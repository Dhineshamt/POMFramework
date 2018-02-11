package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC003_DuplicateLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		browserName = "chrome";
		testCaseName = "Duplicate Lead";
		testDescription = "Duplicate Lead";
		category = "sanity";
		authors = "Dhinesh";
		dataSheetName = "TC003";
	}
	
	
	@Test(dataProvider = "fetchData", groups = "sanity"/*, dependsOnGroups = "smoke"*/)
	public void duplicateLead(String uName, String pwd, String email) {
		
		new LoginPage(driver, test)
		.enterUsername(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLead()
		.clickEmailTab()
		.enterEmailID(email)
		.clickFindLeadButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String firstName = new FindLeadPage(driver, test)
		.getFirstName();
		
		new FindLeadPage(driver, test)
		.clickLeadID()
		.clickDuplicateButton()
		.clickCreateLead()
		.verifyFirstName(firstName);
	}
	
	
}
