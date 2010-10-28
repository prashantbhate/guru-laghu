package org.bhate.prastaara.client.view.depricated;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MatraGanaViewImpl<T> extends Composite implements ChandasView<T> {

  private static MatraGanaViewUiBinder uiBinder = GWT.create(MatraGanaViewUiBinder.class);

  @UiTemplate("MatraGanaView.ui.xml")
  interface MatraGanaViewUiBinder extends UiBinder<Widget, MatraGanaViewImpl> {
  }

  @UiField
  Button button;

  public MatraGanaViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText("in matra");
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello!");
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public void setAksharaData(List<List<T>> rowData) {
    // TODO Auto-generated method stub
    
  }

}
