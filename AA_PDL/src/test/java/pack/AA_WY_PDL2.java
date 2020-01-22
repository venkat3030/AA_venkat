package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.*;

import bsh.*;
//import scala.collection.Iterator;
//import scala.collection.Set;

//import Pages.HomePage;
//import Pages.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileReader;

public class AA_WY_PDL2 extends AA_PDL{

	
//Anji Reddy scenarios
	//@Test (priority=3,groups = "venkat_wy_PDL1")

  	public void NewLoan_Monthly_Duedate() throws Exception
   {
		String FileName= "AA_NewLoan_MonthlyDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
				UserName = prop.getProperty("UserName_WY_PDL_pradeep");
				Password = prop.getProperty("Password_WY_PDL_pradeep");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(" S.NO:03:AA_NewLoan_MonthlyDue_Txn_Testdata"+Header, "AA_NewLoan_MonthlyDue_Txn_Testdata");
				
				
				
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_WY.NewLoan_WY(SSN, FileName);
				Monthly_duedate.Monthly_duedate(SSN, FileName);
				
			}
		}
		//Login.Login("CSR353","1234","353");
	}
	//@Test(priority=4,groups = "venkat_wy_PDL1")

	public void NewLoan_Weekly_Duedate() throws Exception 
	{
		String FileName= "AA_NewLoan_WeeklyDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
				UserName = prop.getProperty("UserName_WY_PDL_pradeep");
				Password = prop.getProperty("Password_WY_PDL_pradeep");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("S.NO:04:NewLoan_"+Header, "Weekly_Duedate");
				


				Login.Login(UserName,Password,StoreId);			
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_WY.NewLoan_WY(SSN, FileName);
				Weekly_duedate.Weekly_duedate(SSN, FileName);

              }
		}

	}


	//@Test(priority=5,groups = "venkat_wy_PDL1")

	  	public void NewLoan_Biweekly_Duedate() throws Exception 
		{
			String FileName= "AA_NewLoan_BiweeklyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
					UserName = prop.getProperty("UserName_WY_PDL_pradeep");
					Password = prop.getProperty("Password_WY_PDL_pradeep");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:05:NewLoan_Biweekly_Duedate_"+Header, "Biweekly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);			
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					Biweekly_duedate.Biweekly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}
		 

//@Test (priority=6,groups = "venkat_wy_PDL1") // Semi monthly has issue with loandate and duedate, so Not executing scenario.scenario , Not Ran in Staging

		public void NewLoan_SemiMonthly_Duedate() throws Exception
	       {
			String FileName= "AA_NewLoan_SemiDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
					UserName = prop.getProperty("UserName_WY_PDL_pradeep");
					Password = prop.getProperty("Password_WY_PDL_pradeep");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:06:NewLoan_SemiMonthly_Duedate_"+Header, "SemiMonthly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					semimonthly_duedate.semimonthly_duedate(SSN, FileName);
					//WebDriverWait wait = new WebDriverWait(driver, 10);
					//wait(100);
					// RegistrationPage.RegistrationPage(SSN);
				}
			}
			//Login.Login("CSR353","1234","353");
		}
	 

//@Test(priority=8,groups = "venkat_wy_PDL1")

		public void Newloan_MultipullDisb() throws Exception
		{
			String FileName= "AA_Newloan_MultipullDisb_Types.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
					UserName = prop.getProperty("UserName_WY_PDL_pradeep");
					Password = prop.getProperty("Password_WY_PDL_pradeep");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:08:AA_Newloan_MultipullDisb_Type"+Header, "AEA_Newloan_MultipullDisb_Type");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes_WY(SSN, FileName);
				}
			}
		}

//@Test(priority=9,groups = "venkat_wy_PDL1")

public void Newloan_Checking_CheckEligibleInMultipullDisb() throws Exception
{
	String FileName= "AA_Newloan_Checking_CheckEligibleInMultipullDisb.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			String StateID = TestData.getCellData(sheetName,"StateID",row);
			String SSN = TestData.getCellData(sheetName,"SSN",row);	
			String Header = StateID+ "_" + ProductID;
			test = reports.startTest("S.NO:09:New Loan Check disbursement_Validate whether check amount field is disabled ."+Header, "New Loan Check disbursement_Validate whether check amount field is disabled .");
			
			
			Login.Login(UserName,Password,StoreId);				
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_MultiDisb_CheckAmountField_Validation.NewLoan_MultiDisb_CheckAmountField_Validation(SSN, FileName);
		}
	}
}


