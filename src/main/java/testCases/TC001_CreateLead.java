package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC001_CreateLead extends LeafTapsWrappers {

	
	@BeforeClass
	public void setData(){
		browserName = "chrome";
		testCaseName = "Create Lead";
		testDescription = "Create a New Lead";
		category = "smoke";
		authors = "Dhinesh";
		dataSheetName = "TC001";
		
	}

	
	@Test(dataProvider = "fetchData", groups = "smoke")
	public void createLead(String uName, String pwd, String companyName, String firstName, String lastName){
		
		System.out.println("Testcase started Execution....");
		new LoginPage(driver, test)
		.enterUsername(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickCreateLeadButton()
		.verifyCompanyName(companyName);
	}

}












