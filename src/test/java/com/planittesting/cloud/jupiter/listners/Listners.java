package com.planittesting.cloud.jupiter.listners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.utilities.ExtentReportManager;

public class Listners extends Base implements ITestListener {

	public static String methodName;
	Date d = new Date();
	ExtentReports report = ExtentReportManager.reporterSetup();

	public void onTestStart(ITestResult result) {
		// Creating the test name for the report on test start
		ExtentReportManager.test = report.createTest(result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {

	}

	public void onTestSkipped(ITestResult result) {
		// Details to be written to the report on skip
		methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentReportManager.test.pass(m);
	}

	public void onTestFailure(ITestResult result) {

		// code for capturing screenshot
		String date = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + "error.jpg";
		String screenShotPath = (System.getProperty("user.dir") + properties.getProperty("screenShotPath") + date);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File filestorage = new File(screenShotPath);
		try {
			FileUtils.copyFile(screenshot, filestorage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Details to be written to the report on fail
		methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " FAILED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		String errorStackTrace = Arrays.toString(result.getThrowable().getStackTrace());
		ExtentReportManager.test
				.info("<Details><Summary>Click to see the Stack Trace</Summary>" + errorStackTrace + "</Details>");
		ExtentReportManager.test
				.info("<a href =" + screenShotPath + " target = \"_blank\">Click to see screenshot</a>");
		ExtentReportManager.test.fail(m);
	}

	public void onTestSuccess(ITestResult result) {
		// Details to be written to the report on pass
		methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentReportManager.test.pass(m);
	}

	public void onFinish(ITestContext context) {
		// write the test information to a destination
		report.flush();
	}

}
