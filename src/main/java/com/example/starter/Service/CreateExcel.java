package com.example.starter.Service;

import com.example.starter.utils.FileExcelUtils;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateExcel implements Handler<RoutingContext> {
  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response =  routingContext.response();
    List<String> a = new ArrayList<>();
    a.add("ok");
    a.add("ad");
    List<List<String>> data  = new ArrayList<>();
    data.add(a);
    try {
      FileInputStream inputStream = new FileInputStream("C:\\Users\\BVCN 88\\Downloads\\test.xlsx");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
//    try {
////      FileExcelUtils.saveFile("C:\\Users\\BVCN 88\\Downloads\\test.xlsx","Sheet1","testExcel",1,data);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    response.end("ok");
  }
}
