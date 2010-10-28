package org.bhate.prastaara.client.view;

import java.util.List;

import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.language.client.LanguageUtils;
import com.google.gwt.language.client.transliteration.control.TransliterationControl;
import com.google.gwt.language.client.transliteration.control.TransliterationControlOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class PrastaaraViewImpl extends Composite implements PrastaaraView {

  @UiTemplate("PrastaaraView.ui.xml")
  interface PrastaaraViewUiBinder extends UiBinder<Widget, PrastaaraViewImpl> {
  }

  private static PrastaaraViewUiBinder uiBinder = GWT.create(PrastaaraViewUiBinder.class);

  @UiField
  RichTextArea transltextarea;
  @UiField
  FlexTable prastaarita;
  @UiField
  FlexTable aksharagana;
  @UiField
  FlexTable maatraagana;
  @UiField
  FlexTable amshagana;
  @UiField
  Button button;
  @UiField
  Button keyboard;
  @UiField
  HTML transControl;
  @UiField
  StackLayoutPanel stack;

  @UiHandler("button")
  void onButtonClicked(ClickEvent event) {
    if (presenter != null) {
      presenter.onPrastaaraButtonClicked();
    }
  }

  @UiHandler("stack")
  void onClicked(SelectionEvent<Integer> event) {
    if (presenter != null) {
      presenter.onGanaSelected(event.getSelectedItem());
    }
  }

  private Presenter presenter;

  public PrastaaraViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    initTransliterationControls(transControl, transltextarea);
  }

  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  public Widget asWidget() {
    return this;
  }

  @Override
  public String getText() {
    return transltextarea.getText();
  }

  @Override
  public void setAksharaGana(List<List<Akshara>> rowData) {
    setFt(aksharagana, rowData);
  }

  private void setFt(FlexTable ft, List<List<Akshara>> rowData) {
    ft.clear(true);
    ft.removeAllRows();
    int r = 0;
    for (List<Akshara> list : rowData) {
      int c = 0;
      int rj = 1;
      for (Akshara akshara : list) {
        rj = setFText(ft, r, c++, akshara);
      }
      r += rj;
    }
  }

  private int setFText(FlexTable ft, int r, int c, Akshara a) {
    ft.setHTML(r, c, a.getPrastaara());
    ft.getFlexCellFormatter().setStyleName(r, c, "gurulaghucell");

    ft.setHTML(r + 1, c, a.getAkshara());
    ft.getFlexCellFormatter().setStyleName(r + 1, c, "aksharacell");

    return 2;
  }

  @Override
  public void setAmshaGana(List<List<Akshara>> rowData) {
    setFt(amshagana, rowData);
  }

  @Override
  public void setMaatraaGana(List<List<Akshara>> rowData) {
    setFt(maatraagana, rowData);
  }

  @Override
  public void setPrastaara(List<List<Akshara>> rowData) {
    setFt(prastaarita, rowData);
  }

  private void initTransliterationControls(final HTML div, final RichTextArea transltextarea) {

    LanguageUtils.loadTransliteration(new Runnable() {
      public void run() {
        String[] dest = { "kn", "hi" /* //for future"hi", "ml", "ta", "te" */};
        TransliterationControlOptions options = TransliterationControlOptions.newInstance("en", dest, true, "ctrl+g");
        TransliterationControl control = TransliterationControl.newInstance(options);

        control.showControl(div);
        control.makeTransliteratable(transltextarea);
        transltextarea.setWidth("100%");
        transltextarea.setHeight("100%");
      }
    });

  }

  @Override
  public void selectPrastaara(int index) {
    stack.showWidget(index);
    
  }

}
