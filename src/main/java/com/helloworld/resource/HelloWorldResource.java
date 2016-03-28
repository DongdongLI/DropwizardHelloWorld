package com.helloworld.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.helloworld.api.Saying;

// can be access at URI /hello-world
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
// what resource this service is going to produce
public class HelloWorldResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	
	public HelloWorldResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	// map "name" param to the "name" in the method
	@GET
	@Timed// record duration
	public Saying sayHellow(@QueryParam("name") Optional<String> name){
		final String value=String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
