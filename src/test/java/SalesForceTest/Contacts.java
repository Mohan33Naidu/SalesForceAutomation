package SalesForceTest;

import java.time.LocalDateTime;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Contacts extends LoginUtility {

	public static void main(String[] args) {
		try
		{
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			
			    TestCase_28();
			 	TestCase_25();
			 	TestCase_26();
			 	TestCase_27();
     			
			    TestCase_29();
			    TestCase_30();
			    TestCase_31();
			    TestCase_32();
				quitBrowser();
			
			 
		}
		catch (Exception e) {
			System.out.println("TestCase: Contacts - Failed");
			System.out.println("Error: "+e.getMessage());
		}
	}
		
		 

	
		static void TestCase_26() {
			 try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.linkText("Create New View")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.id("fname")).sendKeys(getPropertyValue("ViewName"));
				 //LocalDateTime dt=LocalDateTime.now();
				 driver.findElement(By.id("devname")).sendKeys(UUID.randomUUID().toString().replace("-", ""));
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
				 //waitForWebElementToBeVisible(driver.findElement(By.name("fcf")));
				 Thread.sleep(5000);
				 WebElement list=driver.findElement(By.name("fcf"));
				 Select sel=new Select(list);
				 
				 System.out.println(sel.getFirstSelectedOption().getText());
				if(sel.getFirstSelectedOption().getText().equals(getPropertyValue("ViewName")))
				System.out.println("TestCase26: - Passed");
				else
					System.out.println("TestCase26: - Failed");
				 
				 
			 }
			 catch (Exception e) {
			 System.out.println(e.getMessage());
			}
		
	}
		static void TestCase_25() {
			try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Contacts")).click();
			 Thread.sleep(2000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
			 Thread.sleep(2000);
			 driver.findElement(By.name("new")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")));
			 Thread.sleep(2000);
			 String sLastName=getPropertyValue("ContactsLastName");
			 driver.findElement(By.xpath("//input[contains(@name,'name_lastcon2')]")).sendKeys(sLastName);
			 String sAccName=getPropertyValue("AccountName");
			 driver.findElement(By.xpath("//span[contains(@class,'lookupInput')]//input[contains(@name,'con4')]")).sendKeys(sAccName);
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();//save
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(@class,'topName')]")));
			 Thread.sleep(2000);
			 
			 if(driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText().equals(sLastName))
					System.out.println("TestCase:25 - Passed");
				else
					System.out.println("TestCase:25 - Failed"); 
					
				Thread.sleep(2000);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		static void TestCase_27() {
			try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 WebElement elRecent=driver.findElement(By.id("hotlist_mode"));
				 Select selRcnt=new Select(elRecent);
				 selRcnt.selectByVisibleText("Recently Created");
				 Thread.sleep(2000);
				 WebElement elRecText=driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]"));
				 waitForWebElementToBeVisible(elRecText);
				 Thread.sleep(2000);
				 if(elRecText.getText().equals("Recent Contacts"))
					 System.out.println("TestCase27: - Passed");
				 else
					 System.out.println("TestCase27: - Failed");
				 
				 
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		static void TestCase_28() {
			try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 WebElement elDropDwn=driver.findElement(By.name("fcf"));
				 Select selC=new Select(elDropDwn);
				 
				 selC.selectByVisibleText("My Contacts");
				 
				 Thread.sleep(3000);
				
				 //WebElement elGO=driver.findElement(By.xpath("//table[@id=\"bodyTable\"]//input[@title=\"Go!\"]"));
				 WebElement elGO=driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]"));
				 System.out.println("before click");
				 elGO.click();
				 System.out.println("after click");
				 waitForWebElementToBeVisible(driver.findElement(By.name("addToCampaign")));
				 Thread.sleep(2000);   
				 System.out.println(driver.findElement(By.name("addToCampaign")).getText());
				 if(driver.findElement(By.name("addToCampaign")).getAttribute("value").equals("Add to Campaign"))
					 System.out.println("TestCase28: - Passed");
				 else
					 System.out.println("TestCase28: - Failed");
				 Thread.sleep(2000);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}

		static void TestCase_29() {
			
			try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.xpath("(//tr[contains(@class,'dataRow even first')]//a)[1]")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Post')]")));
				 Thread.sleep(2000);
				 if(driver.findElement(By.xpath("//span[contains(text(),'Post')]")).isEnabled())
					 System.out.println("TestCase29: - Passed");
				 else
					 System.out.println("TestCase29: - Failed");
			Thread.sleep(2000);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		static void TestCase_30() {
			
			 try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.linkText("Create New View")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.id("devname")).sendKeys(UUID.randomUUID().toString().replace("-", ""));
				 
				 driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
				 Thread.sleep(2000);
				 if(driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText()
						 .equals("Error: You must enter a value"))
					 System.out.println("TestCase30: - Passed");
				 else
					 System.out.println("TestCase30: - Failed");
				 Thread.sleep(2000);
			 }
			 catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	   static void TestCase_31() {
			 try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.linkText("Create New View")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.id("fname")).sendKeys(getPropertyValue("ViewNameCancel"));
				 
				 driver.findElement(By.id("devname")).sendKeys(UUID.randomUUID().toString().replace("-", ""));
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='cancel']")).click();
				 
				 Thread.sleep(2000);
				 
				 if(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).getText().equals("Recent Contacts"))
					 System.out.println("TestCase31: Passed");
				 else
					 System.out.println("TestCase31: Failed");
				
			 }
			 catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}

	   static void TestCase_32() {
		   try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Contacts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Contacts")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")));
				 Thread.sleep(2000);
				 driver.findElement(By.name("new")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")));
				 Thread.sleep(2000);
				 String sLastName=getPropertyValue("LName_Cancel");
				 driver.findElement(By.xpath("//input[contains(@name,'name_lastcon2')]")).sendKeys(sLastName);
				 String sAccName=getPropertyValue("AccountName_Cancel");
				 driver.findElement(By.xpath("//span[contains(@class,'lookupInput')]//input[contains(@name,'con4')]")).sendKeys(sAccName);
				 Thread.sleep(2000);
				 
				 driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[contains(@name,'save_new')]")).click();//save and new
				 
				 //waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")));
				 Thread.sleep(2000);
				 System.out.println("Text:=="+driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")).getText());
				 if(driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")).getText().equals("Contact Edit"))
						System.out.println("TestCase:32 - Passed");
					else
						System.out.println("TestCase:32 - Failed"); 
						
					Thread.sleep(2000);
		   }
		   catch (Exception e) {
			   System.out.println(e.getMessage());
		}
	   }



}

