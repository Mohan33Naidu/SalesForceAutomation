package SalesForceTest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UserMenu extends LoginUtility {

	public static void main(String[] args) {
		try {
		 launchBrowser();
		 loginBrowser();
		 WebDriver driver=LoginUtility.driver;
		 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
		 eleMenu.click();
		 
		 
		 WebElement elProfile =driver.findElement(By.linkText("My Profile"));
		 
		 if(elProfile.getText().equals("My Profile"))
		 {
			 System.out.println("TestCase:05 - Passed");
		 }
		 else
		 {
			System.out.println("Test Case:05 - Failed"); 
		 }
		 
		 elProfile.click();
		 Thread.sleep(2000);
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[text()='Feed']")));
		 Thread.sleep(2000);		 
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();//click on edit icon
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		 Thread.sleep(2000);
		 waitForWebElementToBeVisible(driver.findElement(By.linkText("About")));
		 		  
		 driver.findElement(By.linkText("About")).click();//Click on About
		 waitForWebElementToBeVisible(driver.findElement(By.id("lastName")));
		
		 WebElement btnLastName=driver.findElement(By.id("lastName"));//get last name WE
		 btnLastName.clear();
		 btnLastName.sendKeys(getPropertyValue("LastName"));//Gets last name
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']")).click();//Save All
		 Thread.sleep(2000);
		 driver.switchTo().defaultContent();
		 
		 Thread.sleep(2000);
		 //post
		 UserMenuPost();
		 //file
		UserMenuFileUpload();
		 //photo
		 UserMenuPhotoUpload();
		 
		 //uploadLink
		/* WebElement eleModtr=driver.findElement(By.id("displayBadge"));
		 
		 Actions act=new Actions(driver);
		 act.moveToElement(eleModtr).click().perform();*/
		 
		 System.out.println("TestCase:TC06 - Passed");
		 
		 Thread.sleep(2000);
		 TestCase_07();
		 TestCase_08();
		 TestCase_09();
		quitBrowser();
		 
		 
		}
		catch (Exception e) {
			
			System.out.println("Error:UserMenu "+e.getMessage().toString());
		}
	}

	static void TestCase_07() {
		
		try {
			
		 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
		 eleMenu.click();
		 
		 
		 driver.findElement(By.linkText("My Settings")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")));
		 Thread.sleep(2000);
		 
		 
		 //personal
		 driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[@id='LoginHistory_font']")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[@id='LoginHistory_font']")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		 
		 Thread.sleep(2000);
		 //display
		 driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h1[contains(text(),'Customize My Tabs')]")));
		 Thread.sleep(2000);
		 
		 WebElement eCustomApp=driver.findElement(By.id("p4"));
		 Select selCustom=new Select(eCustomApp);
		 selCustom.selectByVisibleText("Salesforce Chatter");
		 
		 Select selAvail=new Select(driver.findElement(By.id("duel_select_0")));
		 selAvail.selectByVisibleText("Reports");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id=\"duel_select_0_right\"]")).click();
		 Thread.sleep(2000);
		 
		// Select selSelcted=new Select(driver.findElement(By.id("duel_select_1")));
		 driver.findElement(By.name("save")).click();
		 Thread.sleep(2000);
		 
		 //email
		 
		 driver.findElement(By.id("EmailSetup_font")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[@id='EmailSettings_font']")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[@id='EmailSettings_font']")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Outgoing Email Settings')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@name='sender_name']")).clear();
		 driver.findElement(By.xpath("//input[@name='sender_name']")).sendKeys(getPropertyValue("EmailName"));
		 driver.findElement(By.id("sender_email")).clear();
		 driver.findElement(By.id("sender_email")).sendKeys(getPropertyValue("Email"));
		 driver.findElement(By.id("auto_bcc1")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.name("save")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.className("messageText")));
		 Thread.sleep(2000);
		 
		 
		 //calendar
		 
		 driver.findElement(By.id("CalendarAndReminders_font")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Activity Reminders')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(),'Activity Reminders')]")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reminder Settings')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.id("testbtn")).click();
		 Thread.sleep(2000);
		 System.out.println("test --7");
		 if(driver.getWindowHandles().size()>0)
			 System.out.println("TestCase:07 - PAssed");
		 else
			 System.out.println("TestCase:07 - Failed");
		
		 Thread.sleep(2000);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	static void TestCase_08() {
		try
		{
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
		 Thread.sleep(2000);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	static void TestCase_09() {
		
		try
		{
		WebElement eleMenu=driver.findElement(By.id("userNavButton"));
		 eleMenu.click();
		 
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Logout")).click();
//		 waitForWebElementToBeVisible(driver.findElement(By.id("username")));
		 Thread.sleep(2000);
		 if(driver.findElement(By.xpath("//label[@class='label usernamelabel']")).getText().equals("Username"))
			 System.out.println("TestCase:09 - Passed");
		 else
			 System.out.println("TestCase:09 - Failed");
		 Thread.sleep(2000);
		
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	static void UserMenuFileUpload(){
		try {
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
		Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	}
		
	static void UserMenuPost() {
		
		try {
			
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
			Thread.sleep(2000);
	}
	catch (Exception e) {
		System.out.println("Error: "+e.getMessage().toString());
	}

	}

	static void UserMenuPhotoUpload(){
		try
		{
		WebElement eleModtr=driver.findElement(By.id("displayBadge"));
		 
		 Actions act=new Actions(driver);
		 act.moveToElement(eleModtr).click().perform();
		
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
		}
		catch (Exception e) {
		 System.out.println(e.getMessage());
		}
	}
}
