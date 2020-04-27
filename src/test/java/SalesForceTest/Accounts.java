package SalesForceTest;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Accounts extends LoginUtility{

	public static void main(String[] args) {
		try
		{
			 launchBrowser();
			 loginBrowser();
			 WebDriver driver=LoginUtility.driver;
			 //TestCase_10();
			 //TestCase_11();
			 //TestCase_12();
			 
			 quitBrowser();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	

	  static void TestCase_10() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 
			 driver.findElement(By.linkText("Accounts")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.name("new")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.name("new")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(text(),'Account Edit')]")));
			 Thread.sleep(2000);
			 driver.findElement(By.id("acc2")).sendKeys(getPropertyValue("AccountName"));
			 
			 Select selType=new Select(driver.findElement(By.id("acc6")));
			 selType.selectByVisibleText("Technology Partner");
			 
			 Select selPriorty=new Select(driver.findElement(By.id("00N5w00000HaGEK")));
			 selPriorty.selectByVisibleText("High");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("(//input[@name=\"save\"])[2]")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.className("topName")));
			 Thread.sleep(2000);
			 
			 if(driver.findElement(By.className("topName")).isDisplayed())
				 System.out.println("TestCase10: - Passed");
			 else
				 System.out.println("TestCase10: - Failed");
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}

	 static void TestCase_11() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 
			 driver.findElement(By.linkText("Accounts")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Create New View")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Create New View")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.id("fname")).sendKeys(getPropertyValue("AccountViewName"));
			 driver.findElement(By.id("devname")).sendKeys(UUID.randomUUID().toString().replace("-", ""));
			 driver.findElement(By.xpath("(//input[@name=\"save\"])[1]")).click();
			 
			 Thread.sleep(2000);
			 WebElement elAcView=driver.findElement(By.name("fcf"));
			 Select selAccView=new Select(elAcView);
			 if(selAccView.getFirstSelectedOption().getText().contains(getPropertyValue("AccountViewName")))
				 System.out.println("TestCase11: - Passed");
			 else
				 System.out.println("TestCase11: - Failed");
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}

	 static void TestCase_12() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 
			 driver.findElement(By.linkText("Accounts")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Edit")));
			 Thread.sleep(2000);
			 WebElement elAcctView=driver.findElement(By.name("fcf"));
			 Select sel=new Select(elAcctView);
			 sel.selectByVisibleText(getPropertyValue("AccountViewName"));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Edit")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]")));
			 Thread.sleep(2000);
			 driver.findElement(By.id("fname")).clear();
			 driver.findElement(By.id("fname")).sendKeys(getPropertyValue("EditAcctViewName"));
			 
			 Select selField=new Select(driver.findElement(By.xpath("//select[@name='fcol1']")));
			 selField.selectByVisibleText("Account Name");
			 
			 Select selOp=new Select(driver.findElement(By.xpath("//select[@name='fop1']")));
			 selOp.selectByVisibleText("contains");
			 
			 driver.findElement(By.xpath("//input[@name='fval1']")).sendKeys(getPropertyValue("EditAccValue"));
			 
			 Thread.sleep(2000);
			 Select selAvail=new Select(driver.findElement(By.id("colselector_select_0")));
			 
			 selAvail.selectByVisibleText("Last Activity");
			 Thread.sleep(2000);;
			 driver.findElement(By.id("colselector_select_0_right")).click();
			 driver.findElement(By.xpath("(//input[@name=\"save\"])[1]")).click();
			 Thread.sleep(2000);
			 WebElement elAcView=driver.findElement(By.name("fcf"));
			 Select selAccView=new Select(elAcView);
			 if(selAccView.getFirstSelectedOption().getText().contains(getPropertyValue("EditAcctViewName")))
				 System.out.println("TestCase12: - Passed");
			 else
				 System.out.println("TestCase12: - Failed");
			 Thread.sleep(2000);
			 
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	 }
}
