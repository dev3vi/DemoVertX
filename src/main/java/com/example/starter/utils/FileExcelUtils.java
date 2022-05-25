package com.example.starter.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class FileExcelUtils {


  public static void saveFile(String pathTemplate, String nameSheet, String nameFile, int fromRow, List<List<String>> data)
    throws IOException {
//    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathTemplate));
//    XSSFSheet sheet = workbook.getSheet(nameSheet);
//
//    int countRow = fromRow;
//    for (List<String> rowData : data) {
//      writeRow(sheet, rowData, countRow);
//      countRow += 1;
//    }
//    try (OutputStream fileOut = new FileOutputStream(nameFile)) {
//      workbook.write(fileOut);
//      workbook.close();
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//      workbook.close();
//    }
//  }





        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet
          = workbook.createSheet(" Student Data ");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData
          = new TreeMap<String, Object[]>();

        studentData.put(
          "1",
          new Object[] { "Roll No", "NAME", "Year" });

        studentData.put("2", new Object[] { "128", "Aditya",
          "2nd year" });

        studentData.put(
          "3",
          new Object[] { "129", "Narayana", "2nd year" });

        studentData.put("4", new Object[] { "130", "Mohan",
          "2nd year" });

        studentData.put("5", new Object[] { "131", "Radha",
          "2nd year" });

        studentData.put("6", new Object[] { "132", "Gopal",
          "2nd year" });

        Set<String> keyid = studentData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

          row = spreadsheet.createRow(rowid++);
          Object[] objectArr = studentData.get(key);
          int cellid = 0;

          for (Object obj : objectArr) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
          }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
          new File("C:\\Users\\BVCN 88\\Downloads\\test.xlsx"));

        workbook.write(out);
        out.close();


//  private static void writeRow(XSSFSheet sheet, List<String> item, int countRow) {
//    Row row = sheet.createRow(countRow);
//    int countCol = 0;
//    for ( String value : item ) {
//      Cell cell = row.createCell(countCol);
//      cell.setCellValue(value);
//      countCol += 1;
//    }
//  }
}}
