package com.example.starter.database;

import com.mongodb.reactivestreams.client.MongoClients;
import io.vertx.core.Handler;
//import io.vertx.core.Vertx;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.RoutingContext;

import static io.vertx.core.Vertx.vertx;

public class ConnectDb implements Handler<RoutingContext> {

  public void exampleCreateDefault(Vertx vertx, JsonObject config) {
    MongoClient client = MongoClient.createShared(vertx, config);
  }

  public void example8(MongoClient mongoClient) {
    // empty query = match any
    JsonObject query = new JsonObject();
    mongoClient.find("books", query, res -> {
      if (res.succeeded()) {
        for (JsonObject json : res.result()) {
          System.out.println(json.encodePrettily());
        }
      } else {
        res.cause().printStackTrace();
      }
    });
  }

  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    MongoClient mongoClient = MongoClient.create(vertx(), new JsonObject()
      .put ("uri", "mongodb+srv://admin:admin2@cluster0.ekrgi.mongodb.net/thaotest?retryWrites=true&w=majority")
      .put ("db_name", "thaotest"));
//    MongoClient mongo = mongo = MongoClient.createShared(vertx(), config());
    JsonObject query = new JsonObject();
    mongoClient.find("name", query, res -> {
      if (res.succeeded()) {
        for (JsonObject json : res.result()) {
          System.out.println(json.encodePrettily());
        }
      } else {
        res.cause().printStackTrace();
      }
      response.end("ok");
    });
  }
}
