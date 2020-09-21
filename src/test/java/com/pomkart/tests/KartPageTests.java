package com.pomkart.tests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pomkart.pages.HomePage;
import com.pomkart.pages.KartPage;
import com.pomkart.pages.LandPage;
import com.pomkart.testbase.BaseClass;
import com.pomkart.utils.DataUtil;

public class KartPageTests extends BaseClass{

	@Test(dataProvider="getTC1Data")
	public void tc1_Verify(Hashtable<String,String> tab) throws InterruptedException {
		lp.doLogin(config.getProperty("uName"), config.getProperty("passWord"));
		hp.addKartProductToKart(tab.get("Qty"), tab.get("Size"));
		hp.goToKartPage();
		String actProductinkart=kp.getKartItemText();
		Assert.assertEquals(actProductinkart, "Faded Short Sleeve T-shirts");
	}
	
	@Test(dataProvider="getTC2Data")
	public void verifyUnitPriceMultiplyEqualsTotal(Hashtable<String,String> tab) {
		lp.doLogin(config.getProperty("uName"), config.getProperty("passWord"));
		hp.addKartProductToKart(tab.get("Qty"), tab.get("Size"));
		hp.goToKartPage();
		kp.verifyUnitPriceQtyMultipyEqualTotal();
	}
	
	@DataProvider
	public Object[][] getTC1Data(){
		return DataUtil.getData("TC1_VerifyProductInKart", "Sheet1", x);
	}
	
	@DataProvider
	public Object[][] getTC2Data(){
		return DataUtil.getData("TC2_verifyUnitPriceMultiplyEqualsTotal", "Sheet1", x);
	}
}
