package com.maria.beans;

public interface IEmailService {

	public void enviarEmailSaludo(String destinatario);

	public void setDestinatarioPorDefecto(String string);

	public void enviarEmailSaludo();
}
