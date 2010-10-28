package org.bhate.prastaara.client.view.depricated;

import java.util.List;

import org.bhate.prastaara.shared.Akshara;

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

public class AmshaGanaViewImpl<T> extends Composite implements ChandasView<T> {

  private static AmshaGanaViewUiBinder uiBinder = GWT.create(AmshaGanaViewUiBinder.class);

  @UiTemplate("AmshaGanaView.ui.xml")
  interface AmshaGanaViewUiBinder extends UiBinder<Widget, AmshaGanaViewImpl> {
  }

  @UiField
  Button button;

  public AmshaGanaViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText("in amsha");
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
    
  }

}
