package com.planittesting.cloud.jupiter.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.planittesting.cloud.jupiter.base.Base;
import com.planittesting.cloud.jupiter.pageactions.HomePageActions;
import com.planittesting.cloud.jupiter.pageactions.ShopPageActions;

public class ShopPageTestCases {

	public static ShopPageActions shopPageActions;

	@BeforeMethod
	public void setUp() {
		Base.initConfigaration();
	}

	// TestCase3 : Verify selected items are in the cart menu
	@Test
	public static void verificationOfItemsInCart() throws InterruptedException {
		shopPageActions = new ShopPageActions();
		HomePageActions.naviateToShopPage();
		ShopPageActions.buyFunnyCow();
		ShopPageActions.buyfluffyBunny();
		ShopPageActions.clickCartMenu();
		ShopPageActions.verifyItemsAreInCart();
	}

	// TestCase4 : Verify selected items Unit Price,Sub total price and Total price
	// of the items present in the cart menu
	@Test
	public static void verificationOfProductUnitPriceSubtotalPriceAndTotalPrice() throws InterruptedException {
		shopPageActions = new ShopPageActions();
		HomePageActions.naviateToShopPage();
		ShopPageActions.buyStuffedFrog();
		ShopPageActions.buyFivefluffyBunny();
		ShopPageActions.buyValentineBear();
		ShopPageActions.clickCartMenu();
		ShopPageActions.verifyUnitPriceOfProductsInCartMenu();
		ShopPageActions.verifySubtotalPriceOfProductsInCartMenu();
		ShopPageActions.verifyTotalPriceOfProductsInCartMenu();
	}

	@AfterMethod
	public void tearDown() {
		if (Base.driver != null) {
			Base.tearDown();
		}
	}
}
