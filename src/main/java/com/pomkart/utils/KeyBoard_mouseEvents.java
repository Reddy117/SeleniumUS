package com.pomkart.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pomkart.testbase.BaseClass;

public class KeyBoard_mouseEvents extends BaseClass{
	public static Actions a;
	
	public static void mouseHover(WebElement element) {
		try {
			a=new Actions(driver);
			a.moveToElement(element).perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
