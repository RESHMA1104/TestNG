package com.utilities;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
public class ExcelUtilities {
    String path = "C:\\Selenium\\Log4jDemo\\src\\test\\resources\\DataProvider.xlsx";
    @DataProvider(name = "validData", parallel = true)
    public Object[][] validDataProvider() {
        return getValidData(path, "Sheet1");
    }
    @DataProvider(name = "invalidData", parallel = true)
    public Object[][] invalidDataProvider() {
        return getInvalidData(path, "Sheet1");
    }

    public Object[][] getValidData(String fileName, String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(1); 
            int noofCols = row.getLastCellNum();
            data = new Object[1][noofCols];
            for (int j = 0; j < noofCols; j++) {
                Cell cell = row.getCell(j);
                data[0][j] = (cell != null) ? cell.toString() : "";
            }
           workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Valid Data Error: " + e.getMessage());
        }
        return data;
    }
    public Object[][] getInvalidData(String fileName, String sheetName) {

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int noofRows = sheet.getPhysicalNumberOfRows();
            int noofCols = sheet.getRow(0).getLastCellNum();
            data = new Object[noofRows - 2][noofCols]; 
            for (int i = 2; i < noofRows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < noofCols; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 2][j] = (cell != null) ? cell.toString() : "";
                }
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Invalid Data Error: " + e.getMessage());
        }
        return data;
    }
}