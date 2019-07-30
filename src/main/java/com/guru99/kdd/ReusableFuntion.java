package com.guru99.kdd;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

public class ReusableFuntion {
	WebDriver driver=null;
	
	public void launchApp() {
		driver=DriverFactory.getDriver("chrome");
		driver.get("http://www.demo.guru99.com/V4/index.php");
	}
	
	public void fillText(String locator,String locatorValue, String data) {
		switch(locator) {
			case "name":
				driver.findElement(By.name(locatorValue)).sendKeys(data);
				break;
			case "id":
				driver.findElement(By.id(locatorValue)).sendKeys(data);
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				break;
		}
		
	}
	public void click(String locator,String locatorValue) {
		switch(locator) {
			case "name":
				driver.findElement(By.name(locatorValue)).click();
				break;
			case "id":
				driver.findElement(By.id(locatorValue)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();
				break;
			case "linkText":
				driver.findElement(By.linkText(locatorValue)).click();
				break;
		}
	}
	
	/**
	 * Apache POI to fetch data from Excelsheet
	 * for .xls=HSSF
	 * for .xlsx=XSSF
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String[][] fetchDataFromExcelsheet() throws Exception {
		String excel_location="C:\\Users\\Chandan\\Desktop\\Automation\\selenium\\testcases.xlsx";
		File file=new File(excel_location);
		FileInputStream fs=new FileInputStream(file);
		String extension=excel_location.substring(excel_location.indexOf(".")+1);
	
		Workbook wb=null;
		if(extension.equals("xls")) {
			wb=new HSSFWorkbook(fs);//xls
		}else {
			wb=new XSSFWorkbook(fs);//xlsx
		}
		Sheet sheet=wb.getSheet("Sheet1");
		int rows=sheet.getLastRowNum()+1;
		int cols=sheet.getRow(0).getLastCellNum();
		//System.out.println("Rows: "+rows +"\t Cols="+cols);
		String[][] data=new String[rows][cols];
		for(int i=0;i<rows;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<cols;j++) {
				Cell cell=row.getCell(j);
				String value=cell.toString();
				data[i][j]=value;
			}
		}
		wb.close();
		return data;
	}
	


}
