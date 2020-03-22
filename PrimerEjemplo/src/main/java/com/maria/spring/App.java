package com.maria.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maria.beans.EmailService;
import com.maria.beans.IEmailService;
import com.maria.beans.Saludator;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml"); // mejor opci�n
		// Si colocamos el archivo xml en la ra�z del proyecto utilizar�amos
		// ApplicationContext appContext = new
		// FileSystemXmlApplicationContext("beans.xml");

		Saludator saludador = null;

		// 1. getBean con ID y casting
		// saludador = (Saludator) appContext.getBean("saludator");

		// 2. getBean con ID y tipo
		// saludador = appContext.getBean("saludator", Saludator.class);

		// 3. getBean con tipo
		saludador = appContext.getBean(Saludator.class);
		// en el caso de que solo haya un bean por clase, sino saltar�a una excepci�n

		System.out.println(saludador.saludo());

		System.out.println();

		EmailService emailService = null;
		emailService = appContext.getBean(EmailService.class);
		emailService.enviarEmailSaludo("maria@openwebinars.com");

		System.out.println();

		IEmailService emailService2 = null;
		emailService2 = appContext.getBean(IEmailService.class);
		emailService2.enviarEmailSaludo("maria@iessanvicente.com");

		((ClassPathXmlApplicationContext) appContext).close();
	}

}
