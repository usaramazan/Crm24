package com.crm24.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelWrite {
    public static void main(String[] args) {
        XSSFWorkbook workbook=null;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "src/Book1.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("couldn't find excel file");

        }
        sheet = workbook.getSheet("employee");
        row = sheet.getRow(1);
        cell = row.getCell(1);

        //storing a name to be able to use it later
        XSSFCell ramazanCell = sheet.getRow(1).getCell(0);
        System.out.println(ramazanCell);
        ramazanCell.setCellValue("Hero");//we want to write into ramazan's cell
        //we already defined the location but we need to create fileoutputstream
        // to specify which file we want to write.
        System.out.println("After ramazan's cell :"+ramazanCell);

        //change irfan's name into Okan
        XSSFCell irfansCell = sheet.getRow(3).getCell(0);
        irfansCell.setCellValue("Okan");
        System.out.println(irfansCell);

        int numberOfRow = sheet.getLastRowNum();

        for (int i = 0; i <numberOfRow ; i++) {
            if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase("okan")){
                sheet.getRow(i).getCell(0).setCellValue("Ayhan");
            }
        }

        for (int i = 0; i <numberOfRow ; i++) {
            if(sheet.getRow(i).getCell(0).toString().equals("Hamide")){
                sheet.getRow(i).getCell(2).setCellValue("grandma");
            }
        }



        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("couldn't find excel file");
        }


    }
}