//@Test (priority=10,groups = "venkat_wy_PDL1")// Agestore to 10-29-2019(before starting the transaction) for biweekly first payday radio button

public void RegistercustmerwhichdoesnotsatisifyMinterm_verifywhetherpayfrequencydatemovedaccordingtothedate() throws Exception {

// Start test. Mention test script name
String FileName= "AA_WY_PDL_RegistercustmerwhichdoesnotsatisifyMinterm_verifywhetherpayfrequencydatemovedaccordingtothedate_Txn_Testdata.xls";


// Start test. Mention test script name
TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
int lastrow=TestData.getLastRow("NewLoan");
String sheetName="NewLoan";
//int lastrow=TestData.getLastRow("Borrower");
System.out.println(lastrow);
for(int row=2;row<=lastrow;row++)
{
	String RunFlag = TestData.getCellData(sheetName,"Run",row);
	//System.out.println(RunFlag);
	if(RunFlag.equals("Y"))
	{	
		//driver.get(appUrl);
		//test.log(LogStatus.INFO, "Application is launched");
		//driver.manage().window().maximize();

		AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
		UserName = prop.getProperty("UserName_WY_PDL_pradeep");
		Password = prop.getProperty("Password_WY_PDL_pradeep");
		// System.out.println(Password);
		StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
		String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		String StateID = TestData.getCellData(sheetName,"StateID",row);
		String SSN = TestData.getCellData(sheetName,"SSN",row);	
		String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
		String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
		String Header = StateID + "_" + ProductID;
		//System.out.println(SSN);
		test = reports.startTest(Header + "_S.No:10_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType, "Register Any Payfrequency customer which does not satisfy Minterm _ verify whether loan due date is moved as payfrequency according to the date selected");
		
		
		//SetCurrentDate.SetCurrentDate(SSN, FileName);				
		Login.Login(UserName,Password,StoreId);
		
		RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL1(driver, test, AppURL, SSN, FileName);
		NewLoan_WY.NewLoan_WY(SSN, FileName);
		DueDate_Check.DueDate_Check(SSN, FileName);
		



	}
}

}					

//@Test (priority=69,groups = "venkat_wy_PDL1")

public void Advance_deposit_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:69" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_deposit_ACHR_ACHP with 2 tender types as CCK with same numbers_Transaction should not be processed");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			//Payliance.Payliance(SSN, FileName, 0);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_SameNumbers(SSN, FileName);

		}
	}

}

//@Test (priority=70,groups = "venkat_wy_PDL1")

public void Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:70_" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_deposit_ACHR_ACHP with 2 tender types as MO with same numbers_Transaction should not be processed");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_SameNumbers(SSN, FileName);

		}
	}

}
//@Test (priority=71,groups = "venkat_wy_PDL1")

public void Advance_deposit_ACHPPwith2tendertypessMOwithDiffnumbers_TransactionShouldbeprocessed_VoidWithcash() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessMOwithDiffnumbers_TransactionShoudbeprocessed_VoidWithCashTxn_Testdata.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:71_" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_deposit_ACHR_ACHP with 2 tender types as MO with different numbers_Transaction should be processed_Void ACHP with cash.");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_DiffNumbers(SSN, FileName);
			Voidwith_Cash.Voidwith_Cash(SSN, FileName);

		}
	}

}
//@Test (priority=72,groups = "venkat_wy_PDL1")

public void Advance_deposit_ACHPPwith2tendertypessCCKwithDiffnumbers_TransactionShouldBeprocessed_VoidwithOrignaltender() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithDiffnumbers_TransactionShoudbeprocessed_VoidWithOrignalTenderTxn_Testdata.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:72" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_deposit_ACHR_ACHP with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHP with Original tender type.Validate screen if its displaying tender details properly");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			//Payliance.Payliance(SSN, FileName, 0);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
			Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);
		}
	}

}

