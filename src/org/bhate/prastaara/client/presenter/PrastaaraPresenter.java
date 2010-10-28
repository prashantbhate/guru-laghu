package org.bhate.prastaara.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bhate.prastaara.client.GreetingServiceAsync;
import org.bhate.prastaara.client.view.PrastaaraView;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;

public class PrastaaraPresenter implements Presenter, PrastaaraView.Presenter {

  private final GreetingServiceAsync rpcService;
  private final HandlerManager eventBus;
  private List<Akshara> aksharas;
  private PrastaaraView view;
  private ArrayList<List<Akshara>> prastaaraData;
  private ArrayList<List<Akshara>> aksharaGanaData;
  private ArrayList<List<Akshara>> maatraaGanaData;
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

  public PrastaaraPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, PrastaaraView view) {
    this.rpcService = rpcService;
    this.eventBus = eventBus;
    this.view = view;
    this.view.setPresenter(this);
  }

  public void go(final HasWidgets container) {
    container.clear();
    container.add(view.asWidget());
  }

  @Override
  public void onGanaSelected(int id) {
    if (aksharas != null) {
      switch (id) {
      case 0:
        if (prastaaraData == null)
          doPrastaara();
        break;
      case 1:
        if (aksharaGanaData == null)
          doAksharaGana();
        break;
      case 2:
        if (maatraaGanaData == null)
          doMaatraaGana();
        break;
      case 3:
        doAmshaGana();
        break;
      default:
        break;
      }
    }
  }

  @Override
  public void onPrastaaraButtonClicked() {
    rpcService.greetServer(view.getText(), new AsyncCallback<List<Akshara>>() {

      @Override
      public void onSuccess(List<Akshara> result) {
        aksharas = result;
        prastaaraData = null;
        aksharaGanaData = null;
        maatraaGanaData = null;
        doPrastaara();
        view.selectPrastaara(0);
      }

      @Override
      public void onFailure(Throwable caught) {
      }
    });
  }

  private void doPrastaara() {
    prastaaraData = new ArrayList<List<Akshara>>();
    List<Akshara> e = new ArrayList<Akshara>();
    int c = 0;
    for (Akshara a : aksharas) {
      String akshara = a.getAkshara();
      String prastaara = a.getPrastaara();
      if (akshara.contains("\n")) {
        c = 0;
        prastaaraData.add(e);
        e = new ArrayList<Akshara>();
      } else {
        akshara = akshara.replaceAll(" ", "&nbsp;");
        e.add(new Akshara(akshara, prastaara, a.getValue()));
        c++;
      }
    }
    if (!e.isEmpty())
      prastaaraData.add(e);

    view.setPrastaara(prastaaraData);
  }

  private void doAksharaGana() {
    aksharaGanaData = new ArrayList<List<Akshara>>();
    int count = 0;
    String p = "";
    String a = "";
    List<Akshara> e = new ArrayList<Akshara>();
    for (Akshara aksh : aksharas) {
      String akshara = aksh.getAkshara();
      int v = aksh.getValue();
      a += akshara;
      if (v != 0) {
        count++;
        p += aksh.getPrastaara();
      }
      if (count == 3) {
        e.add(new Akshara(a, getGana(p) + " " + p, 0));
        count = 0;
        a = "";
        p = "";
      }
      if (akshara.contains("\n")) {
        aksharaGanaData.add(e);
        e = new ArrayList<Akshara>();
      }
    }
    e.add(new Akshara(a, getGana(p) + " " + p, 0));
    aksharaGanaData.add(e);
    view.setAksharaGana(aksharaGanaData);
  }

  private String getGana(String p) {
    String s = GAN_MAP.get(p);
    return s == null ? "" : s;
  }

  private void doAmshaGana() {

    List<List<Akshara>> rowData = new ArrayList<List<Akshara>>();
    List<Akshara> e = new ArrayList<Akshara>();
    e.add(new Akshara("a", "b", 1));
    rowData.add(e);
    view.setAmshaGana(rowData);
  }

  private void doMaatraaGana() {
    maatraaGanaData = new ArrayList<List<Akshara>>();
    ArrayList<List<Akshara>> shatPadi = shatPadi(7);
    if (shatPadi != null) {
      List<Akshara> e = new ArrayList<Akshara>();
      e.add(new Akshara("", " 3+4 : ಭಾಮಿನೀ ಷಟ್ಪದಿ", 1));
      maatraaGanaData.add(e);
      maatraaGanaData.addAll(shatPadi);
    }
    shatPadi = shatPadi(5);
    if (shatPadi != null) {
      List<Akshara> e = new ArrayList<Akshara>();
      e.add(new Akshara("", "5 : ಕುಸುಮ ಷಟ್ಪದಿ  / ವಾರ್ಧಕ ಷಟ್ಪದಿ", 1));
      maatraaGanaData.add(e);
      maatraaGanaData.addAll(shatPadi);
    }

    shatPadi = shatPadi(4);
    if (shatPadi != null) {
      List<Akshara> e = new ArrayList<Akshara>();
      e.add(new Akshara("", "4 : ಶರ ಷಟ್ಪದಿ  / ಪರಿವರ್ಧಿನೀ ಷಟ್ಪದಿ", 1));
      maatraaGanaData.add(e);
      maatraaGanaData.addAll(shatPadi);
    }
    shatPadi = shatPadi(3);
    if (shatPadi != null) {
      List<Akshara> e = new ArrayList<Akshara>();
      e.add(new Akshara("", "3 : ಭೋಗ ಷಟ್ಪದಿ", 1));
      maatraaGanaData.add(e);
      maatraaGanaData.addAll(shatPadi);
    }
    view.setMaatraaGana(maatraaGanaData);
  }

  private ArrayList<List<Akshara>> shatPadi(int MAX) {
    ArrayList<List<Akshara>> mGana = new ArrayList<List<Akshara>>();
    int sum = 0;
    String p = "";
    String a = "";
    List<Akshara> e = new ArrayList<Akshara>();
    for (Akshara aksh : aksharas) {
      String akshara = aksh.getAkshara();
      int v = aksh.getValue();
      a += akshara;
      if (v != 0) {
        sum += v;
        p += aksh.getPrastaara();
      }
      if (sum == MAX) {
        e.add(new Akshara(a, sum + " " + p, 0));
        sum = 0;
        a = "";
        p = "";
      } else if (sum > MAX) {
        return null;
      }
      if (akshara.contains("\n")) {
        if (sum > MAX) {
          return null;
        } else if (sum > 0) {
          e.add(new Akshara(a, sum + " " + p, 0));
          sum = 0;
          a = "";
          p = "";
        }
        mGana.add(e);
        e = new ArrayList<Akshara>();
      }
    }
    if (sum > MAX) {
      return null;
    } else if (sum > 0)
      e.add(new Akshara(a, sum + " " + p, 0));
    mGana.add(e);

    return mGana;
  }

}
