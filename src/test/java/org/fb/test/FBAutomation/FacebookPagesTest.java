package org.fb.test.FBAutomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;

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
		setText(pages.getTxtPassword(), "Ramu876");
		btnClick(pages.getBtnLogin());

	}

}
