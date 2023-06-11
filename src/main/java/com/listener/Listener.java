package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
	    test = report.createTest(result.getName());
	  }

	  public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS, MarkupHelper.createLabel("Test Case Executed Successfully", ExtentColor.GREEN));
	    
	  }

	 
	  public void onTestFailure(ITestResult result) {
		  test.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
	  }

	 
	  public void onTestSkipped(ITestResult result) {
		  test.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skipped", ExtentColor.ORANGE));
	  }

	
	  public void onStart(ITestContext context) {
	    ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("D:\\MyAutomation\\TestAutomation\\APIAutomation\\test-output\\ExtentReport\\Report-"+System.currentTimeMillis()+".html");
	    htmlreport.config().setTheme(Theme.DARK);
	    htmlreport.config().setEncoding("UTF-8");
	    htmlreport.config().setReportName("API Automation Report");
	    
	    report = new ExtentReports();
	    report.attachReporter(htmlreport);
	    report.setSystemInfo("Author", "Sayan Dasgupta");
	    report.setSystemInfo("Application", "API Automation");
	    report.setSystemInfo("OS", "Windows 10");
	  }

	  
	  public void onFinish(ITestContext context) {
	    report.flush();
	  }
}
