package SalesForceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenu_Post extends LoginUtility {

	public static void main(String[] args) {
		try {
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 
			 WebElement elProfile =driver.findElement(By.linkText("My Profile"));
			 
			
			 elProfile.click();
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[text()='Feed']")));
			 // Post 
			 WebElement elPostBtn=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
			 elPostBtn.click();//click on Post
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")));
			 Thread.sleep(2000);
			 
			 //System.out.println(driver.switchTo().frame(0).getPageSource());//switch to frame txteditor and check the pagesrc
			 driver.switchTo().frame(0);
			 Thread.sleep(2000);
			 WebElement framEle=driver.findElement(By.tagName("body"));
			 
			 
			 String sPost=getPropertyValue("PostFeedText");
			 framEle.sendKeys(sPost);
			 
			 //
			 //send data to frame editor
			 Thread.sleep(2000);
			 driver.switchTo().defaultContent();
			 driver.findElement(By.id("publishersharebutton")).click();
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")));
			 
			 if(driver.findElement(By.xpath("//a[text()='Feed']")).getText().equals("Feed")) {
				 System.out.println("TestCase:PostShare - Passed");
			 }
			 else
			 { 
				 System.out.println("TestCase:PostShare - Failed");
			 }
			quitBrowser(); 		
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage().toString());
		}

	}

}
