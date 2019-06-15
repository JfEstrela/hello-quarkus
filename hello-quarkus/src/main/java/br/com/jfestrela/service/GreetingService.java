package br.com.jfestrela.service;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {
	
	@ConfigProperty(name = "greenting.name")
	private String name;
	
	private static final String HELLO = "hello";
	
	public String greeting(String name) {
        return hello()+" " + name + "\n";
    }
	
	public String greetingIam() {
		return   hello()+" my name is ".concat(name);
	}
	
	public String hello() {
		return HELLO;
	}
	
	

}
