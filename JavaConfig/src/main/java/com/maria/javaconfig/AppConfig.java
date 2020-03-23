package com.maria.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.maria.javaconfig")
public class AppConfig {

	@Bean
	@Primary
	public ICatalogoPeliculas catalogoActuales() {
		return new CatalogoPeliculasActuales();
	}
	
	@Bean
	public ICatalogoPeliculas catalogoClasicas() {
		return new CatalogoPeliculasClasicas();
		
	}
	
	@Bean
	public IPeliculaDAO peliculaDaoImplMemory() {
		return new PeliculaDAOImp();
	}
	
	@Bean
	public PeliculaService peliculaService() {
		return new PeliculaService();
	}
}