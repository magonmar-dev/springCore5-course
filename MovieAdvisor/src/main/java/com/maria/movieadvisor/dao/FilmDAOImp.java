package com.maria.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maria.movieadvisor.config.AppConfig;
import com.maria.movieadvisor.model.Film;

@Repository
public class FilmDAOImp implements IFilmDAO {

	private List<Film> peliculas = new ArrayList<>();
	
	@Autowired
	private AppConfig appConfig;
	
	@PostConstruct
	public void init() {
		peliculas = FilmFileReader.readFile(appConfig.getFile(), appConfig.getSeparator(), appConfig.getListSeparator());
	}
	
	public Film findById(long id) {
		
		Optional<Film> result = peliculas
				.stream()
				.filter(f -> f.getId() == id)
				.findFirst();
		
		return result.orElse(null);
	}

	public Collection<Film> findAll() {
		return peliculas;
	}

	public void insert(Film film) {
		peliculas.add(film);
	}

	public void edit(Film film) {
		int index = getIndexOf(film.getId());
		if(index != -1)
			peliculas.set(index, film);
	}

	public void delete(long id) {
		int index = getIndexOf(id);
		if (index != -1)
			peliculas.remove(index);
	}
	
	private int getIndexOf(long id) {
		
		boolean encontrado = false;
		int index = 0;
		
		while (!encontrado && index < peliculas.size()) {
			if (peliculas.get(index).getId() == id)
				encontrado = true;
			else
				index++;
		}
		
		return (encontrado) ? index : -1;
	}
}
