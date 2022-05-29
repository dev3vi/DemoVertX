package com.example.starter.handler;

import com.example.starter.database.MongoProvider;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentGETHandlers implements Handler<RoutingContext> {
  @Override
  public void handle(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
      BasicDBObject sqlQuery = new BasicDBObject();
    sqlQuery.put("name","thaolv");
    DBCollection collection = MongoProvider.getDatabase().getCollection("student");
    DBCursor cursor;
    List<Map<String, Object>> data = new ArrayList<>();
    cursor = collection.find(sqlQuery);
    while ((cursor.hasNext())){
      data.add((Map<String, Object>)cursor.next());
    }

    data.forEach(e->{
      ObjectId id = (ObjectId) e.get("_id");
      System.out.println(id.getTimestamp());
    });
    response.end(Json.encodePrettily(data));
  }
}
