package com.goods.pojo;


import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class TCategorie  implements Serializable {
  //必须实现可序列化接口，要在网络上传输
 @Field
  private Integer categorie_id;
  private String categorie_name;
  private String categorie_shorthand;


  public Integer getCategorie_id() {
    return categorie_id;
  }

  public void setCategorie_id(Integer categorie_id) {
    this.categorie_id = categorie_id;
  }

  public String getCategorie_name() {
    return categorie_name;
  }

  public void setCategorie_name(String categorie_name) {
    this.categorie_name = categorie_name;
  }

  public String getCategorie_shorthand() {
    return categorie_shorthand;
  }

  public void setCategorie_shorthand(String categorie_shorthand) {
    this.categorie_shorthand = categorie_shorthand;
  }
}
