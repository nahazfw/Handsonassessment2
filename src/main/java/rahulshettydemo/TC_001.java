package rahulshettydemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class TC_001 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("admin00");
		driver.findElement(By.name("inputPassword")).sendKeys("TEST123");
		driver.findElement(By.xpath(".//button[@type='submit']")).click();
		String errmsg=driver.findElement(By.cssSelector(".error")).getText();
		
		System.out.println("Error message displayed is :"+errmsg);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath(".//input[@placeholder='Name']")).sendKeys("nahaz");
		driver.findElement(By.xpath(".//input[@placeholder='Email']")).sendKeys("test123");
		driver.findElement(By.xpath(".//input[@placeholder='Phone Number']")).sendKeys("1234567891");
		
		//new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.Xpath(""))).click();
		
		WebElement resetButton=driver.findElement(By.cssSelector(".reset-pwd-btn"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", resetButton);
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("admin00");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", signIn);
		
		Thread.sleep(2000);
		String actualMessage = driver.findElement(By.xpath(".//div[@class='login-container']/child::p")).getText();
		String expectedMessage = "You are successfully logged in.";
		Assert.assertEquals(expectedMessage,actualMessage);
		driver.quit();

	}

}
