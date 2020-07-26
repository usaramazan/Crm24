package com.crm24.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    public static void main(String[]  args)  {
         File file = new File("src/Book1.xlsx");
       // System.out.println(file.exists());
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("couldn't find excel file");
        }

        XSSFSheet sheet = workbook.getSheet("employee");
        Cell value = sheet.getRow(1).getCell(1);
        System.out.println(value);
        int usedRows = sheet.getPhysicalNumberOfRows();
        //it counts only used cells
//       if there are some cells that are not used , they will not be counted
        System.out.println(usedRows);//it starts counting from 1
        int numberOfRow = sheet.getLastRowNum();
        System.out.println(numberOfRow);//it starts counting from 0, like index
        
        //print out Irfan's name dynamically

        for (int i = 0; i <numberOfRow ; i++) {
            if(sheet.getRow(i).getCell(0).toString().equals("Irfan")){
                System.out.println("Irfan's name : "+sheet.getRow(i).getCell(0));
            }
        }

        for (int i = 0; i <numberOfRow ; i++) {
            if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase("hamide")){
                System.out.println(sheet.getRow(i).getCell(1));
            }
        }
    }

}
