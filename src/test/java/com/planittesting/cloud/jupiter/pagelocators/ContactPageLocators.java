package com.planittesting.cloud.jupiter.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageLocators {

	@FindBy(xpath = "//input[@id='forename']")
	public WebElement forenameField;

	@FindBy(xpath = "//*[@id=\"surname\"]")
	public WebElement surnameField;

	@FindBy(xpath = "//*[@id=\"email\"]")
	public WebElement emailField;

	@FindBy(xpath = "//*[@id=\"telephone\"]")
	public WebElement telephoneField;

	@FindBy(xpath = "//*[@id=\"message\"]")
	public WebElement messageField;

	@FindBy(xpath = "//a[contains(text(),'Submit')]")
	public WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"forename-err\"]")
	public WebElement foreNameErrorMessage;

	@FindBy(xpath = "//*[@id=\"email-err\"]")
	public WebElement emailErrorMessage;

	@FindBy(xpath = "//*[@id=\"message-err\"]")
	public WebElement messageErrorMessage;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]")
	public WebElement contactPageErrorMessage;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]")
	public WebElement contactPageSuccessMessage;

	@FindBy(xpath = "//a[contains(text(),'« Back')]")
	public WebElement backButton;

}
