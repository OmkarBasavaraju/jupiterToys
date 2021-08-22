package com.planittesting.cloud.jupiter.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	@FindBy(xpath = "//a[contains(text(),'Start Shopping »')]")
	public WebElement startShoppingButton;

	@FindBy(xpath = "//*[@id=\"nav-home\"]/a")
	public WebElement homeButton;

	@FindBy(css = "#nav-shop > a")
	public WebElement shopButton;

	@FindBy(linkText = "Contact")
	public WebElement contactButton;

	@FindBy(xpath = "//*[@id=\"nav-login\"]/ng-login/a")
	public WebElement loginButton;

}
