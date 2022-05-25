package com.example.starter.database;

//package providers;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import util.PropertiesFile;

import java.util.Arrays;

/**
 * Created by haitm on 19/03/2019.
 */
public class MongoProvider {
  private static String dbName;
  private static MongoClient mongo = null;
  public static Logger LOG = LoggerFactory.getLogger(MongoProvider.class);;
  private static MongoCredential credential;

  private static MongoClient createMongoClient(){

    MongoClient mongoClients = new MongoClient("localhost", 27017);
    System.out.println("create mongo client successfull");
      return mongoClients;
  }

  public static DB getDatabase(){
    mongo = createMongoClient();
    return mongo.getDB("admin");
  }
}
