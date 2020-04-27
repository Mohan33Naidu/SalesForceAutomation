package SalesForceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Leads extends LoginUtility{

	public static void main(String[] args) {
		try
		{
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 TestCase_20();
			 TestCase_21();
			 TestCase_22();
			 TestCase_23();
			TestCase_24();
			Thread.sleep(2000);
			quitBrowser();
			
		}
		catch (Exception e) {
			System.out.println("TestCase: Leads - Failed");
			System.out.println("Error: "+e.getMessage());
		}
		
}
	
	
	   static void TestCase_23() {
		
	    	try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
				 
				 driver.findElement(By.linkText("Leads")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
				 Thread.sleep(2000);
				 WebElement list=driver.findElement(By.id("fcf"));
				 list.click();
				 
				 Select sel=new Select(list);
				 sel.selectByVisibleText("Today's Leads");
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.name("new")));
				 Thread.sleep(2000);
				 //System.out.println(sel("Today's Leads"));
				 WebElement elTody=driver.findElement(By.xpath("//select//option[contains(text(),\"Today's Leads\")]"));
				 
				 if(driver.findElement(By.name("new")).isDisplayed() && elTody.getText().equals("Today's Leads") )
				 System.out.println("TestCase23: - Passed");
				 
				 else
				 System.out.println("TestCase23: - Failed");
				 Thread.sleep(2000);
	    	}
	    	catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    	
		
	}
	
	   static void TestCase_22() {
		
		   try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
				 
				 driver.findElement(By.linkText("Leads")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
				 Thread.sleep(2000);
				 WebElement list=driver.findElement(By.id("fcf"));
				 list.click();
				 
				 Select sel=new Select(list);
				 sel.selectByVisibleText("Today's Leads");
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.name("new")));
				 Thread.sleep(2000);
				 //logout
				 WebElement eleMenu=driver.findElement(By.id("userNavButton"));
				 eleMenu.click();
				 driver.findElement(By.linkText("Logout")).click();;
				 Thread.sleep(2000);
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//input[@id='Login']")));
				 Thread.sleep(2000);
				 loginBrowser();
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
				 
				 driver.findElement(By.linkText("Leads")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.name("new")));
				 Thread.sleep(2000);
				 
				 if(driver.findElement(By.name("new")).getAttribute("value").equals("New Lead"))
					 System.out.println("TestCase22:- Passed");
				 else
					 System.out.println("TestCase22:- Failed");
						 
				 
				 
		   }
		   catch (Exception e) {
			   System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}
	   static void TestCase_21() {
		
		  try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
				 
				 driver.findElement(By.linkText("Leads")).click();
				 Thread.sleep(2000);
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
				 Thread.sleep(2000);
				 WebElement list=driver.findElement(By.id("fcf"));
				 list.click();
				 Thread.sleep(2000);
				 
				if(driver.findElement(By.xpath("//option[contains(text(),'View - Custom 2')]")).isDisplayed())
					System.out.println("TestCase:21 - Passed");
				else
					System.out.println("TestCase:21 - Failed");
		  }
		  catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	   static void TestCase_20() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
			 
			 driver.findElement(By.linkText("Leads")).click();
			 Thread.sleep(2000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
			 Thread.sleep(2000);
			 if(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")).isDisplayed())
				 System.out.println("TestCase:20 - Passed");
			 else
				 System.out.println("TestCase:20 - Failed");
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	static void TestCase_24() {
		try {
		 waitForWebElementToBeVisible(driver.findElement(By.linkText("Leads")));
		 
		 driver.findElement(By.linkText("Leads")).click();
		 Thread.sleep(2000);
		 
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.name("new")).click();
		 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Lead Information')]")));
		 Thread.sleep(2000);
		 String sLastName=getPropertyValue("LeadLastName");
		 driver.findElement(By.xpath("//input[contains(@name,'name_lastlea2')]")).sendKeys(sLastName);
		 String sCompany=getPropertyValue("LeadCompany");
		 driver.findElement(By.xpath("//input[contains(@name,'lea3')]")).sendKeys(sCompany);
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]")).click();//save
		
		if(driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText().equals(sLastName))
			System.out.println("TestCase:24 - Passed");
		else
			System.out.println("TestCase:24 - Failed"); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

}