package pack;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class NewLoan_FLILP extends AA_PDL{

	public static void NewLoan_FLILP(String SSN,String FileName, String NegAmt) throws Exception{


		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/FL_ILP/"+FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String State =TestData.getCellData(sheetName,"StateID",row);
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);

				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				System.out.println(ProductID);
				//String UserName =TestData.getCellData(sheetName,"UserName",row);
				//String Password =TestData.getCellData(sheetName,"Password",row);
				String ProductType =TestData.getCellData(sheetName,"ProductType",row);
				String ProductName = TestData.getCellData(sheetName,"ProductName",row);
				//String Term = TestData.getCellData(sheetName,"Term",row);
				String VehicleType=TestData.getCellData(sheetName,"VehicleType",row);
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				//System.out.println(Term);
				//String StoreId =
				//TestData.getCellData(sheetName,"StoreID",row);
				//String stateProduct=State+" "+ProductID;
				String stateProductType=State+" "+ProductType;
				String ESign_CollateralType =TestData.getCellData(sheetName,"ESign_CollateralType",row);
				System.out.println(ESign_CollateralType);
				String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				String ESign_CourtesyCallConsent =TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String AllowPromotion =TestData.getCellData(sheetName,"Allow Promotion",row);
				String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				String ESign_Preference =TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_Checks =TestData.getCellData(sheetName,"ESign_Checks",row);
				String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				String ESign_CheckNbr =TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String last4cheknum=ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String Parent_Window = driver.getWindowHandle();
				System.out.println(last4cheknum);
				System.out.println(stateProductType);
				String Parent_Window1 = driver.getWindowHandle();  
				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
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

				//    Selection of Product based on the Name provided in
				//Test Data
				// if(driver.findElement(By.id("LoanButtonId")).isEnabled())
				Thread.sleep(4000);
				/*if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
				{


					if(ProductName.equals("CO ILP"))
					{

						if(ESign_CollateralType.equals("ACH"))
						{
							//*[@id="termSel1"]

							driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);

						}

						if(ESign_CollateralType.equals("CASH"))
						{
							//*[@id="termSel1"]
							//driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							//*[@id="tableWid1"]/tbody/tr[1]/td/b
							//*[@id="tableWid2"]/tbody/tr[1]/td/b
							driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
						}
					}
*/
				
				//  //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input
					
				driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
				test.log(LogStatus.PASS, "Product is selected  ");
				driver.findElement(By.name("ShareScreenBtn")).click();
					test.log(LogStatus.PASS, "ShareScreen Button clicked");

					for( String winHandle1 : driver.getWindowHandles())

					{
						if(!(winHandle1.equals(Parent_Window)))
						{
							driver.switchTo().window(winHandle1);
							Thread.sleep(1000);
							driver.findElement(By.name("confirmSummary")).click();
							test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
						}

					}
					Thread.sleep(3000);
					driver.switchTo().window(Parent_Window);

					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					driver.findElement(By.id("LoanButtonId")).click();
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					//New Loan Screens
					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					
					if(ProductID.equals("PDL"))					{
							

						//negLoanAmt buton

						driver.findElement(By.name("negLoanAmt")).click();
						test.log(LogStatus.PASS, "NegotiableAmmount Button clicked");
						for( String winHandle1 : driver.getWindowHandles())

						{
							if(!(winHandle1.equals(Parent_Window1)))
							{

								Thread.sleep(3000);
								driver.switchTo().window(winHandle1);
								Thread.sleep(1000);
								driver.manage().window().maximize();
								Thread.sleep(3000);
								Robot robot = new Robot();
								Thread.sleep(2000);
								robot.keyPress(KeyEvent.VK_F11);
								test.log(LogStatus.PASS, "F11 button clicked");
								System.out.println("Before");
								Thread.sleep(8000);
								//WebElement element = driver.findElement(By.name("requestBean.siilBean.advAmt"));                                       
								///Actions builder = new Actions(driver); 

								Thread.sleep(3000);

								WebElement element = driver.findElement(By.name("requestBean.siilBean.advAmt"));  
								if(element.isDisplayed()){


									Actions builder = new Actions(driver); 
									builder.doubleClick()
									/* .sendKeys(element, Keys.ARROW_RIGHT)
											   .sendKeys(element, Keys.ARROW_RIGHT)
											   .doubleClick()*/
									//.sendKeys(element, Keys.DELETE)
									//.sendKeys(element, Keys.ARROW_RIGHT)
									.sendKeys(element, Keys.DELETE)
									//.sendKeys(element, Keys.CLEAR)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.sendKeys(element,Keys.BACK_SPACE)
									.build()
									.perform();
								}


								Thread.sleep(8000);

								WebElement element1 = driver.findElement(By.name("requestBean.siilBean.advAmt"));  
								if(element.isDisplayed()){


									Actions builder = new Actions(driver); 
									builder.doubleClick()
									.sendKeys(element1,Keys.BACK_SPACE)
									.build()
									.perform();
								}
// name="requestBean.siilBean.advAmt"
								//String maxval =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td[3]/input[1]")).getAttribute("value");
								driver.findElement(By.name("requestBean.siilBean.advAmt")).sendKeys(NegAmt);
								test.log(LogStatus.PASS, "Negotiable Amount Entered is::"+NegAmt);
								// name="requestBean.siilBean.advAmt"
								// reCalculate
								driver.findElement(By.name("reCalculate")).click();
								test.log(LogStatus.PASS, "ReCalculate button clicked");
								Thread.sleep(2000);
								// requestBean.siilBean.collateralType
								driver.findElement(By.name("requestBean.siilBean.collateralType")).sendKeys(ESign_CollateralType);
								test.log(LogStatus.PASS, "Collateral type is selected as ::"+ESign_CollateralType);
								Actions builder = new Actions(driver); 
								builder.doubleClick()
								.sendKeys(element, Keys.ARROW_DOWN)
								.sendKeys(element, Keys.ARROW_DOWN)
								.sendKeys(element, Keys.ARROW_DOWN)
								.sendKeys(element, Keys.ARROW_DOWN)

								.build()
								.perform();
								Thread.sleep(4000);

								//     /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[15]/td/input
								//	/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[5]/table/tbody/tr[15]/td
								//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[14]/td/input")).click();
							
								//                            /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[14]/td/input
								
								// /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[13]/td/input
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[13]/td/input")).click();

								//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[14]/td/input")).click();
								//test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
							
								Thread.sleep(5000);
								robot.keyRelease(KeyEvent.VK_F11);
								test.log(LogStatus.PASS, "F11 button clicked");
							
							}					


						}
						Thread.sleep(3000);
						driver.switchTo().window(Parent_Window);

						for( String winHandle1 : driver.getWindowHandles())

						{

							driver.switchTo().window(winHandle1);

						}

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");	
						// name="requestBean.siilBean.advAmt"  negamt textfield
						// name="reCalculate" button
						//name="requestBean.siilBean.collateralType"  dropdown
						// /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[14]/td/input instbutton

					}
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					String Instamt=driver.findElement(By.name("requestBean.siilBean.disbAmt")).getAttribute("value");
					System.out.println(Instamt);
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is entered as "+ESign_DisbType);
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Instamt);
					test.log(LogStatus.PASS, "Disb Amt is entered as "+Instamt);
					driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS,"requestBean.siilBean.emailConsentFlag as "+ESign_CourtesyCallConsent);
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
						//String winHandle =
						driver.getWindowHandle(); //Get current window handle.
					}
					WebElement ele = driver.findElement(By.name("requestBean.siilBean.nbrOfInst"));
					String NumofInst=ele.getAttribute("value");
					/*
			//*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[5]/td[2]/input
			                        System.out.println(NumofInst);
			                        int installments = Integer.parseInt(NumofInst);
			                        for(int i=0;i<installments;i++)
			                        {
			                            Random rand = new Random();
			                            int rand1 = rand.nextInt(100000);
			                            String chknum = Integer.toString(rand1);
			driver.findElement(By.id("checkNbrs"+i)).sendKeys(chknum);

			                        }             */
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
					Thread.sleep(500);

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(5000);
					//

					//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='OKBut' and @type='button' and @value='Yes']")));
							driver.findElement(By.xpath("//input[@id='OKBut' and @type='button' and @value='Yes']")).click();*/
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[  @value='Yes' and @type='button' ]")));
					//driver.findElement(By.xpath("//input[ @value='Yes' and @type='button' ]")).click();
					driver.findElement(By.xpath("//*[@id='OKBut']")).click();
					//*[@id="OKBut"]
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
					if(		driver.findElement(By.xpath("//input[@type='button' and @value='Ok']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
						//driver.findElement(By.name("ok")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
					}
				}


			}

		}
	
		}
