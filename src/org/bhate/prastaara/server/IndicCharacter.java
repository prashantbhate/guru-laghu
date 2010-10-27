package org.bhate.prastaara.server;

import java.util.ArrayList;


public class IndicCharacter {

  String match;
  String akshara;
  String hrusvaSwara;
  String deerghaSwara;
  String yogavaahaka;
  String wattakshara;
  String alpaPraana;
  String mahaPraana;
  String anunaasika;
  String avargeeya;
  String hrusvatalegeetu;
  String deerghatalegeetu;
  String yogavaahakatalegeetu;
  String veraama;
  String space;
  String newline;
  String unknownChar;

  public IndicCharacter(String match, String akshara, String hrusvaSwara, String deerghaSwara, String yogavaahaka, String wattakshara, String alpaPraana, String mahaPraana, String anunaasika, String avargeeya, String hrusvatalegeetu, String deerghatalegeetu, String yogavaahakatalegeetu, String veraama, String space, String newline, String unknown) {
    super();
    copy(match, akshara, hrusvaSwara, deerghaSwara, yogavaahaka, wattakshara, alpaPraana, mahaPraana, anunaasika, avargeeya, hrusvatalegeetu, deerghatalegeetu, yogavaahakatalegeetu, veraama, space, newline, unknown);
  }

  private void copy(String match, String akshara, String hrusvaSwara, String deerghaSwara, String yogavaahaka, String wattakshara, String alpaPraana, String mahaPraana, String anunaasika, String avargeeya, String hrusvatalegeetu, String deerghatalegeetu, String yogavaahakatalegeetu, String veraama, String space, String newline, String unknownChar) {
    this.match = match;
    this.akshara = akshara;
    this.hrusvaSwara = hrusvaSwara;
    this.deerghaSwara = deerghaSwara;
    this.yogavaahaka = yogavaahaka;
    this.wattakshara = wattakshara;
    this.alpaPraana = alpaPraana;
    this.mahaPraana = mahaPraana;
    this.anunaasika = anunaasika;
    this.avargeeya = avargeeya;
    this.hrusvatalegeetu = hrusvatalegeetu;
    this.deerghatalegeetu = deerghatalegeetu;
    this.yogavaahakatalegeetu = yogavaahakatalegeetu;
    this.veraama = veraama;
    this.space = space;
    this.newline = newline;
    this.unknownChar = unknownChar;
  }

  public boolean isAkshara() {
    return akshara != null;
  }

  public boolean isHrusvaSwara() {
    return hrusvaSwara != null;
  }

  public boolean isDeerghaSwara() {
    return deerghaSwara != null;
  }

  public boolean isYogavaahaka() {
    return yogavaahaka != null;
  }

  public boolean isWattakshara() {
    return wattakshara != null;
  }

  public boolean isAlpaPraana() {
    return alpaPraana != null;
  }

  public boolean isMahaPraana() {
    return mahaPraana != null;
  }

  public boolean isAnunaasika() {
    return anunaasika != null;
  }

  public boolean isAvargeeya() {
    return avargeeya != null;
  }

  public boolean isHrusvatalegeetu() {
    return hrusvatalegeetu != null;
  }

  public boolean isDeerghatalegeetu() {
    return deerghatalegeetu != null;
  }

  public boolean isYogavaahakatalegeetu() {
    return yogavaahakatalegeetu != null;
  }

  public boolean isVeraama() {
    return veraama != null;
  }

  public boolean isSpace() {
    return space != null;
  }

  public boolean isNewline() {
    return newline != null;
  }

  public boolean isUnknownChar() {
    return unknownChar != null;
  }

  public IndicCharacter(IndicLanguage iL, String string) {
    IndicUtil indicUtil = new IndicUtil(iL);
    ArrayList<IndicCharacter> charList = new ArrayList<IndicCharacter>();
    indicUtil.parse(string, charList);
    if (charList.size() != 1)
      throw new IllegalArgumentException("Too big a char");
    IndicCharacter ic = charList.get(0);
    copy(ic);
  }

  private void copy(IndicCharacter ic) {
    copy(ic.match, ic.akshara, ic.hrusvaSwara, ic.deerghaSwara, ic.yogavaahaka, ic.wattakshara, ic.alpaPraana, ic.mahaPraana, ic.anunaasika, ic.avargeeya, ic.hrusvatalegeetu, ic.deerghatalegeetu, ic.yogavaahakatalegeetu, ic.veraama, ic.space, ic.newline, ic.unknownChar);

  }

  public boolean isGuru() {
    return isDeerghaSwara() || isYogavaahaka() || isDeerghatalegeetu() || isYogavaahakatalegeetu();
  }

  public boolean shouldPrevCharBeGuru() {
    return isWattakshara() || isVeraama();
  }

  public boolean isLaghu() {
    return !isGuru() && !isVeraama();
  }

  public String getPrastaara() {
    if(isAkshara()){
    if ( isGuru())
      return "-";
    if (isLaghu())
      return "U";
    }
      return " ";
  }

  public int getValue() {
    String p = getPrastaara();
    return new PUtil().getPValue(p);
  }

  
  public String getPrevCharPrastaara() {
    if (shouldPrevCharBeGuru())
      return "-";
    return null;
  }

  public String toString() {
    return getMatch();
  }

  public String toString1() {
    StringBuilder builder = new StringBuilder();
    builder.append("IndicCharacter [akshara:");
    builder.append(akshara);
    builder.append("-hrusvaSwara:");
    builder.append(hrusvaSwara);
    builder.append("-deerghaSwara:");
    builder.append(deerghaSwara);
    builder.append("-yogavaahaka:");
    builder.append(yogavaahaka);
    builder.append("-wattakshara:");
    builder.append(wattakshara);
    builder.append("-alpaPraana:");
    builder.append(alpaPraana);
    builder.append("-mahaPraana:");
    builder.append(mahaPraana);
    builder.append("-anunaasika:");
    builder.append(anunaasika);
    builder.append("-avargeeya:");
    builder.append(avargeeya);
    builder.append("-hrusvatalegeetu:");
    builder.append(hrusvatalegeetu);
    builder.append("-deerghatalegeetu:");
    builder.append(deerghatalegeetu);
    builder.append("-yogavaahakatalegeetu:");
    builder.append(yogavaahakatalegeetu);
    builder.append("-veraama:");
    builder.append(veraama);
    builder.append("-space:");
    builder.append(space);
    builder.append("-newline:");
    builder.append(newline);
    builder.append("-unknownChar:");
    builder.append(unknownChar);
    builder.append("]\n");
    return builder.toString();
  }

  public String getMatch() {
    return match;
  }

}
