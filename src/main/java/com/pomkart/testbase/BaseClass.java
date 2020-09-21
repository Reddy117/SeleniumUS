package com.pomkart.testbase;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pomkart.objectrepositroy.OR;
import com.pomkart.pages.HomePage;
import com.pomkart.pages.KartPage;
import com.pomkart.pages.LandPage;
import com.pomkart.utils.Xl_Utils;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
public class BaseClass extends OR{
	
	public static WebDriver driver;
	public FileInputStream f;
	public Properties config;
	public Xl_Utils x=new Xl_Utils();
	
	public LandPage lp;
	public HomePage hp;
	public KartPage kp;
	
	
	@BeforeMethod
	public void openApp() {
		initialize("chrome");
		lp=new LandPage();
		hp=new HomePage();
		kp=new KartPage();
	}
	
	
	public static void initialize(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	public BaseClass() {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.property");
			config=new Properties();
			config.load(f);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void equalAssert(String actVal,String expVal) {
		Assert.assertEquals(actVal, expVal);
	}
	
	
	
	
	
	

}
