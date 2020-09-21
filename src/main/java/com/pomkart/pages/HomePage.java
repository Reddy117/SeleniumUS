package com.pomkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pomkart.objectrepositroy.OR;
import com.pomkart.testbase.BaseClass;
import com.pomkart.utils.KeyBoard_mouseEvents;

public class HomePage extends BaseClass{

	@FindBy(xpath=OR.womenTabx)
	WebElement womenTab;
	
	@FindBy(xpath=OR.tShirtsLinkx)
	WebElement tshirtsLink;
	
	@FindBy(xpath=OR.tShirtsimgx)
	WebElement tShirtsimg;
	
	@FindBy(xpath=OR.qtyX)
	WebElement qty;
	
	@FindBy(xpath=OR.sizeX)
	WebElement size;
	
	@FindBy(xpath=OR.addToKartbtnx)
	WebElement addTokartbtn;
	
	@FindBy(xpath=OR.closeX)
	WebElement close;
	
	@FindBy(xpath=OR.kartX)
	WebElement kartlink;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToKartPage() {
		try {
			kartlink.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addKartProductToKart(String qtyval,String sizeval) {
		try {
			KeyBoard_mouseEvents.mouseHover(womenTab);
			tshirtsLink.click();
			tShirtsimg.click();
			driver.switchTo().frame(0);
			qty.clear();
			qty.sendKeys(qtyval);
			new Select(size).selectByVisibleText(sizeval);
			addTokartbtn.click();
			Thread.sleep(5000);
			//close.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
