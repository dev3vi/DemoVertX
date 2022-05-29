package com.example.starter.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileExcelUtils {

  public static void saveFile() throws IOException {
    String pathTemplate = "list.xlsx";
    String nameSheet = "Sheet1";
    String nameFile = "data/filename.xlsx";

    List<String> list = new ArrayList<>();
    list.add("thao");
    list.add("luong");
    list.add("van");
    List<String> list2 = new ArrayList<>();
    list2.add("thao2");
    list2.add("luong2");
    list2.add("van2");
    List<List<String>> data = new ArrayList<>();
    data.add(list);
    data.add(list2);


    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathTemplate));
    XSSFSheet sheet = workbook.getSheet(nameSheet);

    int countRow = 1;
    for (List<String> rowData : data) {
      writeRow(sheet, rowData, countRow);
      countRow += 1;
    }

    try (OutputStream fileOut = new FileOutputStream(nameFile)) {
      workbook.write(fileOut);
      workbook.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      workbook.close();
    }
  }

  private static void writeRow(XSSFSheet sheet, List<String> item, int countRow) {
    Row row = sheet.createRow(countRow);
    int countCol = 0;
    for ( String value : item ) {
      Cell cell = row.createCell(countCol);
      cell.setCellValue(value);
      countCol += 1;
    }
  }
}
