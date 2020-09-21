package com.pomkart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.pomkart.testbase.BaseClass;

public class Keyboard_MouseUtils extends BaseClass{

	public static Actions a;
	
	public static void mouseHover(String xpath) {
		try {
			a=new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(xpath))).perform();;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
