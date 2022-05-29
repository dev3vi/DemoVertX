package com.example.starter.database;

//package providers;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by haitm on 19/03/2019.
 */
public class MongoProvider {
  private static MongoClient mongo = null;
  public static Logger LOG = LoggerFactory.getLogger(MongoProvider.class);;
  private static MongoCredential credential;

  private static MongoClient createMongoClient(){
    MongoClient mongoClient = new MongoClient("localhost", Integer.parseInt("20117"));
    return mongoClient;
  }

  public static DB getDatabase(){
    if(mongo == null)mongo = createMongoClient();
    String dbName = "testOne";
    return mongo.getDB(dbName);
  }
}
