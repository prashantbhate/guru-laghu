package org.bhate.prastaara.client;

import java.util.List;

import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<List<Akshara>> callback)
			throws IllegalArgumentException;

  void getPrastaara(Akshara a, AsyncCallback<String> callback);
}
