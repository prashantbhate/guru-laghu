package org.bhate.prastaara.client.view.depricated;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;

public class UserInputViewImpl<T> extends Composite implements UserInputView<T> {

  private static UserInputViewUiBinder uiBinder = GWT.create(UserInputViewUiBinder.class);

  @UiTemplate("UserInputView.ui.xml")
  interface UserInputViewUiBinder extends UiBinder<Widget, UserInputViewImpl> {
  }

  @UiField
  Button button1;
  @UiField
  Button button2;
  @UiField
  Button button3;
  @UiField
  RichTextArea textarea;

  private Presenter<T> presenter;

  public UserInputViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    button1.setText("amsha");
    button2.setText("matra");
    button3.setText("akshara");
  }

  @UiHandler("button1")
  void onClick1(ClickEvent e) {
    if (presenter != null)
      presenter.onButton(button1.getText());
  }

  @UiHandler("button2")
  void onClick2(ClickEvent e) {
    if (presenter != null)
      presenter.onButton(button2.getText());
  }

  @UiHandler("button3")
  void onClick3(ClickEvent e) {
    if (presenter != null)
      presenter.onButton(button3.getText());
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public String getText() {
    return textarea.getText();
  }

  @Override
  public void setPresenter(org.bhate.prastaara.client.view.depricated.UserInputView.Presenter<T> presenter) {
    this.presenter = presenter;
  }

}
