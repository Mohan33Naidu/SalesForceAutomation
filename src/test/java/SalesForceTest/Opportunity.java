package SalesForceTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Opportunity extends LoginUtility {

	public static void main(String[] args) {
		try
		{
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Opportunities")));
			 //Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 Thread.sleep(1000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reports')]")));
			 Thread.sleep(2000);
			 
			 if(driver.findElement(By.id("fcf")).isEnabled())
				 System.out.println("TestCase:15 - Passed");
			 else
				 System.out.println("TestCase:15 - Failed");
			 TestCase_16();
			 
			 TestCase_17();
			
			 StuckOpp();//TestCase18
			
			 TestCase_19();
			
			 quitBrowser();
			 
		}
		catch (Exception e) {
			System.out.println("TestCase: Opportunity - Failed");
			System.out.println("Error: "+e.getMessage());
		}
	}
    
	static void TestCase_16() {
		try {
			
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Opportunities")));
			 //Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 Thread.sleep(1000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reports')]")));
			 Thread.sleep(2000);
		driver.findElement(By.name("new")).click();
		waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')]")));
		Thread.sleep(2000);
		
		WebElement eTable=driver.findElement(By.xpath("(//div[contains(@class,'pbBody')]//table[@class=\"detailList\"])[1]"));
		List<WebElement> Rows=eTable.findElements(By.tagName("tr"));
		for(int i=0;i<Rows.size();i++) {
			List<WebElement> cols=Rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++) {
				
				if(i==1&&j==1)
				{	//date
					Thread.sleep(2000);
					driver.findElement(By.name("opp9")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@id='datePicker']//a[contains(@class,'calToday')]")).click();
					/*Actions act=new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//div[@id='datePicker']//a[contains(@class,'calToday')]"))).click().perform();
					*/
					Thread.sleep(2000);
					
				}
				
				if(i==2) {
					//opponame
					if(j==0)
					driver.findElement(By.xpath("//div//input[@name=\"opp3\"]")).sendKeys(getPropertyValue("OpportunityName"));
				}
				
				if(i==3)
				{	//accountname
					if(j==0)
						driver.findElement(By.name("opp4")).sendKeys(getPropertyValue("AccountName"));
						//Stage
						if(j==1)
						{
							WebElement elStage=driver.findElement(By.name("opp11"));
							Select sel=new Select(elStage);
							sel.selectByVisibleText(getPropertyValue("Stage"));
						}
				}
				//probability
				if(i==4 && j==1)
					driver.findElement(By.name("opp12")).sendKeys(getPropertyValue("Probability"));
				
				if(i==5) {
					//Leadsrc
					if(j==0)
						driver.findElement(By.name("opp6")).sendKeys(getPropertyValue("LeadSrc"));
					if(j==1)
						driver.findElement(By.name("opp17")).sendKeys(getPropertyValue("Campaign"));
				
				}
			}
			
		}
		Thread.sleep(1000);
		waitForWebElementToBeVisible(driver.findElement(By.name("save")));
		Thread.sleep(2000);
		driver.findElement(By.name("save")).click();
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'Opportunity Detail')]")).isDisplayed())
			System.out.println("TestCase:16 - passed");
		else
			System.out.println("TestCase:16 - failed");
		
		
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void StuckOpp() {

		try {
			waitForWebElementToBeVisible(driver.findElement(By.linkText("Opportunities")));
			 //Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reports')]")));
			 Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Stuck")).click();
		 WebElement StuckReports=driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]"));
		 
		 waitForWebElementToBeVisible(StuckReports);
		 
		 if(StuckReports.isDisplayed())
		 {
			 System.out.println("TestCase18: - Passed");
		 }
		 else
			 System.out.println("TestCase18: - Failed");
		 
		 
		 
	}
	catch (Exception e) {
		System.out.println("TestCase: Opportunity - Failed");
		System.out.println("Error: "+e.getMessage());
	}
	}

	static void TestCase_17() {
		
		try {
			waitForWebElementToBeVisible(driver.findElement(By.linkText("Opportunities")));
			 //Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 Thread.sleep(1000);
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reports')]")));
			 Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")));
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")).isDisplayed())
			System.out.println("TestCase17: - Passed");
		else
			System.out.println("TestCase17: - Failed");
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void TestCase_19() {
		
		try {
			waitForWebElementToBeVisible(driver.findElement(By.linkText("Opportunities")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 
			 
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Reports')]")));
			 Thread.sleep(2000);
		
		WebElement elInter=driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select sel=new Select(elInter);
			sel.selectByVisibleText("Current and Next FQ");
			WebElement elInclude=driver.findElement(By.xpath("//select[@id='open']"));
			sel=new Select(elInclude);
			sel.selectByVisibleText("All Opportunities");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//table[contains(@class,'opportunitySummary')]//input[contains(@name,'go')]")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")).getText());
			if(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")).getText().contains("Report"))
				System.out.println("TestCase19: - Passed");
			else
				System.out.println("TestCase19: - False");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
