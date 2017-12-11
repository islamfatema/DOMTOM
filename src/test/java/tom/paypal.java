package tom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class paypal {
	WebDriver driver1;

	@BeforeClass
	public void setUp() {
		// Defining webdriver
		System.setProperty("webdriver.gecko.driver", "/Users/fatemaislam/Downloads/geckodriver");
		driver1 = new FirefoxDriver();
		driver1.get("https://www.paypal.com/");
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void funWithPayPalSignUpPage() throws InterruptedException {
		String my_title = driver1.getTitle();
		System.out.println("Page title is " + my_title);
		String expected_title = "Send Money, Pay Online or Set Up a Merchant Account - PayPal";
		Assert.assertEquals(my_title, expected_title);

		driver1.findElement(By.xpath("//a[text()='Sign Up for Free']")).click(); // Click On Sign Up For free

		driver1.findElement(By.id("cta-btn")).click();

		Thread.sleep(2000);

		driver1.findElement(By.id("paypalAccountData_email")).sendKeys("test@google.com"); // Sending email address
		driver1.findElement(By.id("paypalAccountData_password")).sendKeys("test123"); // enter password
		driver1.findElement(By.id("paypalAccountData_confirmPassword")).sendKeys("test123"); // Confirm password
		Thread.sleep(2000);
		String expecterror = driver1.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/main/div/div/div[2]/form/div[2]/div[3]/div/div/div[2]/p/span"))
				.getText();
		String actual_error = "It looks like you already signed up.";
		Assert.assertEquals(expecterror, actual_error);
	}

	@AfterClass
	public void tearDown() {
		driver1.quit();
	}

}
