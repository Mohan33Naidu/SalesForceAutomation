package SalesForceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenu_TC09 extends LoginUtility{

	public static void main(String[] args) {
		try {
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Logout")).click();
//			 waitForWebElementToBeVisible(driver.findElement(By.id("username")));
			 Thread.sleep(2000);
			 if(driver.findElement(By.xpath("//label[@class='label usernamelabel']")).getText().equals("Username"))
				 System.out.println("TestCase:09 - Passed");
			 else
				 System.out.println("TestCase:09 - Failed");
			 Thread.sleep(2000);
			 quitBrowser();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
