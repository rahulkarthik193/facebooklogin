package com.facebooklogin.testCases;

import java.io.IOException;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.facebooklogin.pageObjects.loginpage;
//@Listeners(com.facebooklogin.utilities.Reporting.class)

public class TC_logintest_001 extends Baseclass {

	
	@Test
	public void loginTest() throws IOException
	{
		
		
		loginpage lp= new loginpage(driver);
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			System.out.println("login successfull");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("login failed");
			System.out.println("loggin not successfull");
		}
	}
	
	
}
