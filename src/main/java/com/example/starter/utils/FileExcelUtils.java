//package com.example.starter.utils;
//import model.LogChangeStatusAgentExcel;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class FileExcelUtils {
//  public static Logger LOG = LoggerFactory.getLogger(FileExcelUtils.class);
//
//  public static void saveFile(String pathTemplate, String nameSheet, String nameFile, int fromRow, List<List<String>> data) throws IOException {
//
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
//
//  public static void saveFile(String pathTemplate, String nameSheet, String nameFile, int fromRow, List<List<String>> data, String title) throws IOException {
//    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathTemplate));
//    XSSFSheet sheet = workbook.getSheet(nameSheet);
//
//    CellStyle cellStyle = workbook.createCellStyle();
//    cellStyle.setBorderBottom(BorderStyle.THIN);
//    cellStyle.setBorderRight(BorderStyle.THIN);
//    cellStyle.setBorderBottom(BorderStyle.THIN);
//    cellStyle.setBorderLeft(BorderStyle.THIN);
//
//    int countRow = fromRow;
//    Row row = sheet.getRow(1);
//    Cell cell = row.getCell(0);
//    cell.setCellValue(title);
//    for (List<String> rowData : data) {
//      writeRow(sheet, rowData, countRow, cellStyle);
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
//
//  private static void writeRow(XSSFSheet sheet, List<String> item, int countRow) {
//    Row row = sheet.createRow(countRow);
//    int countCol = 0;
//    for ( String value : item ) {
//      Cell cell = row.createCell(countCol);
//      cell.setCellValue(value);
//      countCol += 1;
//    }
//  }
//
//  private static void writeRow(XSSFSheet sheet, List<String> item, int countRow, CellStyle cellStyle) {
//    Row row = sheet.createRow(countRow);
//    int countCol = 0;
//    for ( String value : item ) {
//      Cell cell = row.createCell(countCol);
//      cell.setCellValue(value);
//      cell.setCellStyle(cellStyle);
//      countCol += 1;
//    }
//  }
