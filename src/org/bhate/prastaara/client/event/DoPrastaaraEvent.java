package org.bhate.prastaara.client.event;

import com.google.gwt.event.shared.GwtEvent;


public class DoPrastaaraEvent extends GwtEvent<DoPrastaaraEventHandler> {
  public static Type<DoPrastaaraEventHandler> TYPE = new Type<DoPrastaaraEventHandler>();
  private String s;
  
  public DoPrastaaraEvent(String s) {
    this.s=s;
  }

  @Override
  public Type<DoPrastaaraEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DoPrastaaraEventHandler handler) {
    handler.onDoPrastaara(this);
  }

  public String getS() {
    return s;
  }
}
