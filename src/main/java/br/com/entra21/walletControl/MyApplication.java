package br.com.entra21.walletControl;

import java.io.IOException;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class MyApplication extends ResourceConfig {

	public MyApplication() throws IOException {
		packages("br.com.entra21.walletControl.controller");
	}

}