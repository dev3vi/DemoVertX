package com.example.starter.database;


import com.mongodb.MongoClient;

public class ConnectDb {


  public static MongoClient createMongoclient(){
//    MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",Integer.parseInt("20117")));
    MongoClient mongoClient = new MongoClient("localhost", Integer.parseInt("20117"));
    return mongoClient;
  }

}
