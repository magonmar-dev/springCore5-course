package com.maria.javaconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class PeliculaService {

	@Autowired
	private IPeliculaDAO peliculaDao;
	
	public void setPeliculaDao(IPeliculaDAO peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
		
	public List<Pelicula> pelisPorGenero(String genero) {
		return peliculaDao
				.findAll()
				.stream()
				.filter(p -> p.getGenero().equalsIgnoreCase(genero))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
