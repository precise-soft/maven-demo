package com.tatcs.frameworkPackage;

import org.testng.ITestListener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	CaptureScreenShot capture = null;
	String filepath = "test-output/screencapture/";

	@Override		
	public void onFinish(ITestContext tr) {					
		// TODO Auto-generated method stub

	}

	@Override		
	public void onStart(ITestContext tr) {					
		// TODO Auto-generated method stub

	}

	@Override		
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {					
		// TODO Auto-generated method stub				

	}		

	@Override		
	public void onTestFailure(ITestResult tr) {
		System.out.println("");
		System.out.println("=============================================================================");
		System.out.println("******* The name of failed test case : " + tr.getName() + " ******");				
		System.out.println("=============================================================================");
		System.out.println("");

		String methodName=tr.getName().toString().trim();
		ITestContext context = tr.getTestContext();
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
		capture = new CaptureScreenShot(driver);
		String finalFilePath = filepath.concat(methodName + "_" + capture.getDateTimeStamp() + ".png");
		capture.getScreenShot(finalFilePath);
	}		

	@Override		
	public void onTestSkipped(ITestResult tr) {
		System.out.println("");
		System.out.println("=============================================================================");
		System.out.println("******* The name of skipped testcase : " + tr.getName() + " ******");		
		System.out.println("=============================================================================");
		System.out.println("");
	}		

	@Override		
	public void onTestStart(ITestResult tr) {
		System.out.println("");
		System.out.println("=============================================================================");
		System.out.println("******* " + tr.getName() + " test case started! ******");
		System.out.println("=============================================================================");
		System.out.println("");
	}		

	@Override		
	public void onTestSuccess(ITestResult tr) {
		System.out.println("");
		System.out.println("=============================================================================");
		System.out.println("******* The name of passed testcase : "+tr.getName()+ " ******");
		System.out.println("=============================================================================");
		System.out.println("");
	}	

}
