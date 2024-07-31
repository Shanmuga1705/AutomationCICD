package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement EmailAddress;

	@FindBy(css = "input[type='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Loginbutton;
	
	@FindBy(css = "[href*='password/new']")
	private WebElement ForgotPassword;
	
	public void enterEmailId(String email) {
		EmailAddress.sendKeys(email);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickLogin() {
		Loginbutton.click();
	}
	
	public ForgotPasswordPage forgotPassword(){
		ForgotPassword.click();
		return new ForgotPasswordPage(driver);
	}
}
