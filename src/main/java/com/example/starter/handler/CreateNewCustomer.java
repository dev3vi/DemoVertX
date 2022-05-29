package com.example.starter.handler;

import com.example.starter.model.Customer;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public class CreateNewCustomer implements Handler<RoutingContext> {


  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    HttpServerRequest request = routingContext.request();

    response.putHeader("content-type", "application/json;charset=UTF-8");
    try {
      Customer customer = Json.decodeValue(routingContext.getBody(),Customer.class);
      System.out.println(routingContext.getBody());
//      System.out.println(customer.getAddress().getAddresss());


      response.end("true");
    } catch (Exception ex) {
      response.end(ex.getMessage());
    }
  }
}
