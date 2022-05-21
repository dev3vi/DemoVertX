package com.example.starter;

import com.example.starter.verticle.CustomerVerticle;
import io.vertx.core.Vertx;

public class App {
//triển khai verticle "CustomerVerticle()"
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new CustomerVerticle());
  }
}
