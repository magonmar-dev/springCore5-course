package com.maria.stereotypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.annotation.IPeliculaDAO;
import com.maria.annotation.Pelicula;

@Service
public class PeliculaService {

	@Autowired
	private IPeliculaDAO peliculaDao;
	
	public void setPeliculaDao(IPeliculaDAO peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
	
	public PeliculaService() { }
	
	public PeliculaService(IPeliculaDAO peliculaDao) {
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
