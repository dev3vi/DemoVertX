package com.example.starter.handler;

import com.example.starter.model.Customer;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.util.HashMap;

public class GetAllEmployees implements Handler<RoutingContext> {

  private static HashMap<Integer, Customer> custumers = new HashMap<>();

  public GetAllEmployees() {
    custumers.put(1,new Customer(1,"thao","thao@gmail"));
    custumers.put(2,new Customer(2,"thao2","thao2@gmail"));
    custumers.put(3,new Customer(3,"thao3","thao3@gmail"));
  }

  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response=routingContext.response();
    HttpServerRequest request = routingContext.request();
    response.putHeader("content-type","application/json;charset=UTF-8");
    response.end(Json.encodePrettily(custumers));
  }

}
