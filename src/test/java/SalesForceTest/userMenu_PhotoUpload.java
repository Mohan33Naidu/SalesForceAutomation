/*package SalesForceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class userMenu_PhotoUpload extends LoginUtility{

	public static void main(String[] args) {
		
		try
		{
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 
			 WebElement elProfile =driver.findElement(By.linkText("My Profile"));
			 
			
			 elProfile.click();
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[text()='Feed']")));
			 
			 Thread.sleep(2000);
			 WebElement eleModtr=driver.findElement(By.id("displayBadge"));
			 
			 Actions act=new Actions(driver);
			 act.moveToElement(eleModtr).click().perform();
			 
			 //get add photo and click
			
			
			 
			 //move to frame and choose pic
			 
			 
			//System.out.println(driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId"))).getPageSource());
			 driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
			 Thread.sleep(2000);
			 
			 WebElement eleFileChoose=driver.findElement(By.xpath("//body//input[@class='fileInput']"));
			 
			 //String sPhotoPath="C:\\Users\\Ashwini Vinod\\eclipse-workspace\\SalesForce.com.qa\\src\\test\\java\\SalesForceTest\\Blossom.png";
			 String sPhotoPath=System.getProperty("user.dir")+getPropertyValue("PhotoPath");
			//get photopath
			 eleFileChoose.sendKeys(sPhotoPath);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//body//input[contains(@name,'j_id0:uploadFileForm:uploadBtn')]")).click();//save photo
			 
			 Thread.sleep(3000);
			 Actions act1=new Actions(driver);
			 act1.dragAndDropBy(driver.findElement(By.xpath("//div[contains(@class,'imgCrop_handle imgCrop_handleNW')]")), 100,20).perform();
			
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//input[contains(@name,'j_id0:j_id7:save')]")).click();
			 
			 System.out.println("TestCase:Photo Upload -- Passed");
			 Thread.sleep(2000);
			 quitBrowser();
			 
			 quitBrowser();
		}
		catch (Exception e) {
			System.out.println("TestCase:Photo Upload -- Failed");
			System.out.println("Error: PhotoUpload --"+e.getMessage());
		}

	}

}
*/