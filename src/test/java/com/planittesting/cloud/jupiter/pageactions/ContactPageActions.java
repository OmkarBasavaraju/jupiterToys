package com.planittesting.cloud.jupiter.pageactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.pagelocators.ContactPageLocators;
import com.planittesting.cloud.jupiter.utilities.ExtentReportManager;

public class ContactPageActions extends Base {

	public static ContactPageLocators contactPageLocators;
	public static SoftAssert validation = new SoftAssert();

	// Initializing the locators
	public ContactPageActions() {
		contactPageLocators = new ContactPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
		PageFactory.initElements(factory, contactPageLocators);
	}

	// Verifying error validation in the contact page
	public static void contactPageVerifyErrorValidation() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the submit button");
		contactPageLocators.submitButton.click();
		validation.assertEquals(getForenameErrorText(), "Forename is required");
		ExtentReportManager.test.log(Status.INFO, getForenameErrorText() + " error text is displayed");
		validation.assertEquals(getEmailErrorText(), "Email is required");
		ExtentReportManager.test.log(Status.INFO, getEmailErrorText() + " error text is displayed");
		validation.assertEquals(getMessageErrorText(), "Message is required");
		ExtentReportManager.test.log(Status.INFO, getMessageErrorText() + " error text is displayed");
		validation.assertEquals(getContactPageErrorText(),
				"We welcome your feedback - but we won't get it unless you complete the form correctly.");
		ExtentReportManager.test.log(Status.INFO, getContactPageErrorText() + " error text is displayed");
		validation.assertAll();

	}

	// Verifying error messages are not displayed after entering the text in the
	// mandatory fields in the contact page
	public static void contactPageVerifyErrorValidationNotDisplayed() {
		contactPageLocators.forenameField.sendKeys("test");
		ExtentReportManager.test.log(Status.INFO, "Typing the Forename as test");
		contactPageLocators.emailField.sendKeys("Test.example@planit.net.au");
		ExtentReportManager.test.log(Status.INFO, "Typing the Email as Test.example@planit.net.au");
		contactPageLocators.messageField.sendKeys("Good customer experience and nice service");
		ExtentReportManager.test.log(Status.INFO, "Typing the Message as Good customer experience and Nice service");
		validation.assertEquals(getForenameErrorText(), "");
		ExtentReportManager.test.log(Status.INFO, getForenameErrorText() + " error text is NOT displayed");
		validation.assertEquals(getEmailErrorText(), "");
		ExtentReportManager.test.log(Status.INFO, getEmailErrorText() + " error text is NOT displayed");
		validation.assertEquals(getMessageErrorText(), "");
		ExtentReportManager.test.log(Status.INFO, getMessageErrorText() + " error text is NOT displayed");
		validation.assertEquals(getContactPageErrorText(), "We welcome your feedback - tell it how it is.");
		ExtentReportManager.test.log(Status.INFO, getContactPageErrorText() + " text is displayed");
		validation.assertAll();
	}

	// Submission of feedback message
	public static void submissionOfFeedbackMessage(String Forename, String Email, String Message) {
		contactPageLocators.forenameField.sendKeys(Forename);
		ExtentReportManager.test.log(Status.INFO, "Typing the Forename as " + Forename);
		contactPageLocators.emailField.sendKeys(Email);
		ExtentReportManager.test.log(Status.INFO, "Typing the Email as " + Email);
		contactPageLocators.messageField.sendKeys(Message);
		ExtentReportManager.test.log(Status.INFO, "Typing the Message as " + Message);
		contactPageLocators.submitButton.click();
		ExtentReportManager.test.log(Status.INFO, "Clicking the submit button");
		ExtentReportManager.test.log(Status.INFO, "Validating the success message");
		wait.until(ExpectedConditions.textToBePresentInElement(contactPageLocators.contactPageSuccessMessage,
				"Thanks " + Forename + ", we appreciate your feedback."));
		validation.assertEquals(getSuccessMessageText(), "Thanks " + Forename + ", we appreciate your feedback.");
		validation.assertAll();
	}

	// Verifying the visibility of the contact page error text
	public static String getForenameErrorText() {
		if (isElementPresent(contactPageLocators.foreNameErrorMessage)) {
			String foreNameErrorMessage = contactPageLocators.foreNameErrorMessage.getText();
			return foreNameErrorMessage;
		} else
			return "";
	}

	// Verifying the visibility of the contact page error textt
	public static String getEmailErrorText() {
		if (isElementPresent(contactPageLocators.emailErrorMessage)) {
			String foreNameErrorMessage = contactPageLocators.emailErrorMessage.getText();
			return foreNameErrorMessage;
		} else
			return "";
	}

	// Verifying the visibility of the contact page error text
	public static String getMessageErrorText() {
		if (isElementPresent(contactPageLocators.messageErrorMessage)) {
			String foreNameErrorMessage = contactPageLocators.messageErrorMessage.getText();
			return foreNameErrorMessage;
		} else
			return "";
	}

	// Verifying the visibility of the contact page error text
	public static String getContactPageErrorText() {
		if (isElementPresent(contactPageLocators.contactPageErrorMessage)) {
			String foreNameErrorMessage = contactPageLocators.contactPageErrorMessage.getText();
			return foreNameErrorMessage;
		} else
			return "";
	}

	// Verifying the visibility of the success message
	public static String getSuccessMessageText() {
		return contactPageLocators.contactPageSuccessMessage.getText();

	}

	// Verifying the presence of the webelement
	public static boolean isElementPresent(WebElement locator) {
		try {
			(locator).isDisplayed();
			return true;
		} catch (Throwable t) {
			return false;
		}
	}
}
