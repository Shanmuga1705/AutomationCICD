package DemoProject.E2EProjectSelenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	LandingPage lp;
	public static Logger log = LogManager.getLogger(base.class.getName());
		@BeforeTest
		public void initialize() throws IOException {
			
			driver = initializeDriver();
			log.info("Driver is initialized");
			
			driver.get(prop.getProperty("url"));
			log.info("Navigated to Home page");
		}

		@Test
		public void validateLandingPageTitle() throws IOException{
						
			lp = new LandingPage(driver);
			Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES12");
			log.info("Validate Title in Landing Page");
		}
		
		@Test
		public void validateLandingPageHeader() throws IOException{
			lp = new LandingPage(driver);
			Assert.assertEquals(lp.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
			log.info("Validate Header in Landing Page");
		}

		
		@AfterTest
		public void tearDown(){
			driver.close();
		}
}
