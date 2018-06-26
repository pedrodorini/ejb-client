package br.shopping;

import java.util.Properties;

import javax.naming.Context;

public class JNDIConfig {
	public static Properties getConfigs() {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
		return properties;
	}
}