//@Test (priority=108,groups = "venkat_wy_PDL1")

public void NewLoan_Perform_EPP() throws Exception {

	// Start test. Mention test script name
	String FileName= "AA_NewLoan_Perform_EPP.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";
	//int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);
		//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			//driver.get(appUrl);
			//test.log(LogStatus.INFO, "Application is launched");
			//driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			String StateID = TestData.getCellData(sheetName,"StateID",row);
			String SSN = TestData.getCellData(sheetName,"SSN",row);	
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String Header = StateID+ "_" + ProductID;
			//System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:108" + "_" + PayFrequency +Header, "Loan_Age the store_perform EPP");
			
			
			//SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName,Password,StoreId);
	
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,-2);
			RPPPerform.RPPPerform(SSN, FileName);			        
		
		}
	}
}
//@Test (priority=109,groups = "venkat_wy_PDL1")

public void NewLoan_Perform_EPP_AgestoreInstWise_PerformPaymentPlan() throws Exception {

	// Start test. Mention test script name
	String FileName= "AA_NewLoan_Perform_EPP_AgestoreInstWise_PerformPaymentPlan_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";
	//int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);
		//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			//driver.get(appUrl);
			//test.log(LogStatus.INFO, "Application is launched");
			//driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			String StateID = TestData.getCellData(sheetName,"StateID",row);
			String SSN = TestData.getCellData(sheetName,"SSN",row);	
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String Header = StateID+ "_" + ProductID;
			//System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:109" + "_" + PayFrequency +Header, "Loan-EPP_age the store installment wise_perform Paymentplan Payment");
			
			
			//SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName,Password,StoreId);
	
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,-2);
			RPPPerform.RPPPerform(SSN, FileName);		        
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0,3);
			RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 4);
			RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 5);
			RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 6);
			RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
		}
	}
}
//@Test (priority=110,groups = "venkat_wy_PDL1")

public void NewLoan_Perform_EPP_CheckEoD_RecordDispalyORNot() throws Exception {

	// Start test. Mention test script name
	String FileName= "AA_NewLoan_Perform_EPP_CheckEoD_RecordDispalyORNot_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";
	//int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);
		//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			//driver.get(appUrl);
			//test.log(LogStatus.INFO, "Application is launched");
			//driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			String StateID = TestData.getCellData(sheetName,"StateID",row);
			String SSN = TestData.getCellData(sheetName,"SSN",row);	
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String Header = StateID+ "_" + ProductID;
			//System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:110" + "_" + PayFrequency +Header, "Loan_EPP_Miss the EPP Payment_Age the store_Perform EOD_Customer record should display in EOD process with Check box selected");
			
			
			//SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName,Password,StoreId);
	
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,-2);
			RPPPerform.RPPPerform(SSN, FileName);			        
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0,3);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			AfterEPPEODProcessing_with_recordsChecking.AfterEPPEODProcessing_with_recordsChecking(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			
			
		}
	}
}
//@Test (priority=111,groups = "venkat_wy_PDL1")

public void NewLoan_Perform_EPP_AgeStore14DaysFormEPPDueDate_CheckEoD_RecordDispalyed() throws Exception {

	// Start test. Mention test script name
	String FileName= "AA_NewLoan_Perform_EPP_AgeStore14DaysFormEPPDueDate_CheckEoD_RecordDispalyed_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";
	//int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);
		//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			//driver.get(appUrl);
			//test.log(LogStatus.INFO, "Application is launched");
			//driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			String StateID = TestData.getCellData(sheetName,"StateID",row);
			String SSN = TestData.getCellData(sheetName,"SSN",row);	
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String Header = StateID+ "_" + ProductID;
			//System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:111" + "_" + PayFrequency +Header, "Loan_EPP_Miss the EPP Payment_Age the store to 14 days from EPP due date_Perform EOD_Customer record should display in EOD process and should comes out forcefully from EPP.");
			
			
			//SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName,Password,StoreId);
	
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,-2);
			RPPPerform.RPPPerform(SSN, FileName);			        
			AgeStore_EPP.AgeStore_EPP(SSN, FileName, 14,3);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			AfterEPPEODProcessing_with_recordsChecking.AfterEPPEODProcessing_with_recordsChecking(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			CheckRPPinDropdown.CheckRPPinDropdown(SSN, FileName);
			
			
		}
	}
}

