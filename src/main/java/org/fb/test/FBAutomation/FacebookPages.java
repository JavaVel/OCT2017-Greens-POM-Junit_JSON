package org.fb.test.FBAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.Base;

public class FacebookPages extends Base {
	@FindBy(id = "email")
	private WebElement txtUserName;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement btnLogin;

	public FacebookPages() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(WebElement txtUserName) {
		this.txtUserName = txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

}
