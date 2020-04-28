package com.facebooklogin.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.facebooklogin.utilities.ReadConfig;


public class Baseclass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	//@Parameters("browser")
	@BeforeClass
	
	public void setup()
	{
		
		logger=Logger.getLogger("facebooklogin");
		PropertyConfigurator.configure("log4j.properties");
		
		//if(br.contentEquals("chrome"))
		//{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//}
		//else 
		//{
			//System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		//driver = new InternetExplorerDriver();
		//driver.manage().window().maximize();
		//}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURl);
		logger.info("url is opened");
	}

	
		@AfterClass
		
		public void tearDown()
		{
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot taken");
		}
}
