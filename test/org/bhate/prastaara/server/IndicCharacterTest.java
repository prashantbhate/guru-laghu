package org.bhate.prastaara.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.bhate.prastaara.server.IndicCharacter;
import org.bhate.prastaara.server.IndicLanguage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IndicCharacterTest {

  IndicCharacter c;
  private IndicLanguage iL = new IndicLanguage();

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  @Test
  public final void testSpace() {
    c = new IndicCharacter(iL, "      ");
    assertTrue(c.isSpace());
    assertEquals("      ",c.getMatch());
  }

  
  @Test
  @Ignore
  public final void testChars() {
    c = new IndicCharacter(iL, " ");
    assertFalse(c.isAkshara());
    assertTrue(c.isSpace());
    assertEquals(" ", c.getPrastaara());
    assertEquals(null, c.getPrevCharPrastaara());
    c = new IndicCharacter(iL, "a");
    assertTrue(c.isUnknownChar());
    assertEquals(" ", c.getPrastaara());
    assertEquals(null, c.getPrevCharPrastaara());
    c = new IndicCharacter(iL, "ಸ್ತಾ");
    assertTrue(c.isAkshara());
    assertTrue(c.isWattakshara());
    assertTrue(c.isAlpaPraana());
    assertTrue(c.isDeerghatalegeetu());
    assertTrue(c.isGuru());
    assertTrue(c.shouldPrevCharBeGuru());
    assertEquals("-", c.getPrastaara());
    assertEquals("-", c.getPrevCharPrastaara());
    c = new IndicCharacter(iL, "ಅ");
    assertTrue(c.isAkshara());
    assertTrue(c.isHrusvaSwara());
    assertTrue(c.isLaghu());
    assertEquals("U", c.getPrastaara());
    c = new IndicCharacter(iL, "ಊ");
    assertTrue(c.isGuru());
    assertTrue(c.isAkshara());
    assertTrue(c.isDeerghaSwara());
    c = new IndicCharacter(iL, "ಮ");
    assertTrue(c.isAkshara());
    assertTrue(c.isAnunaasika());
    assertTrue(c.isLaghu());
    c = new IndicCharacter(iL, "ಝ");
    assertTrue(c.isAkshara());
    assertTrue(c.isMahaPraana());
    assertTrue(c.isLaghu());
  }
}
