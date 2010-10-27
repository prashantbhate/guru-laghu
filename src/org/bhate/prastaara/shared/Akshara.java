package org.bhate.prastaara.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Akshara implements IsSerializable {
  /**
   * 
   */
  private String akshara;
  private String prasaara;
  private int value;

  public Akshara() {
  }

  public Akshara(String akshara, String prasaara, int value) {
    this.akshara = akshara;
    this.prasaara = prasaara;
    this.value=value;
  }

  public String getAkshara() {
    return akshara;
  }

  public String getPrastaara() {
    return prasaara;
  }

  public int getValue() {
    return value;
  }
}
