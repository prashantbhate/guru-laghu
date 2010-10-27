package org.bhate.prastaara.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

public interface PrastaaraView<T> {

  public interface Presenter<T> {
    void onPrastaaraButtonClicked();
  }
  void setPresenter(Presenter<T> presenter);
  void setAksharaData(List<T> rowData);
  String getText();
  Widget asWidget();
}
