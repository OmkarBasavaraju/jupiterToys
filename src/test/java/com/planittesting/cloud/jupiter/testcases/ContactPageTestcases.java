package com.planittesting.cloud.jupiter.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.pageactions.ContactPageActions;
import com.planittesting.cloud.jupiter.pageactions.HomePageActions;
import com.planittesting.cloud.jupiter.utilities.Utilities;

public class ContactPageTestcases {

	public ContactPageActions contactPageActions;

	@BeforeMethod
	public void setUp() {
		Base.initConfigaration();
	}

	// TestCase1: Verifying error validation in the contact page and also upon
	// entering the mandatory fields error message are not displayed
	@Test
	public void errorValidationOfContactPage() {
		contactPageActions = new ContactPageActions();
		HomePageActions.naviateToContactPage();
		ContactPageActions.contactPageVerifyErrorValidation();
		ContactPageActions.contactPageVerifyErrorValidationNotDisplayed();
	}

	// TestCase2: Submission of feedback message
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void verifySubmissionOfFeedBackMsg(String Forename, String Email, String Message) {
		contactPageActions = new ContactPageActions();
		HomePageActions.naviateToContactPage();
		ContactPageActions.submissionOfFeedbackMessage(Forename, Email, Message);
	}

	@AfterMethod
	public void tearDown() {
		if (Base.driver != null) {
			Base.tearDown();
		}
	}

}
