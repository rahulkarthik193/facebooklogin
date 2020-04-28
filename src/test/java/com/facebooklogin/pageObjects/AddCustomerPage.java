package com.facebooklogin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy (xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy (name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy (name="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy (name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy (name="addr")
	@CacheLookup
	WebElement txtaddress;
	@FindBy (name="city")
	@CacheLookup
	WebElement txtCity;
	@FindBy (name="state")
	@CacheLookup
	WebElement txtState;
	@FindBy (name="pinno")
	@CacheLookup
	WebElement txtPin;
	@FindBy (name="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	@FindBy (name="emailid")
	@CacheLookup
	WebElement txtemailid;
	@FindBy (name="password")
	@CacheLookup
	WebElement txtpassword;
	@FindBy (name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickaddnewcustomer() {
		lnkAddNewCustomer.click();
	}
	public void custname(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	public void custgender(String cgender) {
		rdGender.click();
	}
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}
	public void custpin(String cpin) {
		txtPin.sendKeys(cpin);
	}
	public void custtelephone(String ctelephone) {
		txttelephoneno.sendKeys(ctelephone);
	}
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	public void clicksubmit() {
		btnSubmit.click();
	}
	}
	
	

