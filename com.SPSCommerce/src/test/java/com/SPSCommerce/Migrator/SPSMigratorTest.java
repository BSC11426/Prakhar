package com.SPSCommerce.Migrator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;	

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.util.Tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SPSCommerce.Utility.InputData;

import cucumber.api.java.Before;

public  class SPSMigratorTest extends InputData {
	
	static WebDriver driver = new FirefoxDriver();


	@BeforeTest
	public static void Migrator() throws InterruptedException
	{
		InputData i = new InputData();
		i.PropertyUtils();
		
		driver.get(prop.getProperty("SPSCommerce.migrator"));
		driver.findElement(By.xpath(prop.getProperty("SPSCommerce.usernamelocator"))).sendKeys(prop.getProperty("SPSCommerce.username"));
		driver.findElement(By.xpath(prop.getProperty("SPSCommerce.passwordlocator"))).sendKeys(prop.getProperty("SPSCommerce.password"));
		driver.findElement(By.xpath(prop.getProperty("SPSCommerce.Login"))).click();
		System.out.println("Successful login into Transaction tracker");	
		Thread.sleep(6000);
	}
	
	@Test(priority=1) // will click on the Source Environment and select prod from the dropdown
	public static void SourceEnvironment() throws FindFailed
	{
		Screen screen1 = new Screen();
		Pattern p1 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/sourceenv.PNG");
		screen1.wait(p1,15).click();
		Pattern p2 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/selectsearchpara.PNG");
		screen1.wait(p2,15).click();
	}
	
	@Test(priority=2) // Will click on Table and select profile from the dropdown
	public static void Table() throws FindFailed
	{
		Screen screen2 = new Screen();
		Pattern p3 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/selecttable.PNG");
		screen2.wait(p3,15).click();
		Pattern p4 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/selectprofilefromtable.PNG");
		screen2.wait(p4,15).click();		
	}
	
	@Test(priority=3) // Will click on Search by Column and select profile_name
	public static void SearchbyColumn() throws FindFailed
	{
		Screen screen3 = new Screen();
		Pattern p5 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/lasttry.PNG");
		screen3.wait(p5,15).click();
		Pattern p6 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/latest.PNG");
		screen3.wait(p6,15).click();
	}
		
	
	@Test(priority=4) //will click on Search Paramenters and Type the Name of the Profile
	public static void searchparameter() throws FindFailed, InterruptedException
	{
		Screen screen4 = new Screen();
		Pattern p7 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/A4.PNG");
		screen4.wait(p7,15).click();
		Pattern p9 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/A3.PNG");
		screen4.wait(p9,15).click();		
		screen4.type("Amazon China | RSX on SIP Platform | SR");
		screen4.wait(p7,10);
	}
	
	@Test(priority=5) 
	public static void Selectsearchparameter() throws FindFailed, InterruptedException
	{	
		Screen screen5 = new Screen();
		Pattern p8 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/A5.PNG");
		screen5.wait(p8,15).click();
	}
	
	@Test(priority=6)
	public static void Export() throws FindFailed, InterruptedException
	{	
		Screen screen6 = new Screen();
		Pattern p9 = new Pattern("C://Users/prakhar.jain/Pictures/SPSComm/A6.PNG");
		screen6.wait(p9,15).click();
		System.out.println("The connection between the Supplier and the retailer can be migrated");
		Thread.sleep(8000);
		driver.close();
	}
	
}	





	/*@Test
	public static void MigratorTab()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
	    
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[4]/div[1]/div/ul/li[1]/a")));
	    Or we can use below code also..
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[4]/div[1]/div/ul/li[1]/a")));
	    boolean statusOfElement = element.isDisplayed();
	    
	    if(statusOfElement)
	    {    String name = element.getText();
	        System.out.println(" WebElement is visible ");
	        System.out.println("WebElement name is : "+name);
	    }
	    else
	    {
	        System.out.println(" WebElement is not visible ");
	    }
	    
		WebElement migratorMenu=driver.findElement(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[1]/div[3]/div/ul/li[1]/a//following::a[20]"));
		//WebElement migratorMenu=driver.findElement(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[4]/div[1]/div/ul/li[1]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(migratorMenu).build().perform();
		act.click();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[4]/div[1]/div/ul/li[1]/a"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		je.executeScript("arguments[0].click();",element);
		
		
	}
	
	static WebDriver d2 = new FirefoxDriver();
	public static void TransactionTrackerlogin() throws InterruptedException{
		
		d2.get("https://commerce.spscommerce.com/auth/login/");
		d2.findElement(By.xpath("html/body/section/div/div/div/form/input[1]")).sendKeys("gbhise@spscommerce.com");
		d2.findElement(By.xpath("html/body/section/div/div/div/form/input[2]")).sendKeys("Di@mond77^");
		d2.findElement(By.xpath("html/body/section/div/div/div/form/button")).click();
		System.out.println("Successful login into Transaction tracker");	
		Thread.sleep(4000);
	}		
	public static void MigratorTab(){
		d2.findElement(By.xpath("html/body/section/section/div/section/div/div/div[1]/div[4]/div[1]/div/ul/li[1]/a")).click();	
	}*/
		


