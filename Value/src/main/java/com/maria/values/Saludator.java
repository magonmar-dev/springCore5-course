package com.maria.values;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Saludator {
	
	//@Value("Hola mundo")
	@Value("${mensaje}")
	private String mensaje;
	
	public String saludo() {
		return mensaje;
	}

}
