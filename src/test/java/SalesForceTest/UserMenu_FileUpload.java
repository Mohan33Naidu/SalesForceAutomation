package SalesForceTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenu_FileUpload extends LoginUtility {

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
			 
			 //File
			 driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']")).click();
			
			 
			 driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
			 //Thread.sleep(2000);
			 
			 String sFileUpload=getPropertyValue("FilePath"); 
			 String sFilePath=System.getProperty("user.dir")+sFileUpload;
			 driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys(sFilePath);
			 
			 driver.findElement(By.id("publishersharebutton")).click();
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']")));
			 Thread.sleep(2000);
			 
			 WebElement file=driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
			 if(file.getAttribute("title").equals("File"))
			 System.out.println("TestCase:FileUpload passed");
			 else
				 System.out.println("TestCase:FileUpload failed");
			 quitBrowser();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
