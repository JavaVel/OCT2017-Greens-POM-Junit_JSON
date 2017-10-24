package org.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	static File jsonPath = new File("./JSON/Configuration.json");
	static File driverPath = new File("./Driver");
	public static WebDriver driver;

	public static WebDriver getDriver() {
		JSONObject jsonObjet = readValuesFromJSON();
		String browserName = (String) jsonObjet.get("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath.getAbsoluteFile() + "/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath.getAbsoluteFile() + "/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", driverPath.getAbsoluteFile() + "/IEDriverServers.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get((String) jsonObjet.get("url"));
		return driver;
	}

	public static void clearFiled(WebElement element) {
		if (elementFound(element)) {
			element.clear();
		}

	}

	public static void setText(WebElement element, String name) {
		if (elementFound(element) && name != null) {
			clearFiled(element);
			element.sendKeys(name);
		}
	}

	public static String getAttributeValue1(WebElement element) {
		String name = null;
		if (elementFound(element)) {
			name = element.getAttribute("value");
		}
		return name;
	}

	public static void seletByValue(WebElement element, String name) {
		if (elementFound(element) && name != null) {
			new Select(element).selectByValue(name);
		}
	}

	public static void selectByIndex(WebElement element, int index) {
		if (elementFound(element)) {
			new Select(element).selectByIndex(index);
		}
	}

	public static boolean elementFound(WebElement element) {
		boolean isFound = false;
		try {
			isFound = element.isDisplayed();
		} catch (Throwable e) {

		}
		return isFound;
	}

	public static void btnClick(WebElement element) {
		if (elementFound(element)) {
			element.click();
		}

	}

	public static JSONObject readValuesFromJSON() {
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) jsonParse.parse(new FileReader(jsonPath.getAbsoluteFile()));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
