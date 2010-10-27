package org.bhate.prastaara.server;

import java.util.ArrayList;
import java.util.List;

import org.bhate.prastaara.client.GreetingService;
import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
  IndicLanguage iL = new IndicLanguage();
  IndicUtil indicUtil = new IndicUtil(iL);

  public List<Akshara> greetServer(String input) throws IllegalArgumentException {
    IndicString is = new IndicString(iL, input);
    ArrayList<Akshara> a = is.getPrastaredAksharas();
    return a;
  }

  @Override
  public String getPrastaara(Akshara a) throws IllegalArgumentException {
    return null;
  }
}
