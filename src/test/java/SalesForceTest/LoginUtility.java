package SalesForceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUtility {

	public static WebDriver driver=null;
		
	public static void main(String[] args) {
			
		try {
		TestCase_01();//no pwd
		
		Thread.sleep(2000);
		TestCase_02();//login
		
		
		Thread.sleep(2000);
		TestCase_03();
		TestCase_04A();
		
		Thread.sleep(2000);
		TestCase_04B();
		quitBrowser();
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	//no password
	static void TestCase_02() {
		
		launchBrowser();
		
		
		loginBrowser();
		if(driver.findElement(By.linkText("Home")).isDisplayed())
			System.out.println("TestCase02 Passed");
		else
			System.out.println("TestCase02 Failed");
		quitBrowser();
	}
	static void TestCase_01() {
		launchBrowser();
		try {
			String sUsername=getUsername();
			String sPassword=getPwd();//input[@id='password']
			
			//System.out.println(sUsername+"-"+sPassword);
			WebElement elUser=driver.findElement(By.id("username"));
			elUser.sendKeys(sUsername);
			Thread.sleep(2000);
			driver.findElement(By.id("Login")).click();
			
			System.out.println(driver.findElement(By.id("error")).getText());
			
			if(driver.findElement(By.id("error")).getText().equals("Please enter your password."))
				System.out.println("TestCase01 - Passed");
			else
				System.out.println("TestCase01 - Failed");
		
		}
		catch (Exception e) {
			System.out.println("Error:TestCase01 - Failed");
		}
	}
	
	static void TestCase_03() {
		try {
		launchBrowser();
		String sUsername=getUsername();
		String sPassword=getPwd();//input[@id='password']
		
		//System.out.println(sUsername+"-"+sPassword);
		WebElement elUser=driver.findElement(By.id("username"));
		elUser.sendKeys(sUsername);
		WebElement elPwd=driver.findElement(By.id("password"));
		elPwd.sendKeys(sPassword);	
		Thread.sleep(2000);
		
		driver.findElement(By.name("rememberUn")).click();
		waitForWebElementToBeVisible(driver.findElement(By.id("Login")));
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
		waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		Thread.sleep(2000);
		WebElement eleMenu=driver.findElement(By.id("userNavButton"));
		 eleMenu.click();
		 
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Logout")).click();
		 Thread.sleep(2000);
		
		//span[contains(text(),'ashwini.n@salesforce.com')]
		//WebElement elUser2=driver.findElement(By.xpath("//span[contains(text(),'"+ sUsername+"')]"));
		// System.out.println("dsjfksj"+elUser2.getText());
		/* System.out.println(driver.findElement(By.xpath("//li//span")));
		 WebElement elUser2=driver.findElement(By.id("username"));
		System.out.println(driver.findElement(By.id("username")));
		
		 if(elUser2.getText().contains(sUsername)) {
			 System.out.println("TC02 - passed");
		 }
		 else
		 {
			 System.out.println("TC02 - failed");
		 }
		 */
		}
		catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		
	}
	static void TestCase_04A() {
		try {
		launchBrowser();
		String sUser=getUsername();
		Thread.sleep(2000);
		driver.findElement(By.id("forgot_password_link")).click();
		driver.findElement(By.id("un")).sendKeys(sUser);
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
   static void TestCase_04B() {
	   launchBrowser();
		try {
			String sUsername=getPropertyValue("WrongUser");
			String sPassword=getPropertyValue("WrongPwd");
			
			//System.out.println(sUsername+"-"+sPassword);
			WebElement elUser=driver.findElement(By.id("username"));
			elUser.sendKeys(sUsername);
			Thread.sleep(2000);
			WebElement elPwd=driver.findElement(By.id("password"));
			elPwd.sendKeys(sPassword);
			Thread.sleep(2000);
			driver.findElement(By.id("Login")).click();
			Thread.sleep(2000);
			if(driver.findElement(By.id("error")).getText().contains("Please check your username and password.")) 
				System.out.println("Testcase4B: Passed");
				else
					{
					System.out.println("Testcase4B: Failed");
					
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
   }
	static  void launchBrowser() {
		
		String sBrowser=null;
		try {
			String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\SalesForceTest\\UserInfo.properties";
			Properties prop=new Properties();
			FileInputStream fi=new FileInputStream(sPath);
			prop.load(fi);
			sBrowser=prop.getProperty("Browser").toString();
			//System.out.println(sBrowser);
		if(sBrowser.startsWith("ch")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		
		String sUrl=prop.getProperty("Url");
		//System.out.println(sUrl);
		driver.get(sUrl);
		driver.manage().window().maximize();
		WebElement eUserName=driver.findElement(By.id("username"));
		}
		catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		
		
		
	}

	static void loginBrowser() {
		try {
			
		String sUsername=getUsername();
		String sPassword=getPwd();//input[@id='password']
		
		//System.out.println(sUsername+"-"+sPassword);
		WebElement elUser=driver.findElement(By.id("username"));
		elUser.sendKeys(sUsername);
		WebElement elPwd=driver.findElement(By.id("password"));
		elPwd.sendKeys(sPassword);	
		
		 /* JavascriptExecutor js = (JavascriptExecutor)driver;	
		String sUserHtml=(String)js.executeScript(" return document.getElementById('username').value",elUser);
		String sPwdHtml=(String)js.executeScript(" return document.getElementById('password').value",elUser);
*/

			
		driver.findElement(By.id("Login")).click();
		
		waitForWebElementToBeVisible(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		Thread.sleep(2000);
	}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage().toString());
		}
	}

	static String getUsername() {
		String sUsername=null;
		try {
		String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\SalesForceTest\\UserInfo.properties";
		Properties prop=new Properties();
		FileInputStream fi=new FileInputStream(sPath);
		prop.load(fi);
		 sUsername=prop.getProperty("Username").toString();
		
		}
		catch (Exception e) {
			System.out.println("Error:UserName: "+e.getMessage().toString());
		}
		
			 return sUsername;
		
	}
	
	static String getPwd() {
		String sPwd=null;
		try {
			String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\SalesForceTest\\UserInfo.properties";
			Properties prop=new Properties();
			FileInputStream fi=new FileInputStream(sPath);
			prop.load(fi);
			sPwd=prop.getProperty("Password").toString();
			return sPwd;
			}
			catch (Exception e) {
				System.out.println("Error:Password: "+e.getMessage().toString());
			}
		return sPwd;
	}

	static void waitForWebElementToBeVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(LoginUtility.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	static String getPropertyValue(String sKey) {
		String sVal=null;
		try {
		String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\SalesForceTest\\UserInfo.properties";
		Properties prop=new Properties();
		FileInputStream fi=new FileInputStream(sPath);
		prop.load(fi);
		sVal=prop.getProperty(sKey);
		
		}
		catch (Exception e) {
			System.out.println("Error:GetProperty -"+e.getMessage().toString());
		}
		return sVal;
	}
	static void quitBrowser() {
	driver.quit();
}
}
