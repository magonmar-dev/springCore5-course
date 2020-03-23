package com.maria.javaconfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

public class CatalogoPeliculasActuales implements ICatalogoPeliculas {
	
	public List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	public Collection<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	@PostConstruct
	public void init() {
		peliculas.add(new Pelicula("Vengadores: Infinity War", "2018","Ciencia ficci�n"));
		peliculas.add(new Pelicula("Black Panther","2018","Ciencia ficci�n"));
		peliculas.add(new Pelicula("Han Solo", "2018", "Acci�n"));
		peliculas.add(new Pelicula("Ocean's 8", "2018", "Acci�n"));
		peliculas.add(new Pelicula("Tom Raider", "2018", "Aventuras"));
		peliculas.add(new Pelicula("Campeones","2018","Comedia"));
	}
}