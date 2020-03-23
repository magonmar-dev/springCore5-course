package com.maria.beans;

public class EmailService implements IEmailService {
	
	private Saludator saludator;
	private String destinatarioPorDefecto;

	public void setSaludator(Saludator saludator) {
		this.saludator = saludator;
	}
		
	public void setDestinatarioPorDefecto(String destinatarioPorDefecto) {
		this.destinatarioPorDefecto = destinatarioPorDefecto;
	}
	
	public void enviarEmailSaludo() {
		if(destinatarioPorDefecto != null)
			enviarEmailSaludo(destinatarioPorDefecto);
		else
			System.out.println("Configure un destinatario por defecto para poder enviar los mensajes");
	}

	public void enviarEmailSaludo(String destinatario) {
		System.out.println("Enviando email a " + destinatario);
		System.out.println("Mensaje: " + saludator.saludo());
	}
}
