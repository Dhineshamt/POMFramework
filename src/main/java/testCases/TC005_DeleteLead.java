package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC005_DeleteLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData(){
		browserName = "chrome";
		testCaseName = "Delete Lead";
		testDescription = "Delete Lead";
		category = "Regression";
		authors = "Dhinesh";
		dataSheetName = "TC005";
		
	}
	
	@Test(dataProvider = "fetchData", groups = "regression"/*, dependsOnGroups = "sanity"*/)
	public void deleteLead(String uName, String pwd, String phoneNo) {
		
		String leadIdForDeletion = new LoginPage(driver, test)
		.enterUsername(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLead()
		.clickPhoneTab()
		.enterPhoneNumber(phoneNo)
		.clickFindLeadButton()
		.getLeadIDForDeletion();
		
		new FindLeadPage(driver, test)
		.clickLeadID()
		.clickDeleteButton()
		.clickFindLead()
		.enterLeadID(leadIdForDeletion)
		.clickFindLeadButton()
		.verifyNoRecordMessage();
	}

}
