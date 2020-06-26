package com.tatcs.frameworkPackage;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CaptureScreenShot {
	WebDriver driver;
	
	public CaptureScreenShot(WebDriver driver){
		this.driver = driver;
	}
	
	public void getScreenShot(String filepath) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(filepath));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDateTimeStamp(){
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();

		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[5] + "_" +
				sDatePart[1] + "_" +
				sDatePart[2] + "_" +
				sDatePart[3] ;
		sDateStamp = sDateStamp.replace(":", "_");
		System.out.println(sDateStamp);
		return sDateStamp;}

}
