package com.planittesting.cloud.jupiter.pageactions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.pagelocators.ShopPageLocators;
import com.planittesting.cloud.jupiter.utilities.ExtentReportManager;

public class ShopPageActions extends Base {

	public static ShopPageLocators shopPageLocators;
	public static double subTotalPriceOfStuffedFrog;
	public static double subTotalPriceOfFluffyBunny;
	public static double subTotalPriceOfValentineBear;
	static SoftAssert validation = new SoftAssert();

	// Initializing the locators
	public ShopPageActions() {
		shopPageLocators = new ShopPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, shopPageLocators);
	}

	// Click Funny cow buy button in shop page
	public static void buyFunnyCow() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the Funny cow buy button");
		for (int buy = 0; buy < 2; buy++) {
			shopPageLocators.funnyCowBuyButton.click();
		}
	}

	// Click Fluffy bunny buy button in shop page
	public static void buyfluffyBunny() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the Fluffy bunny buy button");
		shopPageLocators.fluffyBunnyBuyButton.click();
	}

	// Click Fluffy bunny buy button in shop page
	public static void buyFivefluffyBunny() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the Fluffy bunny buy button");
		for (int buy = 0; buy < 5; buy++) {
			shopPageLocators.fluffyBunnyBuyButton.click();
		}
	}

	// Click Stuffed frog buy button in shop page
	public static void buyStuffedFrog() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the Stuffed frog buy button");
		for (int buy = 0; buy < 2; buy++) {
			shopPageLocators.stuffedFrogBuyButton.click();
		}
	}

	// Click Stuffed frog buy button in shop page
	public static void buyValentineBear() {
		ExtentReportManager.test.log(Status.INFO, "Clicking the Valentine bear buy button");
		for (int buy = 0; buy < 3; buy++) {
			shopPageLocators.valentineBearBuyButton.click();
		}
	}

	// Click on the cart menu button
	public static void clickCartMenu() throws InterruptedException {
		ExtentReportManager.test.log(Status.INFO, "Navigating to the cart menu");
		shopPageLocators.cartButton.click();
		wait.until(ExpectedConditions.visibilityOf(shopPageLocators.verifyFluffyBunnyToyInCartMenu));
	}

	// Verify selected items are in the cart menu
	public static void verifyItemsAreInCart() {
		ExtentReportManager.test.log(Status.INFO, "Verifying items are in the cart menu");
		shopPageLocators.verifyFluffyBunnyToyInCartMenu.isDisplayed();
		shopPageLocators.verifyFunnyCowToyInCartMenu.isDisplayed();
	}

	public static String getStuffedFrogPrice() {
		return shopPageLocators.stuffedFrogPrice.getText();
	}

	public static String getFluffyBunnyPrice() {
		return shopPageLocators.fluffyBunnyPrice.getText();
	}

	public static String getValentineBearPrice() {
		return shopPageLocators.valentineBearPrice.getText();
	}

	// Get total price of items in the cart menu
	public static double verifyTotalPriceOfToys() {
		ExtentReportManager.test.log(Status.INFO, "Verifying total price of items are in the cart menu");
		String str = shopPageLocators.totalPriceOfToys.getText();
		String str2 = str.substring(7);
		double valentineBearSubTotalPrice = Double.parseDouble(str2);
		return valentineBearSubTotalPrice;
	}

	// Get unit cost of stuffed frog in the cart menu
	public static double getStuffedFrogUnitProductPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying unit price of Stuffed frog in the cart menu");
		String price = shopPageLocators.stuffedFrogPrice.getText();
		String str = price.substring(1);
		double stuffedFrogUnitPrice = Double.parseDouble(str);
		return stuffedFrogUnitPrice;

	}

	// Get unit cost of fluffy bunny in the cart menu
	public static double getFluffyBunnyUnitProductPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying unit price of Fluffy bunny in the cart menu");
		String price = shopPageLocators.fluffyBunnyPrice.getText();
		String str = price.substring(1);
		double fluffyBunnyUnitPrice = Double.parseDouble(str);
		return fluffyBunnyUnitPrice;
	}

	// Get unit cost of valentine bear in the cart menu
	public static double getValentineBearUnitProductPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying unit price of Valentine bear in the cart menu");
		String price = shopPageLocators.valentineBearPrice.getText();
		String str = price.substring(1);
		double valentineBearUnitPrice = Double.parseDouble(str);
		return valentineBearUnitPrice;
	}

	// Get Sub total cost of fluffy bunny in the cart menu
	public static double getFluffyBunnySubTotalPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying sub total price of Fluffy bunny in the cart menu");
		String str = shopPageLocators.fluffyBunnySubTotalPrice.getText();
		String str2 = str.substring(1);
		double fluffyBunnySubTotalPrice = Double.parseDouble(str2);
		return fluffyBunnySubTotalPrice;
	}

	// Get Sub total cost of stuffed frog in the cart menu
	public static double getStuffedFrogSubTotalPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying sub total price of Stuffed frog in the cart menu");
		String str = shopPageLocators.stuffedFrogSubTotalPrice.getText();
		String str2 = str.substring(1);
		double stuffedFrogSubTotalPrice = Double.parseDouble(str2);
		return stuffedFrogSubTotalPrice;
	}

	// Get Sub total cost of valentine bear in the cart menu
	public static double getValentineBearSubTotalPrice() {
		ExtentReportManager.test.log(Status.INFO, "Verifying sub total price of Valentine Bear in the cart menu");
		String str = shopPageLocators.valentineBearSubTotalPrice.getText();
		String str2 = str.substring(1);
		double valentineBearSubTotalPrice = Double.parseDouble(str2);
		return valentineBearSubTotalPrice;
	}

	// Get the quantity of stuffed frog in the cart menu
	public static int getStuffedFrogQuantity() {
		String quantity = shopPageLocators.stuffedFrogQuantity.getAttribute("value");
		int stuffedFrogQuantity = Integer.parseInt(quantity);
		return stuffedFrogQuantity;
	}

	// Get the quantity of fluffy bunny in the cart menu
	public static int getFluffyBunnyQuantity() {
		String quantity = shopPageLocators.fluffyBunnyQuantity.getAttribute("value");
		int fluffyBunnyQuantity = Integer.parseInt(quantity);
		return fluffyBunnyQuantity;
	}

	// Get the quantity of valentine bear in the cart menu
	public static int getValentineBearQuantity() {
		String quantity = shopPageLocators.valentineBearQuantity.getAttribute("value");
		int valentineBearQuantity = Integer.parseInt(quantity);
		return valentineBearQuantity;
	}

	// Verify Unit price of products in the cart menu
	public static void verifyUnitPriceOfProductsInCartMenu() {
		validation.assertEquals(ShopPageActions.getStuffedFrogPrice(), "$10.99");
		validation.assertEquals(ShopPageActions.getFluffyBunnyPrice(), "$9.99");
		validation.assertEquals(ShopPageActions.getValentineBearPrice(), "$14.99");
		validation.assertAll();
	}

	// Verify Sub total price of products in the cart menu
	public static void verifySubtotalPriceOfProductsInCartMenu() {
		subTotalPriceOfStuffedFrog = ShopPageActions.getStuffedFrogUnitProductPrice()
				* ShopPageActions.getStuffedFrogQuantity();
		subTotalPriceOfFluffyBunny = ShopPageActions.getFluffyBunnyUnitProductPrice()
				* ShopPageActions.getFluffyBunnyQuantity();
		subTotalPriceOfValentineBear = ShopPageActions.getValentineBearUnitProductPrice()
				* ShopPageActions.getValentineBearQuantity();
		validation.assertEquals(ShopPageActions.getStuffedFrogSubTotalPrice(), subTotalPriceOfStuffedFrog);
		validation.assertEquals(ShopPageActions.getFluffyBunnySubTotalPrice(), subTotalPriceOfFluffyBunny);
		validation.assertEquals(ShopPageActions.getValentineBearSubTotalPrice(), subTotalPriceOfValentineBear);
		validation.assertAll();
	}

	// Verify Total price of products in the cart menu
	public static void verifyTotalPriceOfProductsInCartMenu() {
		double totalPriceOfToys = (subTotalPriceOfStuffedFrog + subTotalPriceOfFluffyBunny
				+ subTotalPriceOfValentineBear);
		validation.assertEquals(ShopPageActions.verifyTotalPriceOfToys(), totalPriceOfToys);
		validation.assertAll();
	}

}
