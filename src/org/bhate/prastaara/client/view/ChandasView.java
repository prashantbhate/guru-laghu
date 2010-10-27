package org.bhate.prastaara.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

public interface ChandasView<T> {
  void setAksharaData(List<List<T>> rowData);
  Widget asWidget();
}
