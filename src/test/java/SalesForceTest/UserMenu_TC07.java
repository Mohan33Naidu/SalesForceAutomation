package SalesForceTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class UserMenu_TC07 extends LoginUtility {

	public static void main(String[] args) {
		try {
			 //launchBrowser();
			 //loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 
			 driver.findElement(By.linkText("My Settings")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")));
			 Thread.sleep(2000);
			 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
