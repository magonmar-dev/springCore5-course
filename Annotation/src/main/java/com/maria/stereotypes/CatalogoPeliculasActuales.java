package com.maria.stereotypes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.maria.annotation.ICatalogoPeliculas;
import com.maria.annotation.Pelicula;

@Repository("actuales")
public class CatalogoPeliculasActuales implements ICatalogoPeliculas {

	public List<Pelicula> peliculas = new ArrayList<>();
	
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	@PostConstruct
	public void init() {
		peliculas.add(new Pelicula("Vengadores: Infinity War", "2018","Ciencia ficción"));
		peliculas.add(new Pelicula("Black Panther","2018","Ciencia ficción"));
		peliculas.add(new Pelicula("Han Solo", "2018", "Acción"));
		peliculas.add(new Pelicula("Ocean's 8", "2018", "Acción"));
		peliculas.add(new Pelicula("Tom Raider", "2018", "Aventuras"));
		peliculas.add(new Pelicula("Campeones","2018","Comedia"));
	}
}
