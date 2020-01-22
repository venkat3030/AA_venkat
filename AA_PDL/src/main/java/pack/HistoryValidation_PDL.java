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

public class HistoryValidation_PDL extends AA_PDL{
	public static void HistoryValidation(String SSN,String FileName) throws Exception
	{

		
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
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
				////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
				
				
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				if(ProductID.equals("PDL"))
				{

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				
				List<WebElement> options = driver.findElements(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td"));
				int schsize = options.size();
				test.log(LogStatus.INFO,"<FONT color=green style=Arial>Rows count ::::"+schsize);
				for (int i = 1; i <= schsize; i++) {
					List<WebElement> options1 = driver.findElements(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr"));
					int schsize1 = options1.size();
					System.out.println(schsize1);
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Columns count ::::"+schsize1);


					for (int j = 1; j <= schsize1; j++) {

						try{
						//String field1 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td")).getText();
						String field = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[1]/b")).getText();
						//test.log(LogStatus.INFO,"<FONT color=green style=Arial>field Value accessed ::::"+field);
                                         //*[@id="transactionHistoryTable"]/tbody/tr/td[3]    /table/tbody   /tr[13]/td/span[1]/b
						                           //               
						if(field.equals(" Customer "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							                                             // //*[@id="transactionHistoryTable"]/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]
							test.log(LogStatus.INFO,"<FONT color=green style=Arial>Customer is ::::"+field2);
			

						}
						
						else if(field.equals(" Customer Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>Customer Nbr is ::::"+field2);
			

						}
						
						else if(field.equals(" Migration CustNbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>Migration CustNbr  is ::::"+field2);
			

						}
						
						else if(field.equals(" SSN / ITIN "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> SSN / ITIN  is ::::"+field2);
			

						}
						else if(field.equals(" Primary Phone Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Primary Phone Nbr  is ::::"+field2);
			

						}
						else if(field.equals(" Phone Type "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Phone Type   is ::::"+field2);
			

						}
						else if(field.equals(" State "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> State   is ::::"+field2);
			

						}
						
						else if(field.equals(" Email "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Email  is ::::"+field2);
			

						}
						else if(field.equals(" Customer Type "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Customer Type  is ::::"+field2);
			

						}
						else if(field.equals(" Migration Source "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Migration Source  is ::::"+field2);
			

						}
						
						
						
						
						
						//Customer Active Bank Information
						
						else if(field.equals(" Type Of Account "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Type Of Account  is ::::"+field2);
			

						}
						
						else if(field.equals(" ABA/Routing Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   ABA/Routing Nbr  is ::::"+field2);
			

						}
						else if(field.equals(" Account Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Account Nbr  is ::::"+field2);
			

						}
						else if(field.equals(" Check Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Check Nbr  is ::::"+field2);
			

						}
						
						else if(field.equals(" Account Status "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Account Status   is ::::"+field2);
			

						}
						else if(field.equals(" Bank Name "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Bank Name  is ::::"+field2);
			

						}
					
						// Employer Information
						
						
						else if(field.equals(" Primary Source Of Income "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Primary Source Of Income  is ::::"+field2);
			

						}
						else if(field.equals(" Current Employer "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Current Employer   is ::::"+field2);
			

						}
						else if(field.equals(" Net Pay "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Net Pay  is ::::"+field2);
			

						}
						else if(field.equals(" Gross Pay "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Gross Pay  is ::::"+field2);
			

						}
						else if(field.equals(" Pay Frequency "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Pay Frequency  is ::::"+field2);
			

						}
						
						else if(field.equals(" Employer Phone Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Employer Phone Nbr   is ::::"+field2);
			

						}
						
						//Loan Account Status
						
						
						
						else if(field.equals(" Loan Status "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Loan Status  Nbr   is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Check Status "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Check Status Nbr   is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Due Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Due Date   is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Future Deposit Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Future Deposit Date   is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Re-Deposit Count "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Re-Deposit Count   is ::::"+field2);
							
							
			

						}

						else if(field.contains(" Default Date  "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Default Date    is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Write Off Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Write Off Date     is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Pending Bankruptcy "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Pending Bankruptcy  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Bankruptcy Filling Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Bankruptcy Filling Date  is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Bankruptcy Status "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Bankruptcy Status  is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Dismissed/Discharge Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Dismissed/Discharge Date is ::::"+field2);
							
							
			

						}
						
				/*		
						else if(field.equals("GPE Requested Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

						

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  GPE Requested Date is ::::"+field2);
							
							
			

						}
						
						*/
						else if(field.equals(" GPE Removal Date :"))
						{
							
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

				/*			test.log(LogStatus.INFO,"<FONT color=green style=Arial>  column ::::"+j);
							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  row ::::"+i);*/
							
							
							int k = j-1;
							String field3 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+k+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  GPE Removal Date is ::::"+field2);
							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  GPE Requested Date is ::::"+field3);
							
			

						}
						else if(field.contains("Wpn Status"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Wpn Status is ::::"+field2);
							
							
			

						}
						//Loan Balance Summary
						
						
						else if(field.equals(" Principal Balance "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Principal Balance  is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Fee Due :"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Fee Due  is ::::"+field2);
							
							
			

						}
						else if(field.contains("Return Fee Due"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial> Return Fee Due   is ::::"+field2);
							
							
			

						}
						else if(field.contains("Late Fee Due"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Late Fee Due    is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Pay-Off Amt "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Pay-Off Amt     is ::::"+field2);
							
							
			

						}
						
						//Loan Paid To-Date Summary
						
						else if(field.contains("Principal Paid to date"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Principal Paid to date    is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Fee Paid to date :"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Fee Paid to date    is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Return Fee Paid to date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Return Fee Paid to date is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Late Fee Paid to date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Late Fee Paid to date is ::::"+field2);
						}
						else if(field.equals(" Total Paid Amt "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Total Paid Amt is ::::"+field2);
						}
						
						//Loan Account Information
						
						else if(field.equals(" Product Name : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Product Name is ::::"+field2);
						}
						else if(field.equals(" Product Type : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Product Type is ::::"+field2);
						}
						
						else if(field.equals(" Loan Nbr "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Loan Nbr  is ::::"+field2);

						}
						else if(field.equals(" Migration LoanNbr : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Migration LoanNbr is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Loan Amt "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Loan Amt  is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Finance Charge "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Finance Charge  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" APR "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   APR   is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Interest Rate/Fee "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Interest Rate/Fee  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Loan Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Loan Date  is ::::"+field2);
						}
						
						else if(field.equals(" Collateral Type "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Collateral Type  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Loan Frequency "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Loan Frequency   is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Origination Store "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>   Origination Store  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Origination/Documentation Fee : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Origination/Documentation Fee  is ::::"+field2);
							
							
			

						}
						
						else if(field.equals(" Available Credit : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Available Credit  is ::::"+field2);
							
							
			

						}
						else if(field.equals("  Collateral Status : "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Collateral Status  is ::::"+field2);
							
							
			

						}
						else if(field.equals(" Accrual Date "))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Accrual Date  is ::::"+field2);
							
							
			

						}
						
						//Loan Bank Account Information
						
						else if(field.contains("Loan ABA/Routing Nbr"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Loan ABA/Routing Nbr  is ::::"+field2);
							
							
			

						}
						
						else if(field.contains("Loan Account Nbr"))
						{
							String field2 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td["+i+"]/table/tbody/tr["+j+"]/td/span[2]")).getText();

							test.log(LogStatus.INFO,"<FONT color=green style=Arial>  Loan Account Nbr  is ::::"+field2);
							
							
			

						}
						
						}
						
						
						catch (Exception e) {
						}

					
					
						}
					


					
						}
					}
		}
		
				
				
			
			//}
		}
		
	}
		










				
				
				