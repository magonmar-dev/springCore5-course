package com.maria.stereotypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maria.annotation.ICatalogoPeliculas;
import com.maria.annotation.IPeliculaDAO;
import com.maria.annotation.Pelicula;

@Repository
public class PeliculaDAOImp implements IPeliculaDAO {

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	@Autowired
	private Set<ICatalogoPeliculas> catalogosPeliculas;

	@PostConstruct
	public void init() {
		peliculas = catalogosPeliculas
				.stream()
				.map(catalogo -> catalogo.getPeliculas())
				.flatMap(lista -> lista.stream())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Limpiando el almacén de películas");
		peliculas.clear();
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
