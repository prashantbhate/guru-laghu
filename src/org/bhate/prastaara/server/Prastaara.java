package org.bhate.prastaara.server;


public class Prastaara {

  private IndicCharacter indicCharacter;
  private String prastaara;

  public Prastaara(IndicCharacter c, String prastaara) {
    this.indicCharacter = c;
    this.prastaara = prastaara;
  }

  @Override
  public String toString() {
    return String.format("Prastaara [c=%s, prastaara=%s]\n\n", indicCharacter, prastaara);
  }

  public IndicCharacter getIndicCharacter() {
    return indicCharacter;
  }

  public String getPrastaara() {
    return prastaara;
  }

  public int getValue() {
    return new PUtil().getPValue(prastaara);
  }

}
