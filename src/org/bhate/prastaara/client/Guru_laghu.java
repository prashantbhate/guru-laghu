package org.bhate.prastaara.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Guru_laghu implements EntryPoint {
  public void onModuleLoad() {
    HandlerManager eventBus = new HandlerManager(null);
    AppController appViewer = new AppController(rpcService, eventBus);
    Window.enableScrolling(false);
    Window.setMargin("0px");
    appViewer.go(RootLayoutPanel.get());
  }

  private final GreetingServiceAsync rpcService = GWT.create(GreetingService.class);

}
/*
 * interface Binder extends UiBinder<DockLayoutPanel, Guru_laghu> { } private
 * static final Binder binder = GWT.create(Binder.class);
 * 
 * @UiField RichTextArea transltextarea;
 * 
 * @UiField Button button;
 * 
 * @UiField HTML tc;
 * 
 * @UiField FlexTable resultings;
 * 
 * @UiField FlexTable ganawings;
 */
/*
 * public void onModuleLoad1() { DockLayoutPanel outer =
 * binder.createAndBindUi(this); Window.enableScrolling(false);
 * Window.setMargin("0px"); RootLayoutPanel root = RootLayoutPanel.get();
 * root.add(outer);
 * 
 * MyHandler handler = new MyHandler(greetingService, transltextarea,
 * resultings, ganawings); transltextarea.addKeyUpHandler(handler);
 * transltextarea.addKeyPressHandler(handler); button.addClickHandler(handler);
 * initTransliterationControls(tc, transltextarea); }
 */
/*
 * public void onModuleLoad1() {
 * 
 * DockLayoutPanel p = new DockLayoutPanel(Unit.EM); HTML html_3 = new
 * HTML("west"); p.addWest(html_3, 2.0); html_3.setStyleName("borader"); HTML
 * html_1 = new HTML("south"); html_1.setStyleName("borader");
 * p.addSouth(html_1, 2); HTML html_2 = new HTML("east");
 * html_2.setStyleName("borader"); p.addEast(html_2, 2); RootLayoutPanel rp =
 * RootLayoutPanel.get(); rp.add(p); HTML html = new HTML("north");
 * p.addNorth(html, 2.0); html.setStyleName("borader");
 * 
 * VerticalPanel verticalPanel = new VerticalPanel();
 * verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
 * verticalPanel.setStyleName("borader"); p.add(verticalPanel);
 * 
 * HorizontalPanel horizontalPanel = new HorizontalPanel();
 * horizontalPanel.setBorderWidth(0);
 * horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
 * horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
 * horizontalPanel.setStyleName("borader"); verticalPanel.add(horizontalPanel);
 * verticalPanel.setCellVerticalAlignment(horizontalPanel,
 * HasVerticalAlignment.ALIGN_MIDDLE);
 * 
 * Label lblSelectLanguage = new Label("Select language : ");
 * horizontalPanel.add(lblSelectLanguage); HTML html_4 = new HTML();
 * horizontalPanel.add(html_4); html_4.setStyleName("borader");
 * 
 * Grid grid = new Grid(2, 5); grid.setStyleName("fixed");
 * grid.setBorderWidth(1); verticalPanel.add(grid);
 * 
 * Label label = new Label("New label"); grid.setWidget(0, 0, label);
 * 
 * Label label_1 = new Label("a"); grid.setWidget(0, 1, label_1);
 * 
 * Label label_2 = new Label("New label"); grid.setWidget(0, 2, label_2);
 * 
 * Label label_3 = new Label("b"); grid.setWidget(0, 3, label_3);
 * 
 * Label label_4 = new Label("New label"); grid.setWidget(0, 4, label_4);
 * 
 * TextArea richTextArea = new TextArea(); richTextArea.setCharacterWidth(5);
 * grid.setWidget(1, 0, richTextArea); richTextArea.setStyleName("rich");
 * 
 * ToggleButton tglbtnKeyboard = new ToggleButton("Keyboard");
 * horizontalPanel.add(tglbtnKeyboard);
 * 
 * Button button = new Button(""); grid.setWidget(1, 1, button);
 * button.setText("-U->");
 * 
 * ScrollPanel scrollPanel = new ScrollPanel(); grid.setWidget(1, 2,
 * scrollPanel); scrollPanel.setStyleName("scroll");
 * 
 * FlexTable flexTable = new FlexTable(); scrollPanel.setWidget(flexTable);
 * 
 * HTML html_5 = new HTML("c", true); grid.setWidget(1, 3, html_5);
 * 
 * StackLayoutPanel stackLayoutPanel = new StackLayoutPanel(Unit.EM);
 * grid.setWidget(1, 4, stackLayoutPanel);
 * 
 * ScrollPanel scrollPanel_1 = new ScrollPanel();
 * stackLayoutPanel.add(scrollPanel_1, new HTML("ಅಕ್ಷರಗಣ"), 2.0);
 * 
 * FlexTable flexTable_1 = new FlexTable();
 * scrollPanel_1.setWidget(flexTable_1); flexTable_1.setBorderWidth(1);
 * 
 * ScrollPanel scrollPanel_2 = new ScrollPanel();
 * stackLayoutPanel.add(scrollPanel_2, new HTML("ಮಾತ್ರಾಗಣ"), 2.0);
 * 
 * FlexTable flexTable_2 = new FlexTable();
 * scrollPanel_2.setWidget(flexTable_2); flexTable_2.setBorderWidth(1);
 * 
 * ScrollPanel scrollPanel_3 = new ScrollPanel();
 * stackLayoutPanel.add(scrollPanel_3, new HTML("ಅಂಶಗಣ"), 2.0);
 * 
 * FlexTable flexTable_3 = new FlexTable();
 * scrollPanel_3.setWidget(flexTable_3);
 * 
 * init(html_4, button, richTextArea, flexTable, flexTable_1, flexTable_2,
 * flexTable_3);
 * 
 * }
 */