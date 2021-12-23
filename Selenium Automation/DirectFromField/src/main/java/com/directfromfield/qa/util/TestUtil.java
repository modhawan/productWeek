package com.directfromfield.qa.util;

import com.directfromfield.qa.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    //Initialization:
    public static long IMPLICIT_WAIT = 20;
    public static String currentDir = System.getProperty("user.dir");
    public static String TESTDATA_SHEET_PATH= currentDir+"\\src\\main\\resources\\Userdata.xlsx";
    public static Workbook book;
    public static Sheet sheet;
    public static String categoryName="Fruits";
    public static String productName="orange";
    public static String pin = "282007";
    public static String paymentPhone = "7894533354";
    public static String paymentEmail = "modhawan@user.com";
    public static String homePageTitle = "FreshFromField";
    public static String paymentMode = "PayOnline";

    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try{
            file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (InvalidFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowNum][colNum];
        for(int i=0; i<rowNum; i++){
            for(int k=0;k<colNum;k++){
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }
}
