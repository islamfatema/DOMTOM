package tom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class yahoo {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","/Users/fatemaislam/Downloads/geckodriver");
		 driver = new FirefoxDriver();
		driver.get("https://www.yahoo.com/");

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void setUpstart() {

		String myTitle = driver.getTitle();
		System.out.println("Title is " + myTitle);
		String expectedTitle = "Yahoo";
		Assert.assertEquals(myTitle, expectedTitle);

		// driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='yui_3_18_0_4_1512678617793_1175']"));

		for (WebElement ele : list) {
			List<WebElement> element = driver.findElements(By.tagName("a"));
			System.out.println(ele.getAttribute("href"));
		}
		driver.findElement(By.xpath("//text()[.='More...']/ancestor::a[1]")).sendKeys("Nutrition");
		driver.findElement(By.xpath(".//*[@id='uh-search-button']")).click();
		List<WebElement> image = (List<WebElement>) driver.findElements(By.tagName("img"));
		System.out.println("Number of images on page " + image.size());
		driver.findElement(By.xpath(".//*[@id='yucs-login_signIn']")).click();
		driver.findElement(By.id("login-signin")).click();
		String actualError = driver.findElement(By.xpath("//p[text()=concat('Sorry, we don',\"'\",'t recognize this email.')]")).getText();
		System.out.println(actualError);
		String expectedError = "Sorry, we don't recognize this email.";
		Assert.assertEquals(actualError,expectedError);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
