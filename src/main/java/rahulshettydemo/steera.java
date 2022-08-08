package rahulshettydemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class steera {
	
	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//sl.sendChar(null, null)
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://steera-ui-sit-cfwupz.s3-website-ap-southeast-2.amazonaws.com/");
		Thread.sleep(3000);
		
		WebElement login = driver.findElement(By.xpath("//input[@id='login-email']"));
		
		steeraLogin sl = new steeraLogin();
		sl.sendChar(login, "liam@yopmail.com");
		WebElement password =driver.findElement(By.xpath("//input[@id='login-password']"));
		sl.sendChar(password, "Liam@123");
		driver.findElement(By.xpath("//button[@class='Button_btn__4gkRc Button_primary__8FFFC b-loginbtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Patient Registration']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='Button_btn__4gkRc Button_primary__8FFFC control_submit']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebElement date= driver.findElement(By.xpath("//input[@id='date_of_birth']"));
		date.clear();
		int d=22;
		int m=12;
		int y=2022;
		for (int i=1;i<=d;i++)
		{
			
			date.sendKeys(Keys.ARROW_UP);
		}
		date.sendKeys(Keys.TAB);
		for (int i=1;i<=m;i++)
		{
			date.sendKeys(Keys.ARROW_UP);
		}
		date.sendKeys(Keys.TAB);
		for (int i=2022;i<=y;i++)
		{
			date.sendKeys(Keys.ARROW_UP);
		}
		
//		
//		 Actions actions = new Actions(driver); 
//		    int getX = date.getLocation().getX(); 
//		     System.out.println("X coordinate: " +getX); 
//		     int getY = date.getLocation().getY(); 
//		     System.out.println("Y coordinate: " +getY); 
//		     
//		     actions.moveByOffset(getX,getY+5 ).click(); 
//		     actions.build().perform(); 
		  
//		sl.sendChar(date, "22");
//		
//		date.sendKeys(Keys.TAB);
//		sl.sendChar(date, "12");
//		date.sendKeys(Keys.ARROW_UP);
//		
//		date.sendKeys(Keys.ARROW_UP);
//		date.sendKeys(Keys.TAB);
//		date.sendKeys(Keys.ARROW_UP);
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}
}
