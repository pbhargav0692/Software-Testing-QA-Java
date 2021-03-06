package com.maven.selenium.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.Assert;

public class OrderTest implements EcommerceConstant{

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(WEBPAGE_URL);
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
		driver.findElement(By.linkText(CHECKOUT_LOCATOR)).click();
		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(EMAIL_DATA);
		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(LOGIN_PASSWORD_DATA);
		driver.findElement(By.linkText(LOGIN_LOCATOR)).click();
		System.out.println("Please confirm your detatil");
		driver.findElement(By.xpath(CONTINUE_LOCATOR)).click();
		//System.out.println("Shipping::" + By.xpath(SHIPPING_TYPE_LOCATOR));
		//driver.findElement(By.xpath(SHIPPING_TYPE_LOCATOR)).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.id(HOUSENUMBER_LOCATOR)).sendKeys(HOUSENUMBER_DATA);
		driver.findElement(By.id(ORDER_ADDRESS_LOCATOR)).sendKeys(STREETADD_DATA);
		driver.findElement(By.id(CITY_LOCATOR)).sendKeys(CITY_DATA);
		driver.findElement(By.id(ORDER_POSTCODE_LOCATOR)).sendKeys(POSTCODE_DATA);
		driver.findElement(By.id(STATE_LOCATOR)).sendKeys(STATE_DATA);
		driver.findElement(By.id(COUNTRY_LOCATOR)).sendKeys(COUNTRY_DATA);
		driver.findElement(By.name(SUBMIT_LOCATOR)).click();
		driver.findElement(By.xpath(PAYMENT_CONTINUE_LOCATOR)).click();
		driver.findElement(By.xpath(CONFIRM_CONTINUE_LOCATOR)).click();
		driver.findElement(By.name(ORDER_POSTCODE_LOCATOR)).sendKeys(ORDER_CODE_DATA);
		driver.findElement(By.name(SUBMIT_LOCATOR)).click();
		driver.findElement(By.xpath(PAYMENT_CONTINUE_LOCATOR)).click();
		driver.findElement(By.xpath(CODE_CONTINUE_LOCATOR)).click();
		driver.findElement(By.name(SUBMIT_LOCATOR)).click();
		String ExpUrl = PAYMENT_URL;
		if (ExpUrl.equals(driver.getCurrentUrl())) {
			System.out.println("You can proceed to the checkout");
		} else {
			System.out.println(
					"Things don't appear to be working at the moment. Please try again later OR the information you entered is incorrect");
		}
	}
}
