package org.bhate.prastaara.server;

public class PUtil {
  public PUtil() {
  }

  public int getPValue(String p) {
    if ("U".equals(p))
      return 1;
    if ("-".equals(p))
      return 2;
    return 0;
  }

}
