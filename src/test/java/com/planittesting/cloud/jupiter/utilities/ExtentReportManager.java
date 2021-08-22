package com.planittesting.cloud.jupiter.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.planittesting.cloud.jupiter.base.Base;

public class ExtentReportManager extends Base {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest test;

	// Configuring the spark html report
	public static ExtentReports reporterSetup() {
		Date d = new Date();
		String filename = (d.toString().replace(":", "_").replace(" ", "_") + "report.html");
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\target\\Reports\\" + filename);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Jupiter toys project execution reports");
		htmlReporter.config().setDocumentTitle("Jupiter toys project");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Organization", "Jupiter Toys");
		extentReport.setSystemInfo("AutomationTester", "Omkar G B");
		return extentReport;
	}

}
