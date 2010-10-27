package org.bhate.prastaara.server;

import java.util.ArrayList;
import java.util.ListIterator;

import org.bhate.prastaara.shared.Akshara;

public class IndicString {

  private ArrayList<IndicCharacter> charList = new ArrayList<IndicCharacter>();

  public IndicString(IndicUtil indicUtil, String string) {
    indicUtil.parse(string, charList);
  }

  public IndicString(IndicLanguage iL, String string) {
    IndicUtil indicUtil = new IndicUtil(iL);
    indicUtil.parse(string, charList);
  }

  public IndicCharacter getCharAt(int i) {
    return charList.get(i);
  }

  public ArrayList<Akshara> getPrastaredAksharas() {
    ArrayList<Prastaara> prastaaras = getPrastaaras();
    ArrayList<Akshara> a = new ArrayList<Akshara>();
    for (Prastaara p : prastaaras) {
      IndicCharacter c = p.getIndicCharacter();
      String ps = p.getPrastaara();
      a.add(new Akshara(c.getMatch(), ps, p.getValue()));
    }
    return a;
  }

  public ArrayList<Prastaara> getPrastaaras() {
    ArrayList<Prastaara> pl = new ArrayList<Prastaara>();
    int i = 0;
    for (IndicCharacter c : charList) {
      pl.add(new Prastaara(c, c.getPrastaara()));
      if (pl.size() > 1 && c.shouldPrevCharBeGuru()) {
        int prevIndx = getPrevChar(i);
        IndicCharacter p = pl.get(prevIndx).getIndicCharacter();
        if (p.isLaghu())
          pl.set(prevIndx, new Prastaara(p, c.getPrevCharPrastaara()));
      }
      i++;
    }
    return pl;
  }

  private int getPrevChar(int i) {
    ListIterator<IndicCharacter> itr = charList.listIterator(i);
    while (itr.previousIndex() != -1 && !itr.previous().isAkshara())
      ;
    return itr.nextIndex();
  }

  @Override
  public String toString() {
    return "IndicCharacters [charList=" + charList + "]";
  }

}
