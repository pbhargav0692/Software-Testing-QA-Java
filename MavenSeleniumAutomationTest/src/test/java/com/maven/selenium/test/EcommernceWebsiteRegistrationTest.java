package com.maven.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EcommernceWebsiteRegistrationTest implements EcommerceConstant {

	private static final String REGISTRATION_EMAIL_DATA = "pbhargav0692@gmail.com";

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.get(WEBPAGE_URL);
		driver.findElement(By.linkText(ACCOUNT_LOCATOR)).click();
		driver.findElement(By.xpath(SIGNUP_LOCATOR)).click();
		driver.findElement(By.xpath(GENDER_LOCATOR)).click();
		driver.findElement(By.id(FIRSTNAME_LOCATOR)).sendKeys(FIRSTNAME_DATA);
		driver.findElement(By.id(LASTNAME_LOCATOR)).sendKeys(LASTNAME_DATA);
		driver.findElement(By.id(BIRTHDATE_LOCATOR)).sendKeys(BIRTHDATE_DATA);
		driver.findElement(By.id(BIRTHMONTH_LOCATOR)).sendKeys(BIRTHMONTH_DATA);
		driver.findElement(By.id(BIRTHYEAR_LOCATOR)).sendKeys(BIRTHYEAR_DATA);
		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(REGISTRATION_EMAIL_DATA);
		driver.findElement(By.id(HOUSENUMBER_LOCATOR)).sendKeys(HOUSENUMBER_DATA);
		driver.findElement(By.id(STREETADD_LOCATOR)).sendKeys(STREETADD_DATA);
		driver.findElement(By.id(CITY_LOCATOR)).sendKeys(CITY_DATA);
		driver.findElement(By.id(STATE_LOCATOR)).sendKeys(STATE_DATA);
		driver.findElement(By.id(COUNTRY_LOCATOR)).sendKeys(COUNTRY_DATA);
		driver.findElement(By.id(POSTCODE_LOCATOR)).sendKeys(POSTCODE_DATA);
		driver.findElement(By.id(PHONE_LOCATOR)).sendKeys(PHONE_DATA);
		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(PASSWORD_DATA);
		driver.findElement(By.id(CONFIRMPASSWORD_LOCATOR)).sendKeys(PASSWORD_DATA);
		driver.findElement(By.id(NEWSLETTER_LOCATOR)).click();
		driver.findElement(By.id(TERMS_LOCATOR)).click();
		driver.findElement(By.name(SUBMIT_LOCATOR)).click();
	}
}
