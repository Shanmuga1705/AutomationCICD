package DemoProject.E2EProjectSelenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;//we are adding here in class after adding in base class also, for it to support parallel execution in Framework
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(dataProvider = "getData")
	public void homePageNavigation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);		

		LoginPage l = lp.clickLoginlink();
		l.enterEmailId(Username);
		l.enterPassword(Password);
		log.info(text);
		l.clickLogin();
		ForgotPasswordPage fp = l.forgotPassword();
		fp.getEmail();
		fp.clickSendMeInstructions();
	}

	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "nonrestricteduser@dff.com";
		data[0][1] = "123456";
		data[0][2] = "UnRestricted User";

		data[1][0] = "restricteduser@fhjh.com";
		data[1][1] = "4352642";
		data[1][2] = "Restricted User";

		return data;
	}
}
