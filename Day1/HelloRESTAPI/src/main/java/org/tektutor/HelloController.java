package org.tektutor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloController {

	private HelloService helloService = new HelloService();

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/sayhello")
	public Hello sayHello() {
		return helloService.sayHello();
	}


}
