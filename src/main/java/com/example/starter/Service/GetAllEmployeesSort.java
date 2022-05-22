package com.example.starter.Service;

import com.example.starter.model.Customer;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GetAllEmployeesSort implements Handler<RoutingContext> {

  private List<Customer> custumerss= new ArrayList<>();

  public void createExData(){
    custumerss.add(new Customer(1,"thaoluong","thao@gmail"));
    custumerss.add(new Customer(2,"thaoluong","thao@gmail"));
    custumerss.add(new Customer(3,"thaoluong","thao@gmail"));
  }
  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();

//    String sort = routingContext.request().getParam("sort");
    createExData();
//    List<Customer> sortedKeys = new ArrayList(custumers.keySet());
//    Collections.sort(sortedKeys);
//    if (sort.equalsIgnoreCase("desc")){
//      Collections.reverse(sortedKeys);
//    }

//    ArrayList sortCustomer = new ArrayList<Customer>();
//    sortedKeys.forEach(e->{
//      sortCustomer.add(custumers.get(e));
//    });
    response.putHeader("content-type","application/json;charset=UTF-8")
      .end(Json.encodePrettily(custumerss));
  }
}
