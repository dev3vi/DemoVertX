package com.example.starter.model;

public class Address {

  private int id;

  private String addresss;

  public Address(int id, String addresss) {
    this.id = id;
    this.addresss = addresss;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddresss() {
    return addresss;
  }

  public void setAddresss(String addresss) {
    this.addresss = addresss;
  }
}
