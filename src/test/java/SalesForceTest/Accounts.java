package SalesForceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.Alert;
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
			 TestCase_13();
			 TestCase_10();
			 TestCase_11();
			 TestCase_12();
			 
			 TestCase_14();
			 quitBrowser();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	

	 static void TestCase_14() {
		
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Accounts")).click();
			 
			 waitForWebElementToBeVisible(driver.findElement(By.
					 xpath("//div[@class=\"toolsContentLeft\"]//a[contains(text(),'last activity > 30 days')]")));
			 Thread.sleep(2000);
			 //System.out.println("reached here");
			 driver.findElement(By.xpath("//div[@class='toolsContentLeft']//a[contains(text(),'last activity > 30 days')]")).click();
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[contains(text(),'Filters')]")));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.id("ext-gen152")).click();
			 //Thread.sleep(1000);
			 driver.findElement(By.xpath("(//button[contains(text(),'Today')])[1]")).click();
			 //Thread.sleep(1000);
			 			 
			 driver.findElement(By.id("ext-gen154")).click();
			 driver.findElement(By.xpath("(//button[contains(text(),'Today')])[2]")).click();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.id("ext-gen49")).click();
			 //Thread.sleep(2000);
			 System.out.println(driver.getWindowHandles().size());
			 
			 driver.findElement(By.name("reportName")).sendKeys(getPropertyValue("ReportName"));
			 
			 driver.findElement(By.name("reportDevName")).sendKeys(Long.toString(System.currentTimeMillis()));
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]")).click();
			 Thread.sleep(2000);
			 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")));
			 
			 if(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]")).isDisplayed())
				 System.out.println("TestCase:14 - Passed");
			 else
				 System.out.println("TestCase:14 - Failed");
			 Thread.sleep(2000);
			 
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		//a[contains(text(),'Accounts with last activity > 30 days')]
		
	}



	static void TestCase_13() {
		   try {
				 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Accounts")).click();
				 
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")));
				 Thread.sleep(2000);
				 
				 driver.findElement(By.linkText("Merge Accounts")).click();
				 waitForWebElementToBeVisible(driver.findElement(By.xpath("//h2[contains(text(),'Step 1. Select the records to merge')]")));
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//input[@id='srch']")).clear();
				 driver.findElement(By.xpath("//input[@id='srch']")).sendKeys(getPropertyValue("SearchAccounts"));
				 driver.findElement(By.name("srchbutton")).click();
				 Thread.sleep(2000);
				 
				 WebElement table=driver.findElement(By.xpath("(//table['list'])[3]"));
				 List<WebElement> eRows=table.findElements(By.tagName("tr"));
				// System.out.println(eRows.size());
				 String sMergeAcct1=getPropertyValue("MergeAcct1");
				 String sMergeAcct2=getPropertyValue("MergeAcct2");
				 
				 
				 
				// System.out.println(eRows.size());
				 for (int i=1;i<eRows.size();i++) {
					 
				//   (//table["list"])[3]//tr[2]
					 List<WebElement> eColumns=driver.findElements(By.xpath("(//table['list'])[3]//tr["+(i+1)+"]//td"));
					 //System.out.println(eColumns.size());
					   
					
					
					 String AcctColName=eColumns.get(0).getText();
					// System.out.println(AcctColName);
					 if(AcctColName.equals(sMergeAcct1) || AcctColName.equals(sMergeAcct2))
					 {
						 
						
				        driver.findElement(By.xpath("//tr["+(i+1)+"]//th//input")).click();
						 Thread.sleep(2000);
						 System.out.println("clicked chkbox");
						// System.out.println(AcctColName);
					 }
					 	
					
					 
					 					 
				 }
				 Thread.sleep(2000);
				 //next
				 System.out.println(" before next");
				 driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'goNext')]")).click();
				 
				 //merge
				 System.out.println("before wait save");
				 Thread.sleep(2000);
				waitForWebElementToBeVisible(driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'goPrevious')]")));
				 Thread.sleep(2000);//div[@class='pbWizardHeader']//input[@name=\"save\"]
				 System.out.println("save");//div[@class="pbBody"]//div[@class='pbWizardHeader']//input[@name="save"]
				 driver.findElement(By.xpath("//div[@class=\"pbBody\"]//div[@class='pbWizardHeader']//input[@name=\"save\"]")).click();
				 System.out.println("before  alert");
				 Alert altbox=driver.switchTo().alert();
					altbox.accept();//OK
				
				 if(driver.findElement(By.xpath("//h3[contains(text(),'Recent Accounts')]")).isDisplayed())
				 
						System.out.println("TestCase:13 - Passed");
				 else
					 System.out.println("TestCase:13 - Failed"); 
				   Thread.sleep(2000);
		   }
		   catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
  	}



	 static void TestCase_10() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 Thread.sleep(2000);
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
			 Thread.sleep(2000);
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}

	 static void TestCase_11() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 Thread.sleep(2000);
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
			 Thread.sleep(2000);
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}

	 static void TestCase_12() {
		 try {
			 waitForWebElementToBeVisible(driver.findElement(By.linkText("Accounts")));
			 Thread.sleep(2000);
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
