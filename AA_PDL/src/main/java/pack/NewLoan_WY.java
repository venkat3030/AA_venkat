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

public class NewLoan_WY extends AA_PDL{
	
	
	public static void NewLoan(String SSN,String FileName) throws Exception{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_SmokeTest/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);

				int lastrow=TestData.getLastRow("NewLoan");
				System.out.println("NewLoan "+lastrow);
				String sheetName="NewLoan";		
				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{		
						String State = TestData.getCellData(sheetName,"StateID",row);
						String ProductID=TestData.getCellData(sheetName,"ProductID",row);
						System.out.println(ProductID);
						String ProductType = TestData.getCellData(sheetName,"ProductType",row);
						String ProductName = TestData.getCellData(sheetName,"ProductName",row);
						//String Term = TestData.getCellData(sheetName,"Term",row);
						String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
						String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
						//System.out.println(Term);
						//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
						//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
						//String stateProduct=State+" "+ProductID;
						String stateProductType=State+" "+ProductType;
						String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
						String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
						String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
						String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
						String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
						String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
						String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
						String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
						String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						System.out.println(last4cheknum);
						System.out.println(stateProductType);
					
					

					
						Login.Login(UserName,Password,StoreId);
						String Parent_Window = driver.getWindowHandle();
						test.log(LogStatus.PASS,"<FONT color=green style=Arial> ----------- NewLoan ILP -----------");

							String SSN1 = SSN.substring(0, 3);
							String SSN2 = SSN.substring(3,5);
							String SSN3 = SSN.substring(5,9);
							Thread.sleep(5000);
							Thread.sleep(5000);
							driver.switchTo().frame("topFrame");

							driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							//*[@id="911100"]/a
							driver.findElement(By.cssSelector("li[id='911100']")).click();			
							test.log(LogStatus.PASS, "Clicked on New Loan");			
							driver.switchTo().frame("main");		
							driver.findElement(By.name("ssn1")).sendKeys(SSN1);
							test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
							driver.findElement(By.name("ssn2")).sendKeys(SSN2);
							test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
							driver.findElement(By.name("ssn3")).sendKeys(SSN3);
							test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
							driver.findElement(By.name("submit1")).click();
							test.log(LogStatus.PASS, "Click on submit Button");		
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Click on GO Button");
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}				    

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");



							test.log(LogStatus.INFO, "Navigated to Loan decisioning Screen");

