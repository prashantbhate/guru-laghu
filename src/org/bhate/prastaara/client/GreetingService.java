package org.bhate.prastaara.client;

import java.util.List;

import org.bhate.prastaara.shared.Akshara;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	List<Akshara> greetServer(String name) throws IllegalArgumentException;
	String getPrastaara(Akshara a) throws IllegalArgumentException;
}
