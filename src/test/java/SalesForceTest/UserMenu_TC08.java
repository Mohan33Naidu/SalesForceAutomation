package SalesForceTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenu_TC08 extends LoginUtility{

	public static void main(String[] args) {
		try {
			launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 Thread.sleep(1000);
			 driver.findElement(By.linkText("Developer Console")).click();
			
			 Thread.sleep(2000);
			 ArrayList<String> windows=new ArrayList(driver.getWindowHandles());
			 Thread.sleep(3000);
			 driver.switchTo().window(windows.get(1));
			 Thread.sleep(2000);
			 driver.close();
			 driver.switchTo().window(windows.get(0));
			 if(driver.findElement(By.linkText("Home")).isEnabled())
				 System.out.println("TestCase08: Passed");
			 else
				 System.out.println("TestCase08: Failed");
			 quitBrowser();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
