package com.maria.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		IPersonaDAO personaDAO = appContext.getBean(IPersonaDAO.class);
		
		personaDAO.findAll().forEach(System.out::println);
		
		((ClassPathXmlApplicationContext) appContext).close();
	}
}
