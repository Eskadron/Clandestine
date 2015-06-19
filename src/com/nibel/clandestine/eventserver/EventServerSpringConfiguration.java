package com.nibel.clandestine.eventserver;

import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nibel.clandestine.eventserver")
public class EventServerSpringConfiguration {
	@Bean
	public HttpServer httpServer() throws URISyntaxException{
		ResourceConfig rc = new ResourceConfig();
		rc.register(CrossDomainResponseFilter.class);
		rc.packages("com.nibel.clandestine.eventserver");
		rc.property("port", 9001);
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(new URI("http://0.0.0.0:9001"), rc, true);
		
		return server;
	}
}
