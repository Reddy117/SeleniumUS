package com.pomkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pomkart.testbase.BaseClass;

public class HomePageTest extends BaseClass{
	
	
	@Test
	public void verifyHopePageTitle() {
		lp.doLogin(config.getProperty("uName"), config.getProperty("passWord"));
		String acctTitle=driver.getTitle();
		Assert.assertEquals(acctTitle, "My Store");
		//My Store
	}
}
