package com.maria.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PeliculaDAOImp implements IPeliculaDAO {

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	@Autowired
	private ICatalogoPeliculas catalogoPeliculas;

	public void init() {
		peliculas.addAll(catalogoPeliculas.getPeliculas());
	}
	
	public PeliculaDAOImp() {}

	public Pelicula findById(int id) {
		return peliculas.get(id);
	}

	public List<Pelicula> findAll() {
		return peliculas;
	}

	public void insert(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	public void edit(Pelicula antigua, Pelicula nueva) {
		peliculas.remove(antigua);
		peliculas.add(nueva);
	}

	public void delete(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}
}
