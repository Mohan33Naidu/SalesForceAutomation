package SalesForceTest;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RandomScenarios extends LoginUtility{

	public static void main(String[] args) {
		launchBrowser();
		loginBrowser();
		WebDriver driver=LoginUtility.driver;
		
		TestCase_33();
		TestCase_34();
		TestCase_35();
		TestCase_36();
		TestCase_37();
		quitBrowser();

	}

	 
    static void TestCase_33() {
		try {
		 waitForWebElementToBeVisible(driver.findElement(By.linkText("Home")));
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Home")).click();
		 Thread.sleep(2000);
		 
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
		 Thread.sleep(2000);
		 
		 
		 String sNameLink=getPropertyValue("FirstName")+" "+getPropertyValue("LastName");
		 System.out.println(sNameLink);
		 driver.findElement(By.xpath("//h1//a[contains(text(),'"+sNameLink+"')]")).click();
		// waitForWebElementToBeVisible(driver.findElement(By.xpath("//div[@class=\"chatterBreadcrumbs\"]//span[@id='tailBreadcrumbNode']")));
		 Thread.sleep(2000);
		 
		 if(driver.findElement(By.xpath("//div[@class=\"chatterBreadcrumbs\"]//span[@id='tailBreadcrumbNode']")).getText().contains(sNameLink))
			 System.out.println("TestCase33: - Passed");
		 else
			 System.out.println("TestCase33: - Failed");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	 static void TestCase_34() {
		 
		 try {
			 
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Home")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Home")).click();
			 Thread.sleep(2000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
			 Thread.sleep(2000);
			 
			 String sNameLink=getPropertyValue("FirstName")+" "+getPropertyValue("LastName");
			 driver.findElement(By.xpath("//h1//a[contains(text(),'"+sNameLink+"')]")).click();
			Thread.sleep(2000);
			 
			 
			driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();//click on edit icon
			 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("About")));
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.linkText("About")).click();//Click on About
			 waitForWebElementToBeVisible(driver.findElement(By.id("lastName")));
			 
			 Thread.sleep(2000);
			
			 WebElement btnLastName=driver.findElement(By.id("lastName"));//get last name WE
			 btnLastName.clear();
			 btnLastName.sendKeys(getPropertyValue("LastNameEdit"));//Gets last name
			 Thread.sleep(2000);
			 //get value from UI textbox
			 JavascriptExecutor js = (JavascriptExecutor)driver;	
			 String sLastNameChk=(String)js.executeScript(" return document.getElementById('lastName').value",btnLastName);
			 String sFirstNameChk=
			    (String)js.executeScript(" return document.getElementById('firstName').value",
			    		driver.findElement(By.id("firstName")));
				
			 driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']")).click();//Save All
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
			 Thread.sleep(2000);
			 driver.switchTo().defaultContent();
			 
			// System.out.println("LN-E "+sLastNameChk);
			 //System.out.println("FN-E "+sFirstNameChk);
			 
			 Thread.sleep(2000);
			 if(driver.findElement(By.xpath("//div[@class=\"chatterBreadcrumbs\"]//span[@id='tailBreadcrumbNode']")).getText().contains(sLastNameChk))
			 {
				 String sNameChk=sFirstNameChk+" "+sLastNameChk;
				 if(driver.findElement(By.id("userNavButton")).getText().equals(sNameChk))
				
					 {
					 System.out.println("TestCase:34 - Passed");
					 }
				 else
					 System.out.println("TestCase:34 - Failed");
			 }
			 else
			 {
				 System.out.println("TestCase:34 - Failed");
			 }
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
	 }

	 static void TestCase_35() {
			
		 try {
			 
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Home")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//li[@id='AllTab_Tab']//a")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.name("customize")));
			 Thread.sleep(2000);
			 driver.findElement(By.name("customize")).click();
			// waitForWebElementToBeVisible(driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")));
			 Thread.sleep(2000);
			 
			 WebElement SelTabsList=driver.findElement(By.xpath("//table[@class=\"layout\"]//select[contains(@name,'duel_select_1')]"));
			 Select selecTab=new Select(SelTabsList);
			 selecTab.selectByVisibleText(getPropertyValue("CustomizeTab"));
			 driver.findElement(By.id("duel_select_0_left")).click();
			 
			 WebElement selAvailTabs=driver.findElement(By.id("duel_select_0"));
			 Select selectAvail=new Select(selAvailTabs);
			 if(selectAvail.getFirstSelectedOption().getText().equals(getPropertyValue("CustomizeTab")))
					 System.out.println("removed from list");
			 
			 Thread.sleep(2000);
			 driver.findElement(By.name("save")).click();
			 Thread.sleep(2000);
			// waitForWebElementToBeVisible(driver.findElement(By.xpath("noSecondHeader pageType")));
			 waitForWebElementToBeVisible(driver.findElement(By.name("customize")));
			 
			 Thread.sleep(2000);
			 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
			 eleMenu.click();
			 
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Logout")).click();
			 Thread.sleep(2000);
			 loginBrowser();
			 
			 //check for tab
			 Boolean chk=false;
			 List<WebElement> allLinks = driver.findElements(By.id("tabBar"));

			 for(WebElement specificlink : allLinks ) {

			 if(specificlink.getText().equals(getPropertyValue("CustomizeTab"))){

			 chk=false;
			 }
			 else
				 chk=true;
			 
			 if(chk=true)
			System.out.println("TestCase:35 - Passed");
			 else
				 System.out.println("TestCase:35 - Failed");
			 }
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}



	 static void TestCase_36() {
		 try {
					 
					 waitForWebElementToBeVisible(driver.findElement(By.linkText("Home")));
					 Thread.sleep(2000);
					 driver.findElement(By.linkText("Home")).click();
					 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
					 Thread.sleep(2000);
					 
					 driver.findElement(By.xpath(" //span[@class='pageDescription']//a")).click();
					 waitForWebElementToBeVisible(driver.findElement(By.xpath(" //a[contains(text(),'8:00 PM')]")));
					 Thread.sleep(2000);
					 driver.findElement(By.xpath(" //a[contains(text(),'8:00 PM')]")).click();
					 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Calendar Details')]")));
					 Thread.sleep(2000);
					 
					 driver.findElement(By.xpath("(//table[@class=\"detailList\"])[2]"
					 		+ "//td[@class=\"dataCol col02\"]//a[@title=\"Combo (New Window)\"]")).click();
					 
					 ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
					 driver.switchTo().window(windows.get(1));
					 driver.findElement(By.linkText("Other")).click();
					 Thread.sleep(2000);
					 driver.switchTo().window(windows.get(0));
					 Thread.sleep(2000);
					 WebElement time=driver.findElement(By.id("EndDateTime_time"));
					 time.clear();
					 time.click();
					 Thread.sleep(2000);
					 time.sendKeys(getPropertyValue("Event_EndTime"));
					 Thread.sleep(2000);
					 driver.findElement(By.name("save")).click();
					 Thread.sleep(2000);
					 
					 
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	 
	 static void TestCase_37() {
		 try {
			 
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Home")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Home")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(" //span[@class='pageDescription']//a")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath(" //a[contains(text(),'4:00 PM')]")));
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(" //a[contains(text(),'4:00 PM')]")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Calendar Details')]")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("(//table[@class=\"detailList\"])[2]"
			 		+ "//td[@class=\"dataCol col02\"]//a[@title=\"Combo (New Window)\"]")).click();
			 
			 ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(windows.get(1));
			 driver.findElement(By.linkText("Other")).click();
			 Thread.sleep(2000);
			 driver.switchTo().window(windows.get(0));
			 Thread.sleep(2000);
			 WebElement time=driver.findElement(By.id("EndDateTime_time"));
			 time.clear();
			 time.click();
			 Thread.sleep(2000);
			 time.sendKeys(getPropertyValue("EndDateTime_TC37"));
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//label[contains(text(),'Frequency')]")));
			 Thread.sleep(2000);
			 driver.findElement(By.id("rectypeftw")).click();//weekly
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//label[contains(text(),'Sunday')]")));
			 driver.findElement(By.id("RecurrenceEndDateOnly")).click();
			 
			 //date
			// Calendar c= Calendar.getInstance();
			 //c.add(Calendar.DATE, 15);
			 //c.DATE
			 
			 driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).sendKeys(getPropertyValue("RecurDate"));
			 
			 driver.findElement(By.name("save")).click();
			 Thread.sleep(2000);
			 //System.out.println("before month view");
			 driver.findElement(By.xpath("//a[(@title=\"Month View\")]//img[1]")).click();//click on month view
			 //System.out.println("after");
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("(//h1)[2]")));
			 Thread.sleep(2000);
			 
			 if(driver.findElement(By.xpath("(//h1)[2]")).getText().contains("Month View"))
				 System.out.println("TestCase37: - Passed");
			 else
				 System.out.println("TestCase37: - Failed");
			 
			 
			 
 }
 catch (Exception e) {
	System.out.println(e.getMessage());
}
			
		}



}
