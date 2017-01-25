package com.SPSCommerce.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public  class InputData {
	   
	   public static  Properties prop = new Properties();
	     public static WebDriver driver;
	     
	     public  void PropertyUtils()
	     {
	          File file = new File("C:/Users/prakhar.jain/workspace/com.SPSCommerce/target/Config.properties");
	          FileInputStream fileInput = null;
	          {
	          try 
	          {
	              fileInput = new FileInputStream(file);
	              prop.load(fileInput);
	              //fileInput.close();
	              System.out.println(prop.getProperty("SPSCommerce"));
	          } catch (FileNotFoundException ex) 
	          {
	              ex.printStackTrace();
	          }
	          catch (IOException e) 
	          {
	              e.printStackTrace();
	          }
	          
	     }
	     
	}
	
}
