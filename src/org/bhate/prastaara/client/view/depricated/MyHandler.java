package org.bhate.prastaara.client.view.depricated;

import java.util.HashMap;
import java.util.List;

import org.bhate.prastaara.client.GreetingServiceAsync;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RichTextArea;

class MyHandler implements ClickHandler, KeyUpHandler, KeyPressHandler {
  private GreetingServiceAsync greetingService;
  private RichTextArea transltextarea;
  private FlexTable resultings;
  private List<Akshara> result;
  private FlexTable ganawings;
  private static HashMap<String, String> GAN_MAP = new HashMap<String, String>() {
    {
      put("U--", "ಯ");
      put("---", "ಮ");
      put("--U", "ತ");
      put("-U-", "ರ");
      put("U-U", "ಜ");
      put("-UU", "ಭ");
      put("UUU", "ನ");
      put("UU-", "ಸ");
    }
  };

  public MyHandler(GreetingServiceAsync greetingService, RichTextArea transltextarea, FlexTable resultings, FlexTable ganawings) {
    super();
    this.greetingService = greetingService;
    this.transltextarea = transltextarea;
    this.resultings = resultings;
    this.ganawings = ganawings;
  }

  public void onClick(ClickEvent event) {
    sendNameToServer();
  }

  public void onKeyPress(KeyPressEvent event) {
    char c = event.getCharCode();
    if (c == ' ') {
      // sendNameToServer();
    }
  }

  public void onKeyUp(KeyUpEvent event) {
    int key = event.getNativeKeyCode();
    System.out.println(key);
    if (key == KeyCodes.KEY_ENTER) {
      // sendNameToServer();
    }
  }

  private void sendNameToServer() {
    Timer t = new Timer() {

      @Override
      public void run() {
        sendAfterAWhile();
      }
    };
    t.schedule(100);
  }

  private void sendAfterAWhile() {
    String textToServer = transltextarea.getText();
    greetingService.greetServer(textToServer, new AsyncCallback<List<Akshara>>() {

      public void onFailure(Throwable caught) {
      }

      public void onSuccess(List<Akshara> res) {
        gurulaghu(res);
        ganawing(res);
      }

      private void ganawing(List<Akshara> res) {
        ganawings.clear(true);
        int count = 0;
        int r = 0;
        String p = "";
        String a = "";
        int c = 0;
        for (Akshara e : result) {
          String akshara = e.getAkshara();
          int v = e.getValue();
          a += akshara;
          if (v != 0) {
            count++;
            p += e.getPrastaara();
          }
          if (count == 3) {
            setText(ganawings, r, c, GAN_MAP.get(p) + " " + p, "gurulaghucell");
            setText(ganawings, r + 1, c, a, "aksharacell");
            c++;
            count = 0;
            a = "";
            p = "";
          }
          if (akshara.contains("\n")) {
            c = 0;
            r += 2;
          }
        }
        if (count != 3) {
          c++;
          setText(ganawings, r, c, p, "gurulaghucell");
          setText(ganawings, r + 1, c, a, "aksharacell");
        }
      }

      private void gurulaghu(List<Akshara> res) {
        resultings.clear(true);
        result = res;
        FlexTable ft = getFT(0, 0, 0);
        int row = 0;
        int c = 0;
        for (Akshara e : result) {
          String akshara = e.getAkshara();
          String text = e.getPrastaara();
          if (akshara.contains("\n")) {
            c = 0;
            resultings.setWidget(row++, 0, ft);
            ft = getFT(0, 0, 0);
          } else {
            akshara = akshara.replaceAll(" ", "&nbsp;");
            int r = 0;
            setText(ft, r++, c, text, "gurulaghucell");
            setText(ft, r++, c, akshara, "aksharacell");
            c++;
          }
        }
        resultings.setWidget(row++, 0, ft);
      }

      private FlexTable getFT(int s, int p, int w) {
        final FlexTable resultings = new FlexTable();
        resultings.setCellSpacing(s);
        resultings.setCellPadding(p);
        resultings.setBorderWidth(w);
        resultings.setStyleName("ftrow");
        return resultings;
      }

      private void setText(FlexTable ft, int r, int c, String text, String style) {
        ft.setHTML(r, c, text);
        ft.getFlexCellFormatter().setStyleName(r, c, style);
      }
    });
  }
}