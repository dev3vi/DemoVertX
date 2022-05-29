package com.example.starter.handler;

import com.example.starter.utils.FileExcelUtils;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import java.io.IOException;

public class ExcelGETHandlers implements Handler<RoutingContext> {
  @Override
  public void handle(RoutingContext routingContext) {
    try {
      FileExcelUtils.saveFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    HttpServerResponse response =routingContext.response();
    response.end("ok");
  }
}