//@Test(priority = 112, groups = "venkat_wy_PDL1")

public void AA_RPPPayment_With2tenderMO_Diffnumbers_Trans_ShouldBeProcessed_VoidWithCash() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_RPPPayment_With2tenderMO_Diffnumbers_Trans_ShouldBeProcessed_VoidWithCash_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:112" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_EPP_PPAY with 2 tender types as MO with different numbers_Transaction should be processed_Void ACHPP with cash.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EPP.EPP(SSN, FileName);
			RPPPayment_With2tenderMO_Diffnumbers.RPPPayment_With2tenderMO_Diffnumbers(SSN, FileName);
			Voidwith_Cash.Voidwith_Cash(SSN, FileName);

		}
	}
}

//@Test(priority = 113, groups = "venkat_wy_PDL1")

public void AA_RPPPayment_With2tenderMO_Same_numbers_Trans_ShouldNotBeProcessd() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_RPPPayment_With2tenderMO_Same_numbers_Trans_ShouldNotBeProcessd_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:113" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_EPP_PPAY with 2 tender types as MO with same numbers_Transaction should not be processed.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EPP.EPP(SSN, FileName);
			RPPPayment_With2tenderMO_Samenumbers.RPPPayment_With2tenderMO_Samenumbers(SSN, FileName);
	         

		}
	}
}

//@Test(priority = 114, groups = "venkat_wy_PDL1")

public void AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_VoidWithOriginalTender() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_VoidWithOriginalTender_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:114" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_EPP_PPAY with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHPP with Original tender type.Validate screen if its displaying tender details properly.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EPP.EPP(SSN, FileName);
			RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
			Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);

		}
	}
}
//@Test(priority = 115, groups = "venkat_wy_PDL1")

public void AA_RPPPayment_With2tenderCCK_Same_numbers_Trans_ShouldNotBeProcessd() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_RPPPayment_With2tenderCCK_Same_numbers_Trans_ShouldNotBeProcessd_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:115" + "_" + PayFrequency + "_" + CollateralType,
					"Advance_EPP_PPAY with 2 tender types as CCK with same numbers_Transaction should not be processed.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EPP.EPP(SSN, FileName);
			RPPPayment_With2tenderCCK_Samenumbers.RPPPayment_With2tenderCCK_Samenumbers(SSN, FileName);
	         

		}
	}
}
//@Test(priority = 116, groups = "venkat_wy_PDL1")

public void AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_MidDayDeposit() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_MidDayDeposit_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:116" + "_" + PayFrequency + "_" + CollateralType,
					"Advance =>EPP =>PPAY with 2 tender types as CCk with different numbers =>Transaction should be processed =>deassign drawer =>Validate they are available for mid day deposit.Process Mid day deposit =>Void ACHPP Only cash should be displayed.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EPP.EPP(SSN, FileName);
			RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			MidDayDeposit.MidDayDeposit(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			SafeDeAssign.SafeDeAssign(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			Voidwith_Cash.Voidwith_Cash(SSN, FileName);
			

		}
	}
}
//@Test(priority = 82, groups = "venkat_wy_PDL1")

public void Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_DepositIsNotProcessed() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_DepositIsNotProcessed_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:82" + "_" + PayFrequency + "_" + CollateralType,
					"Loan -- > Pre Note DEP > PreNote Clr --> Change BNK status to Inactive before due date --> Custmr should not come for DEPosit on due date.");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);			AgeStore.AgeStore(SSN, FileName, -7);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
			AgeStore.AgeStore(SSN, FileName, -1); 
			PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);   
			Clear_Status.Clear_Status(SSN, FileName);
			EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			//EODProcessing.EODProcessing(SSN, FileName); 
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
			Deposit_History.Deposit_History(SSN, FileName);
			
			

		}
	}
}

//@Test(priority = 83, groups = "venkat_wy_PDL1")

