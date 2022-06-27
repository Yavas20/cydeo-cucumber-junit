package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelWrite {

    String filePath = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(100000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(200000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(300000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(400000);

        for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Emre")){

                sheet.getRow(rowNum).getCell(1).setCellValue("Yavas");
            }

        }



        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();




    }

}
