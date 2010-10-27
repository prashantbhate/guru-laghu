package org.bhate.prastaara.server;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.bhate.prastaara.server.IndicCharacter;
import org.bhate.prastaara.server.IndicLanguage;
import org.bhate.prastaara.server.IndicString;
import org.bhate.prastaara.server.Prastaara;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IndicStringTest {

	private IndicLanguage iL;
	IndicString is;
	String s;

	@Before
	public void setUp() throws Exception {
    s = "ಅಈಅಂಅಃಕಖಙಯಹ್ ಹ್ಕ\nಕಕಾಕಿಕೀಕುಕೂಕೆಕೇಕೈಕೊಕೋಕೌ\nಲ್ಮ್ನಕ್ಷ್ಮಿ ಮೇಲ್ಮ್ನವಿ               a ವಿ ಕ್ಲ್ಮ್ವಸ್ತರ್ಕಠ್ರತ್ರ್ಯಜ್ಞಸ್ತ್ಕತ್ರಿ";
		getIS(s);
	}

  private void getIS(String s) {
    iL = new IndicLanguage();
		is = new IndicString(iL,s);
  }

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Ignore
	public void t() {
    System.out.println(s);
    System.out.println(s.replaceAll("","|"));
		System.out.println(is);
		System.out.println(is.getPrastaaras());
		String res = "ಅ|ಈ|ಅಂ|ಅಃ|ಕ|ಖ|ಙ|ಯ|ಹ್| |ಹ್ಕ|\n|ಕ|ಕಾ|ಕಿ|ಕೀ|ಕು|ಕೂ|ಕೆ|ಕೇ|ಕೈ|ಕೊ|ಕೋ|ಕೌ|\n|ಲ್ಮ್ನ|ಕ್ಷ್ಮಿ| |ಮೇ|ಲ್ಮ್ನ|ವಿ|               |a| |ವಿ| |ಕ್ಲ್ಮ್ವ|ಸ್ತ|ರ್ಕ|ಠ್ರ|ತ್ರ್ಯ|ಜ್ಞ|ಸ್ತ್ಕ|ತ್ರಿ";
		String[] split = res.split("[|]");
		int i=0;
		for (String string : split) {
			System.out.println(i);
			assertEquals(new IndicCharacter(iL,string).toString(),is.getCharAt(i++).toString());
		}
	}
	@Test
	public void te(){
    String ಶರ_ಷಟ್ಪದಿ = "ಈಶನ ಕರುಣೆಯ\nನಾಶಿಸು ವಿನಯದಿ\nದಾಸನ ಹಾಗೆಯೆ ನೀಮನ ವೇ\nಕ್ಲೇಶದ ವಿಧವಿಧ\nಪಾಶದ ಹರಿದುವಿ\nಲಾಸದಿ ಸತ್ಯವ ತಿಳಿಯನ            ವೇ";
    String ಕುಸುಮ_ಷಟ್ಪದಿ = "ನಾಡುಮನ ಸಿಜನೊಲವಿ\nನಾಡುವೆಡೆ ಸಂತತಂ\nಬೀಡುರತಿ ಪತಿಗೆಸತ ತನಿಧಾನ ವು\nನೋಡಿದನಿ ಮಿಷಪತಿಗೆ\nಮಾಡುವುದು ವಿನಯವನು\nನಾಡಾದಿ ಯವರ್ಗೆಬ ಣ್ಣಿಸಲುಮೊ ಗ್ಗೇ";
    String ಭೋಗ_ಷಟ್ಪದಿ = "ತಿರುಕ ನೋರ್ವ ನೂರ  ಮುಂದೆ\nಮುರುಕು  ಧರ್ಮ ಶಾಲೆ ಯಲ್ಲಿ\nವೊರಗಿ ರುತ್ತ ಲೊಂದು  ಕನಸ ಕಂಡ ನೆಂತ ನೆ\nಪುರದ  ರಾಜ ಸತ್ತ ನವಗೆ\nವರಕು ಮಾರ ರಿಲ್ಲ ದಿರಲು\nಕರಿಯ  ಕೈಗೆ  ಕುಸುಮ  ಮಾಲೆ ಯಿತ್ತು  ಪುರದೊ ಳು";
    String ಭಾಮಿನೀ_ಷಟ್ಪದಿ = "ವೇದ ಪುರುಷನ  ಸುತನ ಸುತನಸ\nಹೋದ ರನಹೆಮ್ಮಗನ ಮಗನತ\nಳೋದ ರಿಯಮಾ ತುಳನ ಮಾವನ ನತುಳ ಭುಜಬಲ ದಿ\nಕಾದು ಗೆಲಿದನ ನಣ್ಣ ನವ್ವೆಯ \nನಾದಿ ನಿಯಜಠ ರದಲಿ ಜನಿಸಿದ\nನಾದಿ ಮೂರುತಿ  ಸಲಹೊ ಗದುಗಿನ  ವೀರ ನಾರಯ ಣ";
    String ವಾರ್ಧಕ_ಷಟ್ಪದಿ = "ಬಲ್ಗಯ್ಯ ನೃಪರಂಜಿ ತಡೆಯದೆರ ಘೂದ್ವಹನ\nಸೊಲ್ಗೇಳಿ ನಮಿಸಲಿಳೆ ಯೊಳ್ ಚರಿಸು ತಧ್ವರದ\nನಲ್ಗುದುರೆ ಬಂದು ವಾ ಲ್ಮೀಕಿಯನಿ ಜಾಶ್ರಮದ ವಿನಿಯೋಗ ದು ಪವನದೊ ಳು\nಪುಲ್ಗಳಪ ಸುರ್ಗೆಳಸಿ ಪೊಕ್ಕಡಾ ತೋಟಗಾ\nವಲ್ಗೆತ ನ್ನೊಡನಾಡಿ ಗಳಕೂಡಿ ಲೀಲೆಮಿಗೆ\nಬಿಲ್ಗೊಂಡು ನಡೆತಂದ ವಂಕಂಡ ನರ್ಚಿತಸು ವಾಜಿಯಂ ವೀರಲವ ನು";
    String ಪರಿವರ್ಧಿನೀ_ಷಟ್ಪದಿ = "ಸ್ಮರವಾ ಜ್ಯದಮೈ ಸಿರಿಶೃಂ ಗಾರದ\nಶರನಿಧಿ ರತಿನಾ ಟ್ಯದರಂ ಗಸ್ಥಳ\nವಿರಹದ ನೆಲೆವೀ ಡೋಪರ ಕೂರಾ ಟದಕೊಸ ರಿನಗೊತ್ತು\nಸರಸರ ಸಂತವ ಣೆಯಮನೆ ಸುಗ್ಗಿಯ\nಪೊರವಾ ಗರಭಾ ವಾಲಯ ವಪ್ಪಂ\nತಿರೆಪೇ ರೆದನಮ ರುಕವನು ದೇಪಮ ಹೀಪತಿ ಕನ್ನಡಿ ಸಿ";
    String anj = "ರಂಭಾ ಬೇಡ ಜಂಬ\nಜಂಬ ಗಿಂಬ ಬೇಡ ರಂಭಾ\nಸೊಳ್ಳೆ ಇರದ ನಾಡಿಗೂ ತಪ್ಪಿಲ್ಲ ಸೊಳ್ಳೆ ಪರದೇಶಿ ಕಾಟ";

    getIS(anj );
	  System.out.println(is.getPrastaaras());
	}
	
	@Test
	public void test_prastara_starting_wattaksh(){
	  getIS("ಸ್ಮರ");
	  ArrayList<Prastaara> p = is.getPrastaaras();
	  assertEquals(p.size(), 2);
	  assertEquals("U",p.get(0).getPrastaara());
	  assertEquals("U",p.get(1).getPrastaara());
	}
  
  @Test
  public void test_prastara_ending_yanjan(){
    getIS("ಮನದೊಳ್");
    ArrayList<Prastaara> p = is.getPrastaaras();
    assertEquals(p.size(), 4);
    assertEquals("U",p.get(0).getPrastaara());
    assertEquals("U",p.get(1).getPrastaara());
    assertEquals("-",p.get(2).getPrastaara());
    assertEquals(" ",p.get(3).getPrastaara());

    getIS("ಜೋಗಪ್");
    p = is.getPrastaaras();
    assertEquals(p.size(), 3);
    assertEquals("-",p.get(0).getPrastaara());
    assertEquals("-",p.get(1).getPrastaara());
    assertEquals(" ",p.get(2).getPrastaara());
  }
	

}
