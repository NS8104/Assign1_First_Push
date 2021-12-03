package assignmentno1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class assignment_1 {
	WebDriver driver;

	@Before

	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");//initializing the browser
		driver = new ChromeDriver();// creating the object
		driver.get("https://techfios.com/billing/?ng=admin/");// driver to get URL
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void Testing() throws InterruptedException {
	
		//storing element using By Class
    	By USERNAME_FIELD = By.xpath("//input[@id='username']");
    	By PASSWORD_FIELD=By.xpath("//input[@id='password']");
    	By SIGNIN_BUTTON_FIELD=By.xpath("//button[@class='btn btn-success block full-width']");
    	By DASHBOARD_CHECKING_FIELD=By.xpath("//div[@id='page-wrapper']/div[2]/div/h2");
    	By BANK_CASH_FIELD = By.xpath("//i[@class='fa fa-university']");
	    By NEW_ACCOUNT_FIELD = By.xpath("//a[text()='New Account']");
	    By ACCOUNT_PAGE_FIELD=By.xpath("//div[@id='wrapper']/div/div[2]/div/h2");
		By ACCOUNT_TITLE_FIELD = By.xpath("//input[@id='account']");
		By DESCRIPTION_FIELD = By.xpath("//input[@id='description']");
		By INITIAL_BALANCE_FIELD = By.xpath("//input[@id='balance']");
		By ACCOUNT_NUMBER_FIELD = By.xpath("//input[@id='account_number']");
		By CONTACT_PERSON_FIELD = By.xpath("//input[@id='contact_person']");
		By PHONE_NUMBER_FIELD = By.xpath("//input[@id='contact_phone']");
		By SUBMIT_FIELD = By.xpath("//button[@class='btn btn-primary']");
		By TRANSACTIONS_FIELD= By.xpath("//i[@class='fa fa-database']");
		By VIEW_TRANSACTION_FIELD= By.xpath("//a[text()='View Transactions']");
		
		 	
    	driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
    	driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
    	driver.findElement(SIGNIN_BUTTON_FIELD).click();
    	
    	// Validation
    	Assert.assertTrue("Wrong Page!!!",driver.findElement(DASHBOARD_CHECKING_FIELD).isDisplayed());
    	
    	driver.findElement( BANK_CASH_FIELD).click();
    	driver.findElement(NEW_ACCOUNT_FIELD).click();
    	
    	Assert.assertTrue("Wrong Page!!!",driver.findElement(ACCOUNT_PAGE_FIELD).isDisplayed());
    	
    	driver.findElement(ACCOUNT_TITLE_FIELD).sendKeys("Hanmi Coop5");
    	driver.findElement(DESCRIPTION_FIELD).sendKeys("Test Account");
    	driver.findElement(INITIAL_BALANCE_FIELD).sendKeys("100");
    	driver.findElement(ACCOUNT_NUMBER_FIELD).sendKeys("1234567");
    	driver.findElement(CONTACT_PERSON_FIELD).sendKeys("Nargis Sayani");
    	driver.findElement(PHONE_NUMBER_FIELD).sendKeys("972-242-0250");
    	driver.findElement(SUBMIT_FIELD).click();
    	Thread.sleep(3000);
    	
      // Checking the transaction amount is posted in the account
    	driver.findElement(TRANSACTIONS_FIELD).click();
    	driver.findElement(VIEW_TRANSACTION_FIELD).click();
    	
    	
    	
  	
	}
	@After
	public void Teardown() throws InterruptedException {
			System.out.println("Tear down");
			Thread.sleep(3000);
			driver.close();
	}
}

