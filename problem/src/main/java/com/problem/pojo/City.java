package com.problem.pojo;


import java.io.Serializable;

public class City implements Serializable {

  private int city_Id;
  private String city_Name;
  private int count;
  private String areainfo_Id;

  public int getCity_Id() {
    return this.city_Id;
  }

  public void setCity_Id(final int city_Id) {
    this.city_Id = city_Id;
  }

  public String getCity_Name() {
    return this.city_Name;
  }

  public void setCity_Name(final String city_Name) {
    this.city_Name = city_Name;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(final int count) {
    this.count = count;
  }

  public String getAreainfo_Id() {
    return this.areainfo_Id;
  }

  public void setAreainfo_Id(final String areainfo_Id) {
    this.areainfo_Id = areainfo_Id;
  }

  @Override
  public String toString() {
    return "City{" +
            "city_Id=" + city_Id +
            ", city_Name='" + city_Name + '\'' +
            ", count=" + count +
            ", areainfo_Id='" + areainfo_Id + '\'' +
            '}';
  }
}
