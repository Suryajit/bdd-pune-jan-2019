package org.tektutor;

public class HelloService {

	private Hello hello = new Hello("Hello REST API");

	public Hello sayHello() {
		return hello; 
	}

}
