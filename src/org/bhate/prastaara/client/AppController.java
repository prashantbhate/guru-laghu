package org.bhate.prastaara.client;

import org.bhate.prastaara.client.presenter.PrastaaraPresenter;
import org.bhate.prastaara.client.view.PrastaaraView;
import org.bhate.prastaara.client.view.PrastaaraViewImpl;

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
  private PrastaaraView uiView = null;

  public AppController(GreetingServiceAsync rpcService, HandlerManager eventBus) {
    this.eventBus = eventBus;
    this.rpcService = rpcService;
    bind();
  }

  private void bind() {
    History.addValueChangeHandler(this);
  }

  public void go(final HasWidgets container) {
    this.container = container;
    if ("".equals(History.getToken())) {
      History.newItem("home");
    } else {
      History.fireCurrentHistoryState();
    }
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
              uiView = new PrastaaraViewImpl();
            }
            new PrastaaraPresenter(rpcService, eventBus, uiView).go(container);
          }
        });
      }
    }
  }
}
