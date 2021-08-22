package com.planittesting.cloud.jupiter.pageactions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.Status;
import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.pagelocators.HomePageLocators;
import com.planittesting.cloud.jupiter.utilities.ExtentReportManager;

public class HomePageActions extends Base {

	public static HomePageLocators homePageLocators;
	public static HomePageActions homePageActions;

	// Initializing the locators
	public HomePageActions() {
		homePageLocators = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, homePageLocators);
	}

	// Navigating to the contact page
	public static void naviateToContactPage() {
		homePageActions = new HomePageActions();
		ExtentReportManager.test.log(Status.INFO, "Naviagting to the contact page");
		homePageLocators.contactButton.click();
	}

	// Navigating to the shop page
	public static void naviateToShopPage() {
		homePageActions = new HomePageActions();
		ExtentReportManager.test.log(Status.INFO, "Naviagting to the shop page");
		homePageLocators.shopButton.click();
	}

}
