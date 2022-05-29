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
//public class ReportTVVAssignGETHandlers implements Handler<RoutingContext> {
//  public static Logger LOG = LoggerFactory.getLogger(ReportTVVAssignGETHandlers.class);
//
//  public ReportTVVAssignGETHandlers() {
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
//      String stringStartDate = request.getParam("start_date");
//      String stringEndDate = request.getParam("end_date");
//      String botId = request.getParam("bot_id");
//      if (botId == null) {
//        botId = PropertiesFile.getInstance().getConfig(PropertiesFile.FileConfig.MAIN, "botId");
//      }
//      LOG.info(stringStartDate);
//      LOG.info(stringEndDate);
//      String targetFile = "data/tvv-assign" + botId + stringStartDate + "-" + stringEndDate +".xlsx";
//      if (stringEndDate == null || stringStartDate == null) {
//        ResponseProvider.makeSuccessResponse(response, "Require params start_date, end_date");
//        return;
//      }
//      Date startDate = formatDate.parse(stringStartDate);
//      Date endDate = formatDate.parse(stringEndDate);
//      List<List<String>> data = ReportUtil.getDataReportTVVAssign(botId, startDate, DateUtil.addDays(endDate, 1));
//
//      LOG.info("total record: " + data.size());
//      String fileTemplate = "report_tvv_assign.xlsx";
//      String nameSheet = "Sheet1";
//      String title = "Từ " + stringStartDate + " đến " + stringEndDate;
//      FileExcelUtils.saveFile(fileTemplate, nameSheet, targetFile, 6, data, title);
//      long endTime = System.currentTimeMillis();
//      LOG.info("total time:" + (endTime - startTime));
//      ResponseProvider.returnFileResponse(response, targetFile);
//
//    } catch (ParseException e) {
//      ResponseProvider.makeSuccessResponse(response, "Invalid date");
//    } catch (Exception e) {
//      LOG.error("JSON SYNTAX ERROR");
//      e.printStackTrace();
//      ResponseProvider.makeSuccessResponse(response, "{}");
//    }
//  }
//}
