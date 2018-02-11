package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.EditLeadPage;
import pages.FindLeadPage;
import pages.LoginPage;
import pages.ViewLeadPage;
import wrappers.LeafTapsWrappers;

public class TC002_EditLead extends LeafTapsWrappers {
	
	@BeforeClass
	public void setData(){
		browserName = "chrome";
		testCaseName = "Edit Lead";
		testDescription = "Edit existing Lead";
		category = "sanity";
		authors = "Dhinesh";
		dataSheetName = "TC002";
		
	}
	
	
	@Test(dataProvider = "fetchData", groups = "sanity" /*, dependsOnGroups = "smoke"*/)
	public void editLead(String userName, String pwd, String firstName, String companyName) {
		
		new LoginPage(driver, test)
		.enterUsername(userName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLead();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new FindLeadPage(driver, test)
		.enterfirstName(firstName)
		.clickFindLeadButton();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new FindLeadPage(driver, test)
		.clickLeadID();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new ViewLeadPage(driver, test)
		.clickEditButton()
		.enterCompanyName(companyName)
		.clickUpdate()
		.verifyCompanyName(companyName);
		
	}

}
