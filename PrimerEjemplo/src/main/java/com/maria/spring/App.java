package com.maria.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maria.beans.EmailService;
import com.maria.beans.IEmailService;
import com.maria.beans.Saludator;

public class App {

	public static void main(String[] args) {

		// CONTENEDOR DE INVERISÓN DE CONTROL
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml"); // mejor opción
		/*
		 * Si colocamos el archivo xml en la raíz del proyecto utilizaríamos
		 * ApplicationContext appContext = new FileSystemXmlApplicationContext("beans.xml");
		 */

		// FORMAS DE OBTENER UN BEAN
		
		Saludator saludador = null;
		/*
		 * 1. getBean con ID y casting
		 * saludador = (Saludator) appContext.getBean("saludator");
		 * 2. getBean con ID y tipo
		 * saludador = appContext.getBean("saludator", Saludator.class);
		 * 3. getBean con tipo (en el caso de que solo haya un bean por clase, sino saltaría una excepción)
		 * saludador = appContext.getBean(Saludator.class);
		 */		
		saludador = appContext.getBean(Saludator.class);
		System.out.println(saludador.saludo());
		System.out.println();

		// UN BEAN QUE REFERENNCIA A OTRO
		
		EmailService emailService = null;
		emailService = appContext.getBean(EmailService.class);
		emailService.enviarEmailSaludo("maria@openwebinars.com");
		System.out.println();

		// BEANS QUE IMPLEMENTAN INTERFACES
		
		IEmailService emailService2 = null;
		emailService2 = appContext.getBean(IEmailService.class);
		emailService2.enviarEmailSaludo("maria@iessanvicente.com");
		System.out.println();
		
		// SINGLETON
		
		System.out.println(emailService);
		System.out.println(emailService2);
		System.out.println();
		
		// PROTOTYPE
		
		IEmailService emailService3 = appContext.getBean(IEmailService.class);
		emailService3.setDestinatarioPorDefecto("maria@everis.com");
		emailService3.enviarEmailSaludo();
		System.out.println();
		IEmailService emailService4 = appContext.getBean(IEmailService.class);
		emailService4.enviarEmailSaludo();

		((ClassPathXmlApplicationContext) appContext).close();
	}

}
