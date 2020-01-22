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

public class ACH_Clear extends AA_PDL{
	public static void ACH_Clear(String SSN,String FileName) throws Exception
	{

	//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";		
	for(int row=2;row<=lastrow;row++)
	{	
		String RegSSN = TestData.getCellData(sheetName,"SSN",row);
		if(SSN.equals(RegSSN))
		{
			String TxnType=TestData.getCellData(sheetName,"TxnType",row);
			String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
			String ProductID=TestData.getCellData(sheetName,"ProductID",row);
			//String UserName = TestData.getCellData(sheetName,"UserName",row);
			//String Password = TestData.getCellData(sheetName,"Password",row);
			String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
			////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
			//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
			//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
			//appUrl = AppURL;
			

			Login.Login(UserName, Password, StoreId);
			Thread.sleep(2000);	
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3,5);
			String SSN3 = SSN.substring(5,9);
			driver.switchTo().frame("topFrame");
			driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
			test.log(LogStatus.PASS, "Clicked on Loan Transactions");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("li[id='911101']")).click();			
			test.log(LogStatus.PASS, "Clicked on Transactions");		
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
							    
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
Thread.sleep(2000);
			//String LoanNumber = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[6]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
															//html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]
			//test.log(LogStatus.PASS, "Captured Loan Number"+LoanNumber);
			
			
			if(ProductID.equals("PDL"))
			{
				//driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}
			
			test.log(LogStatus.PASS, "Click on GO Button");
			
						
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			driver.findElement(By.name("transactionList")).sendKeys("ACH Clear");
			test.log(LogStatus.PASS, "Transaction Type is selected as: "+"ACH Clear");	
			driver.findElement(By.id("go_Button")).click();

							
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
			
				 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[4]/td[1]/input")).click();
				 
				 /*	 int CheckBoxsize= driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr")).size();
				 
				for (int i =3; i <= CheckBoxsize;i++)
				{
					                                            /html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[4]/td[4]					 
					String Value = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr["+i+"]/td[1]/input[2]")).getAttribute("value");
					 
					 if (Value.contains(LoanNumber)) {
					 
						 driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr["+i+"]/td[1]/input[2]")).click();
						 test.log(LogStatus.PASS, "Customer Record CheckBox Selected");
						 
								
					 
					 break;
					 
					 }
					}*/
				  
					
				
		
						driver.findElement(By.name("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on ACH Clear button");
						
								
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 
						 test.log(LogStatus.PASS, "ACH clear Done Successfull");					 
					
	/*			if(driver.findElement(By.name("Ok")).isDisplayed())
				 
				{
					test.log(LogStatus.PASS, "ACH Return Posting Done Successfull");
					//driver.findElement(By.name("Ok")).click();
						
				}*/
		}

	}
	
}

	}
