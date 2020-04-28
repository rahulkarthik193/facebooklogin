package com.facebooklogin.testCases;



import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.facebooklogin.pageObjects.AddCustomerPage;
import com.facebooklogin.pageObjects.loginpage;

import junit.framework.Assert;


public class TC_AddCustomerTest_003 extends Baseclass{

	
	@Test
	public void addnewcustomer() throws InterruptedException, IOException
	{
		
		
		loginpage lp= new loginpage(driver);
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		Thread.sleep(5000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickaddnewcustomer();
		addcust.custname("rahul");
		addcust.custgender("male");
		addcust.custdob("06", "12", "1988");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("mala");
		addcust.custstate("Kerala");
		addcust.custpin("680733");
		addcust.custtelephone("9747633415");
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("asd1234");
		addcust.clicksubmit();
		Thread.sleep(5000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"addnewcustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	}

