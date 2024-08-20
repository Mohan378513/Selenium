package com.excel.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

	public static void main(String[] args) {


		Xls_Reader reader = new Xls_Reader("D:\\Selenium WebDriver\\FreeCRMTest\\src\\main\\java\\com\\excel\\utility\\HalfEbayTestData.xlsx");
		
		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
	//	WebDriver driver = new ChromeDriver();
		
	//	driver.get("https://www.facebook.com/");
		
		
	}

}
