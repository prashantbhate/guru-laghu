package org.bhate.prastaara.client.view.depricated;

import com.google.gwt.user.client.ui.Widget;

public interface UserInputView<T> {
  String getText();

  Widget asWidget();

  void setPresenter(Presenter<T> presenter);

  public interface Presenter<T> {
    void onButton(String s);
  }
}
