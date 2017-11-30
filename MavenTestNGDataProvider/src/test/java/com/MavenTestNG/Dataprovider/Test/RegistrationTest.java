package com.MavenTestNG.Dataprovider.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest implements EcommerceConstant{
  @Test
  public void SignUpTest() {
	    WebElement AccountElm = driver.findElement(By.linkText(ACCOUNT_LOCATOR));
	    AccountElm.click();
		WebElement SignUpElm = driver.findElement(By.xpath(SIGNUP_LOCATOR));
		SignUpElm.click();
		WebElement GenderElm = driver.findElement(By.xpath(GENDER_LOCATOR));
		GenderElm.click();
		WebElement FirstNameElm = driver.findElement(By.id(FIRSTNAME_LOCATOR));
		FirstNameElm.sendKeys(FIRSTNAME_DATA);
		WebElement LastNameElm = driver.findElement(By.id(LASTNAME_LOCATOR));
		LastNameElm.sendKeys(LASTNAME_DATA);
		WebElement BirthDateElm = driver.findElement(By.id(BIRTHDATE_LOCATOR));
		BirthDateElm.sendKeys(BIRTHDATE_DATA);
		WebElement BirthMonthElm = driver.findElement(By.id(BIRTHMONTH_LOCATOR));
		BirthMonthElm.sendKeys(BIRTHMONTH_DATA);
		WebElement BirthYearElm = driver.findElement(By.id(BIRTHYEAR_LOCATOR));
		BirthYearElm.sendKeys(BIRTHYEAR_DATA);
		WebElement EmailElm = driver.findElement(By.id(EMAIL_LOCATOR));
		EmailElm.sendKeys(REGISTRATION_EMAIL_DATA);
		WebElement HouseNoElm = driver.findElement(By.id(HOUSENUMBER_LOCATOR));
		HouseNoElm.sendKeys(HOUSENUMBER_DATA);
		WebElement StreetAddElm = driver.findElement(By.id(STREETADD_LOCATOR));
		StreetAddElm.sendKeys(STREETADD_DATA);
		WebElement CityElm = driver.findElement(By.id(CITY_LOCATOR));
		CityElm.sendKeys(CITY_DATA);
		WebElement StateElm = driver.findElement(By.id(STATE_LOCATOR));
		StateElm.sendKeys(STATE_DATA);
		WebElement CountryElm = driver.findElement(By.id(COUNTRY_LOCATOR));
		CountryElm.sendKeys(COUNTRY_DATA);
		WebElement PostcodeElm = driver.findElement(By.id(POSTCODE_LOCATOR));
		PostcodeElm.sendKeys(POSTCODE_DATA);
		WebElement PhoneElm = driver.findElement(By.id(PHONE_LOCATOR));
		PhoneElm.sendKeys(PHONE_DATA);
		WebElement PasswordElm = driver.findElement(By.id(PASSWORD_LOCATOR));
		PasswordElm.sendKeys(PASSWORD_DATA);
		WebElement ConfirmPasswordElm = driver.findElement(By.id(CONFIRMPASSWORD_LOCATOR));
		ConfirmPasswordElm.sendKeys(PASSWORD_DATA);
		WebElement NewsLetterElm = driver.findElement(By.id(NEWSLETTER_LOCATOR));
		NewsLetterElm.click();
		WebElement TermsElm = driver.findElement(By.id(TERMS_LOCATOR));
		TermsElm.click();
		WebElement SubmitElm = driver.findElement(By.name(SUBMIT_LOCATOR));
		SubmitElm.click();
  }
}
