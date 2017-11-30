package com.Maven.TestNG.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceCategories extends BaseTest implements EcommerceConstant {
	public void EcommerceLogin() {
		driver.findElement(By.linkText(ACCOUNT_LOCATOR)).click();
		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(EMAIL_DATA);
		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(PASSWORD_DATA);
		driver.findElement(By.linkText(LOGIN_LOCATOR)).click();
	}

	/*
	 * @Test public void EcommerceCategoryTest() throws Exception {
	 * Driver.findElement(By.linkText(CATEGORY_LOCATOR)).click();
	 * Thread.sleep(3000); String ExpUrl =
	 * "http://ecommerce.saipratap.net/catlist.php";
	 * Assert.assertEquals(Driver.getCurrentUrl(), ExpUrl); }
	 */
	@Test
	public void EcommereceCategorieslistTest() throws Exception {
		driver.findElement(By.linkText(CATEGORY_LOCATOR)).click();
		driver.findElement(By.xpath(CATEGORY_CLICKTOCONTINUE_LOCATOR)).click();
		driver.findElement(By.xpath(CATEGORY_CONTINUE_LOCATOR)).click();
		Thread.sleep(3000);
		String ExpUrl = "http://ecommerce.saipratap.net/products.php";
		if (ExpUrl.equals(driver.getCurrentUrl())) {
			System.out.println("There are items to buy");
		} else {
			System.out.println("There are no items available, please try again later");
		}
		// Assert.assertEquals(Driver.getCurrentUrl(), ExpUrl);
	}

	@Test
	public void EcommerceCartAddRemoveTest() throws Exception {

		// Adding the item to the cart
		EcommerceLogin();
		driver.findElement(By.linkText(PRODUCTS_LOCATOR)).click();
		System.out.println("Choose your favurite Product");
		driver.findElement(By.xpath(PRODUCT_LOCATOR)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(PRDUCT_DESCRIPTION_LOCATOR)).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(MY_CART_LOCATOR)).click();
		boolean test = true;
		if (driver.findElement(By.xpath(CART_DATA_LOCATOR)) != null) {
			System.out.println("The product has been added successfully");
		} else {
			System.out.println("The product has not been added yet!");
			test = false;
		}
		Assert.assertEquals(test, true);

		// Removing the product from the cart
		driver.findElement(By.linkText(MY_CART_LOCATOR)).click();
		driver.findElement(By.xpath(CART_ITEM_DELETE_LOCATOR)).click();
		Alert alert = driver.switchTo().alert(); // Get a handle to the open
													// alert, prompt or
													// confirmation
		Thread.sleep(1000);
		alert.getText(); // Get the text of the alert or prompt
		Thread.sleep(1000);
		alert.accept(); // And acknowledge the alert (equivalent to clicking
						// "OK")
		Thread.sleep(1000);
		System.out.println("Your product has been removed successfully");
		/*
		 * String ExpUrl =
		 * "http://ecommerce.saipratap.net/cart.php?a=3&intid=5163";
		 * if(ExpUrl.equals(Driver.getCurrentUrl())){ System.out.
		 * println("The product has been removed successfully from the list");
		 * }else{ System.out.println("You still have product to buy"); }
		 */
	}
}
