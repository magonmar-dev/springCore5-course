package com.maria.beans;

public class Saludator {
	
	private String mensaje;
	
	public Saludator(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String saludo() {
		return (mensaje == null) ? "Hola mundo" : mensaje;
	}
}
