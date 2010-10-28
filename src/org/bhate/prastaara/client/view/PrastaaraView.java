package org.bhate.prastaara.client.view;

import java.util.List;

import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.user.client.ui.Widget;

public interface PrastaaraView {

  public interface Presenter {
    void onPrastaaraButtonClicked();

    void onGanaSelected(int id);
  }

  void setPresenter(Presenter presenter);

  void setPrastaara(List<List<Akshara>> rowData);
  
  void setAksharaGana(List<List<Akshara>> rowData);

  void setMaatraaGana(List<List<Akshara>> rowData);

  void setAmshaGana(List<List<Akshara>> rowData);

  String getText();

  Widget asWidget();

  void selectPrastaara(int index);
}
