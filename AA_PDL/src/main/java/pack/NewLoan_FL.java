



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

	public class NewLoan_FL  extends AA_PDL{
		public static void NewLoan_FL(String SSN,String FileName) throws Exception{

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
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					//String stateProduct=State+" "+ProductID;
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
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
					String Parent_Window = driver.getWindowHandle();
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 Thread.sleep(3000);
					 //	Selection of Product based on the Name provided in Test Data
					
					 //if(driver.findElement(By.id("LoanButtonId")).isEnabled())
					 test.log(LogStatus.INFO, "Navigate New Loan ");
					 if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
					 {
						 

						 int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();
				                                      
							//List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
						 test.log(LogStatus.INFO, "Rows count :: "+rows);
						 
							for (int a=2;a<=rows;a++)
							{
								String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
								test.log(LogStatus.INFO, "Product name is :: "+prod);
								if (prod.equals(ProductName))
								{
								
									Thread.sleep(3000);
									//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")));
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input
									 //driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();

									driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();
									                             
									test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
								}
							}
							Thread.sleep(1000);
							WebDriverWait wait = new WebDriverWait(driver, 10);
							
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]
							
							
							
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
							// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input

						
						
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
							Thread.sleep(2000);
							String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
							System.out.println(Instamt);
							Thread.sleep(3000);
							driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
							
							test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
							Thread.sleep(1000);
							///driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
							//test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
							driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
							Thread.sleep(1000);
						
							if(ESign_CollateralType.equalsIgnoreCase("Check"))
							{
								Thread.sleep(1000);
								//requestBean.noOfChecks
								//driver.findElement(By.name("requestBean.noOfChecks")).sendKeys("1");

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
							 Thread.sleep(2000);
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
						if(ProductID.equals("ILP"))
						{	
							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);									
							driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
							test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
							String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
							System.out.println(Instamt);
							driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
							test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
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
								driver.findElement(By.name("allowPromotion")).click();
								test.log(LogStatus.PASS, "AllowPromotion is selected ");
								//String mwh=driver.getWindowHandle();
								driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
								test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
								//String winHandle = driver.getWindowHandle(); //Get current window handle.									
							}
							 WebElement ele = driver.findElement(By.name("requestBean.siilBean.nbrOfInst"));
					 		String NumofInst=ele.getAttribute("value");
					 		//*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[5]/td[2]/input
					 		System.out.println(NumofInst);
					 		int installments = Integer.parseInt(NumofInst);
					 		for(int i=0;i<installments;i++)
					 		{
					 			 Random rand = new Random();
					 			 int rand1 = rand.nextInt(1000);	
					 			 String chknum = Integer.toString(rand1);
					 			driver.findElement(By.id("checkNbrs"+i)).sendKeys(chknum);
					 			test.log(LogStatus.PASS, "Enter CHK Number"+chknum);
					 			
					 			
					 		}			 					 			
							driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
							driver.findElement(By.name("finishLoan")).click();
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
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
							driver.findElement(By.name("OKBut")).click();
							//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();				
							test.log(LogStatus.PASS, "click on Yes button ");
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								driver.findElement(By.name("ok")).click();
							}
							else
							{
								test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							}
						}
							
						if(ProductID.equals("TLP"))
						{	
							String TitleNumber= TestData.getCellData(sheetName,"TitleNumber",row);
							String AppraisalValue= TestData.getCellData(sheetName,"Appraisal Value",row);
							String ExteriorColor=TestData.getCellData(sheetName,"ExteriorColor",row);
							String LicensePlateNumber=TestData.getCellData(sheetName,"License Plate Number",row);
							//String VehicleGrade=TestData.getCellData(sheetName,"Vehicle Grade",row);
							String LicensePlateExp=TestData.getCellData(sheetName,"License Plate Expiry",row);
							String InsuranceCoverage=TestData.getCellData(sheetName,"Insurance Coverage",row);
							String PhoneNbr=TestData.getCellData(sheetName,"Phone Nbr",row);
							String PhoneNbr1 = PhoneNbr.substring(0, 3);
					        String PhoneNbr2 = PhoneNbr.substring(3, 6);
					        String PhoneNbr3 = PhoneNbr.substring(6, 10);
					        String InsuranceCompany =TestData.getCellData(sheetName,"Insurance Company",row);
					        String InsuranceExpiryDate=TestData.getCellData(sheetName,"Insurance Expiry Date",row);
					        String PolicyNumber=TestData.getCellData(sheetName,"Policy Number",row);
					        String InsuranceExpiryDate0[] =InsuranceExpiryDate.split("/");
					        String InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
					        String InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
					        String InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
							driver.findElement(By.name("requestBean.titleNumber")).sendKeys(TitleNumber);
							driver.findElement(By.xpath("//*[@id='appraisal']")).sendKeys(AppraisalValue);
						//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElement(By.name("button1")).click();
							test.log(LogStatus.PASS, "click on Update 1 button ");
							//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							WebDriverWait wait1 = new WebDriverWait(driver, 10);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("requestBean.extClr")));
							driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
							driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(LicensePlateNumber);
							driver.findElement(By.name("requestBean.licensePltExpire")).sendKeys(LicensePlateExp);
							driver.findElement(By.name("requestBean.paintCondition")).sendKeys("Clean");
							driver.findElement(By.name("requestBean.bodyCondition")).sendKeys("Clean");
							driver.findElement(By.name("requestBean.glassCondition")).sendKeys("Clean");
							driver.findElement(By.name("requestBean.tiresCondition")).sendKeys("Clean");
							driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
							driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
							driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
							driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
							driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
							driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);
							driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
							driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
							driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
							driver.findElement(By.name("button2")).click();			
							driver.findElement(By.name("button2")).click();	
							//driver.findElement(By.name("button2")).click();	
							//driver.findElement(By.name("button2")).click();	
							test.log(LogStatus.PASS, "click on Update 2 button ");
							Thread.sleep(2000);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
							driver.findElement(By.name("process")).click();
							//driver.findElement(By.name("process")).click();
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
							test.log(LogStatus.PASS, "click on process Loan button ");
							try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
							//Thread.sleep(3000);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("collateralType")));
							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);									
							driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
							test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
							String Instamt=driver.findElement(By.name("cashToCust")).getAttribute("value");
							System.out.println(Instamt);
							driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Instamt);
							test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
							driver.findElement(By.name("vehicleKey")).sendKeys("Yes");					
							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
							driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
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
								driver.findElement(By.name("allowPromotion")).click();
								test.log(LogStatus.PASS, "AllowPromotion is selected ");
								//String mwh=driver.getWindowHandle();
								driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
								test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
								//String winHandle = driver.getWindowHandle(); //Get current window handle.									
							}
							driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
							driver.findElement(By.name("finishLoan")).click();
							test.log(LogStatus.PASS, "Click on Finish Loan Button");
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(By.xpath("//*[@id='OKBut']")).click();	
							 //driver.findElement(By.name("OKBut")).click();
							//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();				
							test.log(LogStatus.PASS, "click on Yes button ");
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								driver.findElement(By.name("ok")).click();
							}
							else
							{
								test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							}
						}
						if(ProductID.equals("LOC"))
						{
						
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "CollateralType is selected as "+ESign_CollateralType);
							Thread.sleep(3000);
							driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
							driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
							driver.findElement(By.name("requestBean.password")).sendKeys(Password);
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "Click on Finish LOC Button");
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(By.xpath("//*[@id='OKBut']")).click();	
							 //driver.findElement(By.name("OKBut")).click();
							//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();				
							test.log(LogStatus.PASS, "click on Yes button ");
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							
							if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input")).isDisplayed())
							{
								test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input")).click();
							}
							else
							{
								test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							}
						}
							
						//html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td/input
					 	}
						
				}
			}
		}
		
	}

		



