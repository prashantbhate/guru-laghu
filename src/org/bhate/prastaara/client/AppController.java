package org.bhate.prastaara.client;

import org.bhate.prastaara.client.event.DoPrastaaraEvent;
import org.bhate.prastaara.client.event.DoPrastaaraEventHandler;
import org.bhate.prastaara.client.presenter.PrastaaraPresenter;
import org.bhate.prastaara.client.presenter.UserInputPresenter;
import org.bhate.prastaara.client.view.AksharaGanaViewImpl;
import org.bhate.prastaara.client.view.AmshaGanaViewImpl;
import org.bhate.prastaara.client.view.ChandasView;
import org.bhate.prastaara.client.view.MatraGanaViewImpl;
import org.bhate.prastaara.client.view.UserInputView;
import org.bhate.prastaara.client.view.UserInputViewImpl;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String> {
  private final HandlerManager eventBus;
  private final GreetingServiceAsync rpcService;
  private HasWidgets container;
  private ChandasView<Akshara> chandasView = null;
  private UserInputView<Akshara> uiView = null;

  public AppController(GreetingServiceAsync rpcService, HandlerManager eventBus) {
    this.eventBus = eventBus;
    this.rpcService = rpcService;
    bind();
  }

  private void bind() {
    History.addValueChangeHandler(this);

    eventBus.addHandler(DoPrastaaraEvent.TYPE, new DoPrastaaraEventHandler() {
      @Override
      public void onDoPrastaara(DoPrastaaraEvent event) {
        showGana(event.getS());
      }
    });
  }

  public void go(final HasWidgets container) {
    this.container = container;
    if ("".equals(History.getToken())) {
      History.newItem("home");
    } else {
      History.fireCurrentHistoryState();
    }
  }

  private void showGana(String s) {
    History.newItem(s);
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();
    if (token != null) {
      if (token.equals("home")) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable caught) {
          }

          public void onSuccess() {
            if (uiView == null) {
              uiView = new UserInputViewImpl<Akshara>();
            }
            new UserInputPresenter(rpcService, eventBus, uiView).go(container);
          }
        });
      } else if (token.equals("amsha")) {
        chandasView = new AmshaGanaViewImpl<Akshara>();
        new PrastaaraPresenter(rpcService, eventBus, chandasView).go(container);

      } else if (token.equals("matra")) {
        chandasView = new MatraGanaViewImpl<Akshara>();
        new PrastaaraPresenter(rpcService, eventBus, chandasView).go(container);

      } else if (token.equals("akshara")) {
        chandasView = new AksharaGanaViewImpl<Akshara>();
        new PrastaaraPresenter(rpcService, eventBus, chandasView).go(container);

      }
    }
  }
}
