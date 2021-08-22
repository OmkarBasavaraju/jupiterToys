package com.planittesting.cloud.jupiter.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPageLocators {

	@FindBy(xpath = "//*[@id=\"product-1\"]/div/p/a")
	public WebElement teddyBearBuyButton;

	@FindBy(xpath = "//*[@id=\"product-2\"]/div/p/a")
	public WebElement stuffedFrogBuyButton;

	@FindBy(xpath = "//*[@id=\"product-3\"]/div/p/a")
	public WebElement handMadeDollBuyButton;

	@FindBy(xpath = "//*[@id=\"product-4\"]/div/p/a")
	public WebElement fluffyBunnyBuyButton;

	@FindBy(css = "#product-5 > div > p > a")
	public WebElement smileyBearBuyButton;

	@FindBy(css = "#product-6 > div > p > a")
	public WebElement funnyCowBuyButton;

	@FindBy(css = "#product-7 > div > p > a")
	public WebElement valentineBearBuyButton;

	@FindBy(css = "#product-8 > div > p > a")
	public WebElement smileyFaceBuyButton;

	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	public WebElement verifyFunnyCowToyInCartMenu;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[1]")
	public WebElement verifyFluffyBunnyToyInCartMenu;

	@FindBy(xpath = "//*[@id=\"nav-cart\"]/a/span")
	public WebElement cartButton;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr/td[2]")
	public WebElement stuffedFrogPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[2]/td[2]")
	public WebElement fluffyBunnyPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]")
	public WebElement valentineBearPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[4]")
	public WebElement stuffedFrogSubTotalPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[2]/td[4]")
	public WebElement fluffyBunnySubTotalPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[4]")
	public WebElement valentineBearSubTotalPrice;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")
	public WebElement totalPriceOfToys;

	@FindBy(xpath = " //tbody/tr[1]/td[3]/input[1]")
	public WebElement stuffedFrogQuantity;

	@FindBy(xpath = "//tbody/tr[2]/td[3]/input[1]")
	public WebElement fluffyBunnyQuantity;

	@FindBy(xpath = "//tbody/tr[3]/td[3]/input[1]")
	public WebElement valentineBearQuantity;

}
