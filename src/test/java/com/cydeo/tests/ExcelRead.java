package com.cydeo.tests;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

       // File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(3).getCell(2));

        int count1 = sheet.getPhysicalNumberOfRows();
        System.out.println(count1);

        int count2 = sheet.getLastRowNum();
        System.out.println(count2);

        for (int rowNum = 0; rowNum <= count2; rowNum++){

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }

        }

        for (int rowNum = 0; rowNum <= count2; rowNum++){

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Ali")){
                System.out.println(sheet.getRow(rowNum).getCell(2));
            }


        }



    }


}
