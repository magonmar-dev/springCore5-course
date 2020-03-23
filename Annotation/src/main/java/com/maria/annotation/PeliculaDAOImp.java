package com.maria.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class PeliculaDAOImp implements IPeliculaDAO {

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	@Autowired(required=false)
	private Set<ICatalogoPeliculas> catalogosPeliculas;

	/*
	 * @Autowired public PeliculaDAOImp(@Nullable Set<ICatalogoPeliculas> catalogosPeliculas) { 
	 * 	this.catalogosPeliculas = catalogosPeliculas; 
	 * }
	 * 
	 * @Autowired public void setCatalogosPeliculas(Optional<Set<ICatalogoPeliculas>> catalogosPeliculas) {
	 * 	this.catalogosPeliculas = catalogosPeliculas.orElse(null); 
	 * }
	 */

	public void init() {
		if (catalogosPeliculas != null) {
			for (ICatalogoPeliculas c : catalogosPeliculas) {
				peliculas.addAll(c.getPeliculas());
			}
		}
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
