package com.maria.values;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Saludator s = appContext.getBean(Saludator.class);
		
		System.out.println(s.saludo());
				
		((AnnotationConfigApplicationContext) appContext).close();
	}

}
