package com.dsalgo.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dsalgo.dsbase.DsAlgoBase;

public class DsAlgoUtil extends DsAlgoBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	 public static void takeSnapShot(WebDriver webdriver,String fileNamne) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(System.getProperty("user.dir")+"/screenshots/"+fileNamne);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }
	 public static void scroll(WebDriver driver,int x, int y)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy("+x+","+y+")","");
		}
}
