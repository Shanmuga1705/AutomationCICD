package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By Login =By.cssSelector("a[href *= 'sign_in']");
	private By Title =By.xpath("//h2[contains(text(),'Featured')]");
	private By NavigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By Header = By.cssSelector("div[class*=video-banner] h3");
	
	public LoginPage clickLoginlink(){
		driver.findElement(Login).click();
		LoginPage l = new LoginPage(driver);
		return l;
	}
	
	public WebElement getTitle(){
		return driver.findElement(Title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(NavigationBar);
	}

	public WebElement getHeader() 
	{
		return driver.findElement(Header);
	}
}
