package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	public WebDriver driver;

	private By email = By.cssSelector("[id='user_email']");
	private By sendMeInstructions = By.cssSelector("[type='submit']");

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getEmail() {
		driver.findElement(email).sendKeys("xxx");
	}

	public void clickSendMeInstructions() {
		driver.findElement(sendMeInstructions).click();
	}
}
