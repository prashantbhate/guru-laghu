package org.bhate.prastaara.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;

public class PrastaaraViewImpl<T> extends Composite implements PrastaaraView<T> {

  @UiTemplate("PrastaaraView.ui.xml")
  interface PrastaaraViewUiBinder extends UiBinder<Widget, PrastaaraViewImpl> {
  }

  private static PrastaaraViewUiBinder uiBinder = GWT.create(PrastaaraViewUiBinder.class);

  @UiField
  RichTextArea transltextarea;
  @UiField
  FlexTable resultings;
  @UiField
  FlexTable ganawings;
  @UiField
  Button button;
  @UiField
  HTML transControl;

  @UiHandler("button")
  void onButtonClicked(ClickEvent event) {
    if (presenter != null) {
      presenter.onPrastaaraButtonClicked();
    }
  }

  private Presenter<T> presenter;
  private List<T> rowData;

  public PrastaaraViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public void setPresenter(Presenter<T> presenter) {
    this.presenter = presenter;
  }

  public void setAksharaData(List<T> rowData) {
    this.rowData = rowData;
  }

  public Widget asWidget() {
    return this;
  }

  @Override
  public String getText() {
    return transltextarea.getText();
  }
}
