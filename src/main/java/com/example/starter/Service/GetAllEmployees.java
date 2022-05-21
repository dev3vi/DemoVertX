package com.example.starter.Service;

import com.example.starter.model.Customer;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import java.util.HashMap;

public class GetAllEmployees implements Handler<RoutingContext> {
  public GetAllEmployees() {
  }

  private HashMap<Integer, Customer> custumers = new HashMap<>();

  public void createExData(){
    custumers.put(1,new Customer(1,"thao","thao@gmail"));
    custumers.put(2,new Customer(2,"thao2","thao2@gmail"));
    custumers.put(3,new Customer(3,"thao3","thao3@gmail"));

  }

  @Override
  public void handle(RoutingContext routingContext) {
    createExData();
    HttpServerResponse response=routingContext.response();
    HttpServerRequest request = routingContext.request();
    response.putHeader("content-type","application/json;charset=UTF-8");
    response.end(String.valueOf(custumers.values()));
  }



}
