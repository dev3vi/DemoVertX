package com.example.starter.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.reactivestreams.client.MongoClients;
import io.vertx.core.Handler;
//import io.vertx.core.Vertx;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.RoutingContext;

import java.util.*;

import static io.vertx.core.Vertx.vertx;

public class ConnectDb implements Handler<RoutingContext> {

  @Override
  public void handle(RoutingContext routingContext) {
    DBCollection collection = MongoProvider.getDatabase().getCollection("student");
    BasicDBObject sqlQuery = new BasicDBObject();
    sqlQuery.put("name","thaolv");
    DBCursor cursor;
    cursor = collection.find(sqlQuery);
    HttpServerResponse response = routingContext.response();
    while(cursor.hasNext()) {
      System.out.println(cursor.next());
    }
    response.end(Json.encodePrettily("ok"));
  }
}