public void Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_ActiveBNK_DepositIsProcessed() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_ActiveBNK_DepositIsProcessed_TextData.xls";
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     

	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";

	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			test = reports.startTest(Header + "_S.No:83" + "_" + PayFrequency + "_" + CollateralType,
					"Loan_Pre Note DEP_PreNote Clr_Change BNK status to Inactive before due date_again Change BNK status to ACT on due dt_Custmr should come for DEPosit on due date");

			Login.Login(UserName, Password, StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);			
			AgeStore.AgeStore(SSN, FileName, -7);
			
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
			AgeStore.AgeStore(SSN, FileName, -1); 
			PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);   
			Clear_Status.Clear_Status(SSN, FileName);
			EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			EditBorrower_active.EditBorrower_active(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			//EODProcessing.EODProcessing(SSN, FileName); 
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
			Deposit_History.Deposit_History(SSN, FileName);
			
			

		}
	}
}

//@Test (priority=95,groups = "venkat_wy_PDL1")

public void LoanWithACH_Deposit_Return() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_LoanWithACH_Deposit_Return_TextData.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:95" + "_" + PayFrequency + "_" + CollateralType,
					 "Loan (ACH)_Nacha_Ach Deposit process_Ach Return posting");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			//Payliance.Payliance(SSN, FileName, 0);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			
		}
	}

}
//@Test (priority=96,groups = "venkat_wy_PDL1")

public void LoanWithCHECk_Deposit_Return() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_LoanWithCHECk_Deposit_Return_TextData.xls";

	// Start test. Mention test script name
	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") + FileName);     
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();

			AppURL = prop.getProperty("AppURL_WY_PDL_pradeep");
			UserName = prop.getProperty("UserName_WY_PDL_pradeep");
			Password = prop.getProperty("Password_WY_PDL_pradeep");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:96" + "_" + PayFrequency + "_" + CollateralType,
					 "Loan(Check)_Nacha_Ach Deposit process_Ach Return posting");

			// SetCurrentDate.SetCurrentDate(SSN, FileName);
			Login.Login(UserName, Password, StoreId);

			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			NewLoan_WY.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName,0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			//Payliance.Payliance(SSN, FileName, 0);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			
		}
	}

}


	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		// driver.quit();

	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// TakesScreenshot ts = (TakesScreenshot) driver;
		// File source = ts.getScreenshotAs(OutputType.FILE);

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/ExecutionReports/LOC/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void quit() {
		// Closing browser
		driver.quit();

	}

	public void takeScreenShot(WebDriver driver, String filePath) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

		reports = new ExtentReports(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
		/*
		 * reports = new ExtentReports(System.getProperty("user.dir") +
		 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
		 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
		 */
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

		

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(5000); // Allow OS to kill the process
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
 		driver = new InternetExplorerDriver();
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
 		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * String Node = "http://192.168.2.123:5555/wd/hub"; DesiredCapabilities
		 * cap = DesiredCapabilities.internetExplorer();
		 * 
		 * 
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe");
		 * 
		 * driver = new RemoteWebDriver(new URL(Node), cap);
		 */
		/*
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver();
		 */
	}

	public boolean IsElementExits(String Value) {
		int secondsToWait = 5;

		try {
			new WebDriverWait(driver, secondsToWait)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Value)));
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static WebElement Field(WebDriver driver) {

		try {
			Thread.sleep(500);
			WebElement element = (new WebDriverWait(driver, 9)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table")));
			return element;
		} catch (Exception e) {
			return null;
		}
	}

	public void proc(String ReturnFormat) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");

		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2",
					"QFUNDX_LOCAL_AUTOMATION", "QFUNDX_LOCAL_AUTOMATION");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");

		try {
			String A = null;

			String content;

			String fw = "E:\\AdminLogin.txt";
			// String content = "\r\n";

			// content=A;
			// fw = "E:\\AdminLogin.txt";

			appendUsingFileWriter(fw, ReturnFormat);
			// appendUsingFileWriter(fw,"\r\n");
			// appendUsingFileWriter(fw,content);

			// String str = content.readLine();

			fw.replaceAll("[0-9,a-z,A-Z]{17,21}", A);

			// fw.close();

			System.out.println("after query");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

	private static void appendUsingFileWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file);
			fr.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
