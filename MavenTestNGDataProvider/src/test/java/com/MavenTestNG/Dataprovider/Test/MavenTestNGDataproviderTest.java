package com.MavenTestNG.Dataprovider.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class MavenTestNGDataproviderTest extends BaseTest implements EcommerceConstant {
	@DataProvider(name = "SuccessIds")
	public Object[][] SuccessIDsP() {
		String[][] IDs = {
				{"test1@gmail.com","pwd1"}, 
				{"test2@gmail.com","pwd2"}, 
				{"test3@gmail.com","pwd3"}, 
				{"test4@gmail.com","pwd4"}
			};
		return IDs; 
		//return new Object[][]{{"test1@gmail.com","pwd1"}, {"test2@gmail.com","pwd2"}, {"test3@gmail.com","pwd3"}, {"test4@gmail.com","pwd4"}};
	}

	@Test(dataProvider = "SuccessIds")
	public void EcommLoginTest(String EmailId, String Pwd) throws Exception {
		
		WebElement emailID = driver.findElement(By.id(EMAIL_LOCATOR));
		emailID.sendKeys(EmailId);

		WebElement PassWord = driver.findElement(By.id(PASSWORD_LOCATOR));
		PassWord.sendKeys(Pwd);

		WebElement LoginID = driver.findElement(By.linkText(LOGIN_LOCATOR));
		LoginID.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
}