						 if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
						 {
							

							/*	 WebDriverWait wait = new WebDriverWait(driver, 10);	
								 ///////////////////////////////////////////////////////////////// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
								 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")));
								*/ 
							 Thread.sleep(4000);
							 driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
								 test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
							 


						 }
						 driver.findElement(By.name("ShareScreenBtn")).click();
						 test.log(LogStatus.PASS, "ShareScreen Button clicked");
						 for( String winHandle1 : driver.getWindowHandles())
						 {
							 if(!(winHandle1.equals(Parent_Window)))
							 {
								 driver.switchTo().window(winHandle1);
								 Thread.sleep(2000);
								 driver.findElement(By.name("confirmSummary")).click();
								 test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
							 }

						 }
						 Thread.sleep(2000);
						 driver.switchTo().window(Parent_Window);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 driver.findElement(By.id("LoanButtonId")).click();
						 //driver.findElement(By.id("LoanButtonId")).click();
						 test.log(LogStatus.PASS, "Clicked on New Loan button");
						 //New Loan Screens
						 if(ProductID.equals("PDL"))	
						 {							
							 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/input")).sendKeys(ESign_CollateralType);
							 test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
							 if(!(ESign_LoanAmt.isEmpty()))
							 {
								 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
								 test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
							 }
							 driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
							 test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as : "+last4cheknum);	
							 Thread.sleep(1000);
							 driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
							 test.log(LogStatus.PASS, "Disb Type is Selected as "+ESign_DisbType);
							 Thread.sleep(1000);
							 String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
							 System.out.println(Instamt);
							 driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);								
							 test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
							 Thread.sleep(1000);
							 ///driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
							 //test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
							 driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							 test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
							 Thread.sleep(1000);
							 if(ESign_CourtesyCallConsent.equals("Yes"))
							 {
								 if(ESign_Preference.equals("Call"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								 }
								 if(ESign_Preference.equals("Mail"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								 }
								 if(ESign_Preference.equals("SMS"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

									 try { 
										 Alert alert = driver.switchTo().alert();
										 alert.dismiss();

										 //if alert present, accept and move on.														

									 }
									 catch (NoAlertPresentException e) {
										 //do what you normally would if you didn't have the alert.
									 }
								 }

							 }
							 if(AllowPromotion.equals("Yes"))
							 {
								 driver.findElement(By.xpath("//*[@id='allowCoupons']/td[3]/input")).click();
								 test.log(LogStatus.PASS, "AllowPromotion is selected ");
								 driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);
								 test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
							 }
							 Thread.sleep(1000);
							 if(ESign_CollateralType.equals("CHECK"))
							 {
								 Thread.sleep(2000);									
								 driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);

								 test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Checks);
								 WebDriverWait wait2 = new WebDriverWait(driver, 1000);	
								 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));
								 driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
								 test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
							 }
							 driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
							 test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
							 driver.findElement(By.name("finishadvance")).click();
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
							 test.log(LogStatus.PASS, "click on Finish Loan button ");
							 try { 
								 Alert alert = driver.switchTo().alert();
								 alert.accept();
								 //if alert present, accept and move on.														

							 }
							 catch (NoAlertPresentException e) {
								 //do what you normally would if you didn't have the alert.
							 }
							 for( String winHandle1 : driver.getWindowHandles())
							 {
								 driver.switchTo().window(winHandle1);
							 }			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 Thread.sleep(1000);
							 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
							 //driver.findElement(By.name("OKBut")).click();					
							 driver.findElement(By.xpath("//*[@id='OKBut']")).click();		
							 //*[@id="OKBut"]
							 test.log(LogStatus.PASS, "clicked on Yes button ");
							 //Thread.sleep(2000);
							 /*for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("bdyLoad");*/
							 if(driver.findElement(By.name("Ok")).isDisplayed())
							 {
								 driver.findElement(By.name("Ok")).click();
								 test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								 //driver.findElement(By.name("Ok")).click();
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							 }


						 }
				}

				}
	}


	
	public static void NewLoan_WY(String SSN,String FileName) throws Exception{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_SmokeTest/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);

				int lastrow=TestData.getLastRow("NewLoan");
				System.out.println("NewLoan "+lastrow);
				String sheetName="NewLoan";		
				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{		
						String State = TestData.getCellData(sheetName,"StateID",row);
						String ProductID=TestData.getCellData(sheetName,"ProductID",row);
						System.out.println(ProductID);
						String ProductType = TestData.getCellData(sheetName,"ProductType",row);
						String ProductName = TestData.getCellData(sheetName,"ProductName",row);
						//String Term = TestData.getCellData(sheetName,"Term",row);
						String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
						String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
						//System.out.println(Term);
						//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
						//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
						//String stateProduct=State+" "+ProductID;
						String stateProductType=State+" "+ProductType;
						String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
						String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
						String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
						String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
						String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
						String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
						String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
						String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
						String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						System.out.println(last4cheknum);
						System.out.println(stateProductType);
					
					

					
						Login.Login(UserName,Password,StoreId);
						String Parent_Window = driver.getWindowHandle();
						test.log(LogStatus.PASS,"<FONT color=green style=Arial> ----------- NewLoan ILP -----------");

							String SSN1 = SSN.substring(0, 3);
							String SSN2 = SSN.substring(3,5);
							String SSN3 = SSN.substring(5,9);
							Thread.sleep(5000);
							Thread.sleep(5000);
							driver.switchTo().frame("topFrame");

							driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							//*[@id="911100"]/a
							driver.findElement(By.cssSelector("li[id='911100']")).click();			
							test.log(LogStatus.PASS, "Clicked on New Loan");			
							driver.switchTo().frame("main");		
							driver.findElement(By.name("ssn1")).sendKeys(SSN1);
							test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
							driver.findElement(By.name("ssn2")).sendKeys(SSN2);
							test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
							driver.findElement(By.name("ssn3")).sendKeys(SSN3);
							test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
							driver.findElement(By.name("submit1")).click();
							test.log(LogStatus.PASS, "Click on submit Button");		
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Click on GO Button");
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}				    

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");



							test.log(LogStatus.INFO, "Navigated to Loan decisioning Screen");

						 driver.findElement(By.name("ShareScreenBtn")).click();
						 test.log(LogStatus.PASS, "ShareScreen Button clicked");
						 for( String winHandle1 : driver.getWindowHandles())
						 {
							 if(!(winHandle1.equals(Parent_Window)))
							 {
								 driver.switchTo().window(winHandle1);
								 Thread.sleep(2000);
								 driver.findElement(By.name("confirmSummary")).click();
								 test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
							 }

						 }
						 Thread.sleep(2000);
						 driver.switchTo().window(Parent_Window);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 driver.findElement(By.id("LoanButtonId")).click();
						 //driver.findElement(By.id("LoanButtonId")).click();
						 test.log(LogStatus.PASS, "Clicked on New Loan button");
						 //New Loan Screens
						 
		
						 
						 
						 if(ProductID.equals("PDL"))	
						 {							
							 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/input")).sendKeys(ESign_CollateralType);
							 test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
							 
	
							 
							 try { 
								 driver.findElement(By.name("eeeComm")).click();
								 test.log(LogStatus.PASS, "Clicked on Eligibility button");
								 
								 Thread.sleep(6000);
								 Alert alert = driver.switchTo().alert();
								String Text= alert.getText();
								test.log(LogStatus.PASS, "Alert given in Eligibility screen is ::"+Text);
								 alert.accept();

								 //if alert present, accept and move on.														

							 }
							 catch (Exception e) {
								 //do what you normally would if you didn't have the alert.
							 }
							 //  name="advanceRequestBean.advanceAmt"
							 Thread.sleep(2000);
							 String LoanAmt = driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
							 test.log(LogStatus.PASS, "Loan Amount Eligible is ::"+LoanAmt);
							 Thread.sleep(2000);
							 driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(LoanAmt);
						 
				
							// driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys("");
							 
							 Thread.sleep(1000);
				
							 driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							 test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
							 Thread.sleep(1000);
							 if(ESign_CourtesyCallConsent.equals("Yes"))
							 {
								 if(ESign_Preference.equals("Call"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								 }
								 if(ESign_Preference.equals("Mail"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								 }
								 if(ESign_Preference.equals("SMS"))	
								 {
									 driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
									 test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

									 try { 
										 Alert alert = driver.switchTo().alert();
										 alert.dismiss();


									 }
									 catch (NoAlertPresentException e) {
									 }
								 }

							 }
							 if(AllowPromotion.equals("Yes"))
							 {
								 driver.findElement(By.xpath("//*[@id='allowCoupons']/td[3]/input")).click();
								 test.log(LogStatus.PASS, "AllowPromotion is selected ");
								 driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);
								 test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
							 }
							 Thread.sleep(1000);
							 if(ESign_CollateralType.equals("CHECK"))
							 {
								 Thread.sleep(2000);									
								 driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);

								 test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Checks);
								 WebDriverWait wait2 = new WebDriverWait(driver, 1000);	
								 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));
								 driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
								 test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
							 }
							// driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys("1234");

							 driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
							 test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
							 // finishadvance
							 driver.findElement(By.name("finishadvance")).click();
							 //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
							 test.log(LogStatus.PASS, "click on Finish Loan button ");
							 try { 
								 Alert alert = driver.switchTo().alert();
								 String Ale = alert.getText();
								 test.log(LogStatus.PASS, "Loan duration is ::"+Ale); 
								 alert.accept();
								 //if alert present, accept and move on.														

							 }
							 catch (NoAlertPresentException e) {
								 //do what you normally would if you didn't have the alert.
							 }
							 for( String winHandle1 : driver.getWindowHandles())
							 {
								 driver.switchTo().window(winHandle1);
							 }			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 Thread.sleep(1000);
							 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
							 //driver.findElement(By.name("OKBut")).click();
							// id="OKBut"
							 driver.findElement(By.xpath("//*[@id='OKBut']")).click();		
							 //*[@id="OKBut"]
							 test.log(LogStatus.PASS, "clicked on Yes button ");
							 //Thread.sleep(2000);
							 /*for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("bdyLoad");*/
							 // Ok
							 if(driver.findElement(By.name("Ok")).isDisplayed())
							 {
								 driver.findElement(By.name("Ok")).click();
								 test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								 //driver.findElement(By.name("Ok")).click();
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							 }


						 }
				}

				}
	}


				
	
	}

	

				

