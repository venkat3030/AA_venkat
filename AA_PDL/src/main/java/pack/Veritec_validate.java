
	package pack;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

	import oracle.jdbc.OracleTypes;

	public class Veritec_validate extends AA_PDL{
		static ArrayList<String> dates=new ArrayList<String>();
	public static	String tranID;
	public	static String actionCode;
	public	static String LoanCode;
	public	static String ReqCode;
		public static void Veritec_validate_NewLoan(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
		
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					/////////////////////////////////////  /html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[2]/td[2]
					Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[2]/td[2]")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
			
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select TRAN_ID,ACTION_CODE,Loan_Code,Req_Code from VERITEC_DATA_LOG where loan_tran_code='"+Trancode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("adv"))
				{
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the__ "+tranID+" <FONT color=green style=Arial> is ::"+actionCode);	
				if(actionCode.equalsIgnoreCase("ON")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
	
		public static void Veritec_validate_Void(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
			
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[3]/td[2]/font")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
			
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select TRAN_ID,ACTION_CODE,Loan_Code,Req_Code from VERITEC_DATA_LOG where loan_tran_code='"+Trancode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("adv"))
				{
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the__ "+tranID+" <FONT color=green style=Arial> is ::"+actionCode);	
				if(actionCode.equalsIgnoreCase("CT")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
	

		public static void Veritec_validate_Rescind(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
			
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[3]/td[2]")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
			
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select TRAN_ID,ACTION_CODE,Loan_Code,Req_Code from VERITEC_DATA_LOG where loan_tran_code='"+Trancode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("adv"))
				{
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the__ "+tranID+" <FONT color=green style=Arial> is ::"+actionCode);	
				if(actionCode.equalsIgnoreCase("CT")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
		

		public static void Veritec_validate_Return(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
			
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					VerTranCode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+VerTranCode);
			
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select  tran_id,ACTION_CODE,loan_code from segment35 where tran_code='"+VerTranCode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					//ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("ACHD"))
				{
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Tran_ID is "+tranID);	
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Action_ID is "+actionCode);	

					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the Transaction__ "+"<FONT color=red style=Arial>__ "+tranID+" <FONT color=green style=Arial> __is ::"+"<FONT color=red style=Arial>__ "+actionCode);	
				if(actionCode.equalsIgnoreCase("UT")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	

	
		

		public static void Veritec_validate_Deposit(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
			
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					VerTranCode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+VerTranCode);
			
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select  tran_id,ACTION_CODE,loan_code from segment35 where tran_code='"+VerTranCode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					//ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("ACHD"))
				{
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Tran_ID is "+tranID);	
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Action_ID is "+actionCode);	

					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the Transaction__ "+"<FONT color=red style=Arial>__ "+tranID+" <FONT color=green style=Arial> __is ::"+"<FONT color=red style=Arial>__ "+actionCode);	
				if(actionCode.equalsIgnoreCase("UT")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
		

		public static void Veritec_validate_WriteOff(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
			
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
					Thread.sleep(5000);
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

						//driver.findElement(By.name("button")).click();
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
					}
					//  driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					/*	if(ProductID.equals("LOC"))
			{*/
					//*[@id="go_Button"]
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
					//driver.findElement(By.name("button")).click(); 
					//}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
			/*		VerTranCode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+VerTranCode);*/
					Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[6]/td[2]")).getText();
					
					test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
			
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

				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
						prop.getProperty("db_username"));

			} catch (SQLException e1) {

				System.out.println("Connection Failed! Check output console" + e1);
				e1.printStackTrace();
			}

			// Execute a query
			stmt = conn.createStatement();
			System.out.println("after conn");
			try {
			
			Thread.sleep(3000);
				resultSet = stmt.executeQuery("select tran_id,ACTION_CODE,loan_code from segment35 where loan_tran_code='"+Trancode+"'");
				//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
				Thread.sleep(3000);
				 while (resultSet .next())
				{
					System.out.println(
							resultSet .getString(1) 
							
							
										 );
					tranID=resultSet .getString(1);
					actionCode=resultSet .getString(2);
					LoanCode =resultSet.getString(3);
					//ReqCode =resultSet.getString(4);
				}
					
				if(tranID.equalsIgnoreCase("WO"))
				{
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Tran_ID is "+tranID);	
					test.log(LogStatus.PASS, "<FONT color=red style=Arial>Action_ID is "+actionCode);	

					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the Transaction__ "+"<FONT color=red style=Arial>__ "+tranID+" <FONT color=green style=Arial> __is ::"+"<FONT color=red style=Arial>__ "+actionCode);	
				if(actionCode.equalsIgnoreCase("UT")){
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

		
				}
				}
			
					
				
				
				
				System.out.println("after query");
			//	test.log(LogStatus.PASS, "Proceduer run successfully");

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
			}
		}
			public static void Veritec_validate_Discharage(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
				
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
						Thread.sleep(5000);
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

							//driver.findElement(By.name("button")).click();
							///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
							driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
							//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
						}
						//  driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Click on GO Button");
						for( String winHandle1 : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle1);
						}			
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.name("transactionList")).sendKeys("History");
						/*	if(ProductID.equals("LOC"))
				{*/
						//*[@id="go_Button"]
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
						//driver.findElement(By.name("button")).click(); 
						//}

						for( String winHandle1 : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle1);
						}			
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
				/*		VerTranCode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
						test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+VerTranCode);*/
						//Trancode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
						Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[4]/td[2]")).getText();	
						test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
				
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

					conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
							prop.getProperty("db_username"));

				} catch (SQLException e1) {

					System.out.println("Connection Failed! Check output console" + e1);
					e1.printStackTrace();
				}

				// Execute a query
				stmt = conn.createStatement();
				System.out.println("after conn");
				try {
				
				Thread.sleep(3000);
					resultSet = stmt.executeQuery("select tran_id,ACTION_CODE,loan_code from veritec_data_log where loan_tran_code='"+Trancode+"'");
					//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
					Thread.sleep(3000);
					 while (resultSet .next())
					{
						System.out.println(
								resultSet .getString(1) 
								
								
											 );
						tranID=resultSet .getString(1);
						actionCode=resultSet .getString(2);
						LoanCode =resultSet.getString(3);
						//ReqCode =resultSet.getString(4);
					}
						
					if(tranID.equalsIgnoreCase("WOW"))
					{
						test.log(LogStatus.PASS, "<FONT color=red style=Arial>Tran_ID is "+tranID);	
						test.log(LogStatus.PASS, "<FONT color=red style=Arial>Action_ID is "+actionCode);	

						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the Transaction__ "+"<FONT color=red style=Arial>__ "+tranID+" <FONT color=green style=Arial> __is ::"+"<FONT color=red style=Arial>__ "+actionCode);	
					if(actionCode.equalsIgnoreCase("CT")){
						test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

			
					}
					}
				
						
					
					
					
					System.out.println("after query");
				//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
public static void Veritec_validate_WriteOffRecovery(String SSN,String FileName) throws ClassNotFoundException, SQLException, InterruptedException {
				
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
						Thread.sleep(5000);
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

							//driver.findElement(By.name("button")).click();
							///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
							driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
							//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
						}
						//  driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Click on GO Button");
						for( String winHandle1 : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle1);
						}			
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.name("transactionList")).sendKeys("History");
						/*	if(ProductID.equals("LOC"))
				{*/
						//*[@id="go_Button"]
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
						//driver.findElement(By.name("button")).click(); 
						//}

						for( String winHandle1 : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle1);
						}			
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
				/*		VerTranCode= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span/span")).getText();
						test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+VerTranCode);*/
						Trancode= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[7]/td[2]")).getText();
						
						test.log(LogStatus.PASS, "Loan Transaction Code is  ::"+Trancode);
				
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

					conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
							prop.getProperty("db_username"));

				} catch (SQLException e1) {

					System.out.println("Connection Failed! Check output console" + e1);
					e1.printStackTrace();
				}

				// Execute a query
				stmt = conn.createStatement();
				System.out.println("after conn");
				try {
				
				Thread.sleep(3000);
					resultSet = stmt.executeQuery("select tran_id,ACTION_CODE,loan_code from veritec_data_log where loan_tran_code='"+Trancode+"'");
					//                             select action_code,tran_id,loan_code from veritec_data_log where loan_tran_code='15033930';
					Thread.sleep(3000);
					 while (resultSet .next())
					{
						System.out.println(
								resultSet .getString(1) 
								
								
											 );
						tranID=resultSet .getString(1);
						actionCode=resultSet .getString(2);
						LoanCode =resultSet.getString(3);
						//ReqCode =resultSet.getString(4);
					}
						
					if(tranID.equalsIgnoreCase("WOR"))
					{
						test.log(LogStatus.PASS, "<FONT color=red style=Arial>Tran_ID is "+tranID);	
						test.log(LogStatus.PASS, "<FONT color=red style=Arial>Action_ID is "+actionCode);	

						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Action Code for the Transaction__ "+"<FONT color=red style=Arial>__ "+tranID+" <FONT color=green style=Arial> __is ::"+"<FONT color=red style=Arial>__ "+actionCode);	
					if(actionCode.equalsIgnoreCase("CT")){
						test.log(LogStatus.INFO,"<FONT color=green style=Arial>Veritec is  Enable with ::::"+LoanCode);

			
					}
					}
				
						
					
					
					
					System.out.println("after query");
				//	test.log(LogStatus.PASS, "Proceduer run successfully");

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

	}

		}
	
	
	
	}
			
