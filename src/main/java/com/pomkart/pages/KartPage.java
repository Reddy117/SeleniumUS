package com.pomkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pomkart.objectrepositroy.OR;
import com.pomkart.testbase.BaseClass;

public class KartPage extends BaseClass{

	@FindBy(xpath=OR.tshirtInKartx)
	WebElement tshirtInKart;
	
	@FindBy(xpath=OR.unitPriceInKartx)
	WebElement unitPriceInKart;
	
	@FindBy(xpath=OR.qtyInKartx)
	WebElement qtyInKart;
	
	@FindBy(xpath=OR.totalKartX)
	WebElement totalKart;
	
	@FindBy(xpath=OR.deleteBtnKartx)
	WebElement deleteBtnKart;
	
	public KartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getKartItemText() {
		try {
			
			String itemText=tshirtInKart.getText();
			return itemText;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void verifyUnitPriceQtyMultipyEqualTotal() {
		try {
			String unitprc=unitPriceInKart.getText();
			String qty=qtyInKart.getAttribute("value");
			String total=totalKart.getText();
			String reUnitprc=unitprc.substring(1);
			String reTotal=total.substring(1);
			double actUnitprc=Double.parseDouble(reUnitprc);
			double actTotal=Double.parseDouble(reTotal);
			int actQty=Integer.parseInt(qty);
			double actTotal1=actUnitprc*actQty;
			System.out.println(qty);
			System.out.println(reUnitprc);
			System.out.println(reTotal);
			//int total=unitprc*qty;
			Assert.assertEquals(actTotal1, actTotal);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
