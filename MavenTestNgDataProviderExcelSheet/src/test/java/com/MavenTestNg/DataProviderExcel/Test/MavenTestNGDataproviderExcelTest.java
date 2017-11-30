package com.MavenTestNg.DataProviderExcel.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MavenTestNGDataproviderExcelTest extends BaseTest implements EcommerceConstant {
	@DataProvider(name = "SuccessIds")
	public Object[][] SuccessIDsP() {
		Object[][] a = getTableArray("Book1.xls", "UnitTesting", "Ecomm_Success_Ids");
		return (a);
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

	// get directly from the site
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");
		}
		return (tabArray);
	}
}
