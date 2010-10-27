package org.bhate.prastaara.server;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndicUtil {

  private IndicLanguage iL;

  public IndicUtil(IndicLanguage iL) {
    this.iL = iL;
  }

  private Pattern getPattern() {
    String hrusvaSwaras = iL.getHrusvaSwaras();
    String deerghaSwaras = iL.deerghaSwaras();
    String yogavaahakas = iL.getYogaWahakas();
    String alpaPraanas = iL.getAlpaPraanas();
    String mahaaPraanas = iL.getMahaaPraanas();
    String anunaasikas = iL.getAnuNaasikaas();
    String avargiyaVyanjanas = iL.getAvargiyaVyanjanas();
    String veraama = iL.getVeraama();
    String hrusvaTalegeetu = iL.getHrusvaTalegeetus();
    String deerghaTalegeetu = iL.getDeerghaTalegeetu();
    String swara = "(?:(?:([" + hrusvaSwaras + "])" + "|" + "([" + deerghaSwaras + "]))([" + yogavaahakas + "])?)";
    String swaratalegeetu = "(?:([" + hrusvaTalegeetu + "])|([" + deerghaTalegeetu + "]))?";
    String yogatalegeetu = "([" + yogavaahakas + "])?";
    String swarayogatalegetu = "(?:" + swaratalegeetu + yogatalegeetu + ")";
    String veramaTalegeetu = "([" + veraama + "])";
    String talegeetu = "(?:" + veramaTalegeetu + "|" + swarayogatalegetu + ")";
    String newLine = "((?:\r?\n)+)";
    String space = "([ ]+)";
    String vyanjanasamooha = alpaPraanas + mahaaPraanas + anunaasikas + avargiyaVyanjanas;
    String wattu = "((?:[" + vyanjanasamooha + "]" + veraama + "){1,4})?";
    String vyanjana = "(?:([" + alpaPraanas + "])|([" + mahaaPraanas + "])|([" + anunaasikas + "])|([" + avargiyaVyanjanas + "]))";
    String vyanjanaakshara = "(?:" + wattu + vyanjana + talegeetu + ")";
    String unknown = "(.)";
    String akshara = "("+swara + "|" + vyanjanaakshara + ")|" + space + "|" + newLine + "|" + unknown;
    System.out.println(akshara);
    Pattern pattern = Pattern.compile(akshara);
    return pattern;
  }

  public void parse(String string, ArrayList<IndicCharacter> charList) {
    charList.clear();
    Pattern pattern = getPattern();
    Matcher m = pattern.matcher(string);
    while (m.find()) {
      IndicCharacter c = getIndicChar(m);
      charList.add(c);
    }
  }

  private IndicCharacter getIndicChar(Matcher m) {
    int i = 0;
    String match = m.group(i++);// 0
    String akshara = m.group(i++);// 1
    String hrusvaSwara = m.group(i++);// 2
    String deerghaSwara = m.group(i++);// 3
    String yogavaahaka = m.group(i++);// 4
    String wattakshara = m.group(i++);// 5
    String alpaPraana = m.group(i++);// 6
    String mahaPraana = m.group(i++);// 7
    String anunaasika = m.group(i++);// 8
    String avargeeya = m.group(i++);// 9
    String veraama = m.group(i++);// 10
    String hrusvatalegeetu = m.group(i++);// 11
    String deerghatalegeetu = m.group(i++);// 12
    String yogavaahakatalegeetu = m.group(i++);// 13
    String space = m.group(i++);// 14
    String newline = m.group(i++);// 15
    String unknown = m.group(i++);// 16
    IndicCharacter c = new IndicCharacter(match,akshara, hrusvaSwara, deerghaSwara, yogavaahaka, wattakshara, alpaPraana, mahaPraana, anunaasika, avargeeya, hrusvatalegeetu, deerghatalegeetu, yogavaahakatalegeetu, veraama, space, newline, unknown);
    return c;
  }

}
