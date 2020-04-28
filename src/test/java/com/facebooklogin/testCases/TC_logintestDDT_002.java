package com.facebooklogin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.facebooklogin.pageObjects.loginpage;
import com.facebooklogin.utilities.XLUtils;
//@Listeners(com.facebooklogin.utilities.Reporting.class)
public class TC_logintestDDT_002 extends Baseclass
{
	@Test(dataProvider="LoginData")
public void loginDDT(String user, String pwd) throws InterruptedException, IOException 
	{
		
	loginpage lp=new loginpage(driver);	
	lp.setUserName(user);
	logger.info("username provided");
	lp.setPassword(pwd);
	logger.info("password provided");
	lp.clickSubmit();
	Thread.sleep(5000);
	
	if(isAlertPresent()==true)
		
	{
		
		driver.switchTo().alert().accept();;//close alert
		captureScreen(driver,"loginDDT");
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
        logger.warn("Login Failed");
       
	}
	else {
		Assert.assertTrue(true);
		logger.info("Login Passed");
		lp.clickLogout();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
	}
}
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
		}
	
	
	
	
@DataProvider(name="LoginData")
String[][] getData() throws IOException

{
//String path=System.getProperty("user.dir")+"/src/test/java/com/facebooklogin/testData/datadriven.xls";
	
	String path="G:/eclipse/facebooklogin/src/test/java/com/facebooklogin/testData/datadriven.xlsx";

int rownum=XLUtils.getRowCount(path,"Sheet1");
int colcount=XLUtils.getCellCount(path,"Sheet1",1);

String logindata[][]=new String[rownum][colcount];

for(int i=1;i<=rownum;i++)
{
	for(int j=0;j<colcount;j++)
	{
	logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);	
		
	}
}
return logindata;
	}


}
