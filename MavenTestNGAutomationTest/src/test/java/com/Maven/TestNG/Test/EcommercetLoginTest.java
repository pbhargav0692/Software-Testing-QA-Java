package com.Maven.TestNG.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class EcommercetLoginTest extends BaseTest implements EcommerceConstant {

	@Test
	public void EcommerceLogin() throws Exception {

		WebElement emailID = driver.findElement(By.id(EMAIL_LOCATOR));
		emailID.sendKeys(EMAIL_DATA);

		WebElement PassWord = driver.findElement(By.id(PASSWORD_LOCATOR));
		PassWord.sendKeys(LOGIN_PASSWORD_DATA);

		WebElement LoginID = driver.findElement(By.linkText(LOGIN_LOCATOR));
		LoginID.click();
		Thread.sleep(1000);

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
	}

}
