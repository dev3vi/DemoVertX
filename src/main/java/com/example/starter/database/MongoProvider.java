package com.example.starter.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class MongoProvider {
  private static MongoClient mongo = null;
  private static MongoCredential credential;

  private static MongoClient createMongoClient(){
    MongoClient mongoClient = new MongoClient("localhost", Integer.parseInt("27017"));
    return mongoClient;
  }

  public static DB getDatabase(){
    if(mongo == null)mongo = createMongoClient();
    String dbName = "testOne";
    return mongo.getDB(dbName);
  }
}
