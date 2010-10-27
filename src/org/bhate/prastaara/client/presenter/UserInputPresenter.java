package org.bhate.prastaara.client.presenter;

import java.util.List;

import org.bhate.prastaara.client.GreetingServiceAsync;
import org.bhate.prastaara.client.event.DoPrastaaraEvent;
import org.bhate.prastaara.client.view.UserInputView;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class UserInputPresenter implements UserInputView.Presenter<Akshara>, Presenter {

  private final GreetingServiceAsync rpcService;
  private final HandlerManager eventBus;
  private final UserInputView<Akshara> view;
  private List<Akshara> aksharas;

  public UserInputPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, UserInputView<Akshara> view) {
    this.rpcService = rpcService;
    this.eventBus = eventBus;
    this.view = view;
    this.view.setPresenter(this);
  }

  public void go(final HasWidgets container) {
    container.clear();
    container.add(view.asWidget());
  }

  private void callRPC(final String s) {
    rpcService.greetServer(view.getText(), new AsyncCallback<List<Akshara>>() {

      @Override
      public void onSuccess(List<Akshara> result) {
        aksharas = result;
        eventBus.fireEvent(new DoPrastaaraEvent(s));
      }

      @Override
      public void onFailure(Throwable caught) {
      }
    });
  }

  @Override
  public void onButton(String s) {
    callRPC(s);    
  }

}
