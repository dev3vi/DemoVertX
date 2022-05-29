//package com.example.starter.Handler;
//
//import io.vertx.core.Handler;
//import io.vertx.core.Vertx;
//import io.vertx.core.http.HttpServerRequest;
//import io.vertx.core.http.HttpServerResponse;
//import io.vertx.ext.web.RoutingContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import providers.ResponseProvider;
//import util.DateUtil;
//import util.FileExcelUtils;
//import util.PropertiesFile;
//import util.ReportUtil;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class ReportTVVDailyGETHandlers implements Handler<RoutingContext> {
//  public static Logger LOG = LoggerFactory.getLogger(ReportTVVDailyGETHandlers.class);
//
//  public ReportTVVDailyGETHandlers() {
//  }
//
//  @Override
//  public void handle(RoutingContext context) {
//    HttpServerRequest request = context.request();
//    HttpServerResponse response = context.response();
//
//    try {
//      long startTime = System.currentTimeMillis();
//      SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
//      SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
//      String stringStartDate = request.getParam("start_date");
//      String stringEndDate = request.getParam("end_date");
//      String botId = request.getParam("bot_id");
//      String type = request.getParam("type");
//      if (type == null) {
//        type = "date";
//      }
//      if (botId == null) {
//        botId = PropertiesFile.getInstance().getConfig(PropertiesFile.FileConfig.MAIN, "botId");
//      }
//      LOG.info(botId);
//      LOG.info(stringStartDate);
//      LOG.info(stringEndDate);
//      String targetFile = "data/tvv-daily-" + type + "-" + botId +  "-" + stringStartDate + "-" + stringEndDate +".xlsx";
//
//      if (stringEndDate == null || stringStartDate == null) {
//        ResponseProvider.makeSuccessResponse(response, "Require params start_date, end_date");
//        return;
//      }
//      Date startDate = formatDate.parse(stringStartDate);
//      Date endDate = formatDate.parse(stringEndDate);
//      List<List<String>> data = ReportUtil.getDataReportTVVDaily(botId, startDate, DateUtil.addDays(endDate, 1), type);
//
//      LOG.info("total record: " + data.size());
//      String fileTemplate = "report_tvv_daily.xlsx";
//      String nameSheet = "luu luong chuyen tvv theo ngay";
//      if (!type.equals("date")) {
//        fileTemplate = "report_tvv_hour.xlsx";
//        nameSheet = "luu luong chuyen tvv theo gio";
//      }
//      String title = "TỪ NGÀY "+ formatDate2.format(startDate) +" ĐẾN " + formatDate2.format(endDate);
//      FileExcelUtils.saveFile(fileTemplate, nameSheet, targetFile, 5, data, title);
//      long endTime = System.currentTimeMillis();
