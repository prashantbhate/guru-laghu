package org.bhate.prastaara.client.presenter;

import java.util.List;

import org.bhate.prastaara.client.GreetingServiceAsync;
import org.bhate.prastaara.client.event.DoPrastaaraEvent;
import org.bhate.prastaara.client.view.ChandasView;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class PrastaaraPresenter implements Presenter {

  private final GreetingServiceAsync rpcService;
  private final HandlerManager eventBus;
  private final ChandasView<Akshara> view;
  private List<Akshara> aksharas;

  public PrastaaraPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, ChandasView<Akshara> view) {
    this.rpcService = rpcService;
    this.eventBus = eventBus;
    this.view = view;
  }

  public void go(final HasWidgets container) {
    container.add(view.asWidget());
  }


}
