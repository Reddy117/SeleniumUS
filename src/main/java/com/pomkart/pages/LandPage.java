package com.pomkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pomkart.objectrepositroy.OR;
import com.pomkart.testbase.BaseClass;

public class LandPage extends BaseClass{

	@FindBy(xpath=OR.signinlinx)
	WebElement singInlink;
	
	@FindBy(xpath=OR.uNametxtx)
	WebElement userNametxt;
	
	@FindBy(xpath=OR.Passwordx)
	WebElement passWordtxt;
	
	@FindBy(xpath=OR.signbtnx)
	WebElement signinbtn;
	
	public LandPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String uName,String passWord) {
		try {
			singInlink.click();
			userNametxt.sendKeys(uName);
			passWordtxt.sendKeys(passWord);
			signinbtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
