package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsSubPage;
import pages.LoginPage;
import pages.MergeLeadPage;
import wrappers.LeafTapsWrappers;

public class TC004_MergeLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData(){
		browserName = "chrome";
		testCaseName = "Merge Lead";
		testDescription = "Merge Lead";
		category = "sanity";
		authors = "Dhinesh";
		dataSheetName = "TC004";
		
	}
	
	
	@Test(dataProvider = "fetchData", groups = "regression"/*, dependsOnGroups = "sanity"*/)
	public void createLead(String uName, String pwd){		
		String leadID = new LoginPage(driver, test)
		.enterUsername(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickMergeLead()
		.clickFromlookUpLead()
		.clickFindLeadsButtonInSubWindow()
		.getLeadIDInSubWindow();
		
		new FindLeadsSubPage(driver, test)
		.clickFromLeadID();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MergeLeadPage(driver, test)
		.clickTolookUpLead()
		.clickFindLeadsButtonInSubWindow()
		.clickToLeadID()
		.clickMergeButton()
		.clickFindLeads()
		.enterLeadID(leadID)
		.clickFindLeadButton()
		.verifyNoRecordMessage();
		
	}

}
