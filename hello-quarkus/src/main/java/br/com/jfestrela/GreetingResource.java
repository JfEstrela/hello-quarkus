package br.com.jfestrela;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.jfestrela.service.GreetingService;

@Path("/hello")
public class GreetingResource {
	
	@Inject
	private GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public String hello() {
        return service.hello();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public String helloApresentation() {
      return service.greetingIam();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }
}