package rahulshettydemo;

import org.openqa.selenium.WebElement;

public class steeraLogin {
	
	public static void sendChar(WebElement element,String value) {
		for (int i = 0; i < value.length(); i++) {
			element.sendKeys(value.charAt(i)+"");
		}
		
		
	}

}
