package com.example.starter.Handler;

import com.example.starter.database.ConnectDb;
import com.example.starter.database.MongoProvider;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentHandlers implements Handler<RoutingContext> {
  @Override
  public void handle(RoutingContext routingContext) {
    BasicDBObject sqlQuery = new BasicDBObject();
    sqlQuery.put("name","thaolv");
    DBCollection collection = MongoProvider.getDatabase().getCollection("student");
    DBCursor cursor;
    List<Map<String, Object>> data = new ArrayList<>();
    cursor = collection.find(sqlQuery);
    while ((cursor.hasNext())){
      data.add((Map<String, Object>)cursor.next());
    }
    System.out.println(data);
  }
}
