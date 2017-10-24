package org.fb.test.FBAutomation;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;

import junit.framework.Assert;

public class FacebookPagesTest extends Base {
	static WebDriver driver;

	@BeforeClass
	public static void launchBrowser() {
		driver = getDriver();
	}

	@AfterClass
	public static void closeAppln() {
		driver.quit();
	}

	@Test
	public void loginFB() {
		FacebookPages pages = new FacebookPages();
		setText(pages.getTxtUserName(), "Ramesh@gmail.com");
		assertEquals("Ramesh@gmail.com", getAttributeValue1(pages.getTxtUserName()));
		setText(pages.getTxtPassword(), "Ramu876");
		assertEquals("Ramu876", getAttributeValue1(pages.getTxtPassword()));
		btnClick(pages.getBtnLogin());

	}

}
