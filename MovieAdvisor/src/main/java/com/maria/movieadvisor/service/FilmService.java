package com.maria.movieadvisor.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.movieadvisor.dao.IFilmDAO;
import com.maria.movieadvisor.model.Film;

@Service
public class FilmService {

	@Autowired
	IFilmDAO filmDao;

	@Autowired
	IFilmQueryService queryService;

	public Collection<String> findAllGenres() {
		List<String> result = null;

		result = filmDao.findAll()
				.stream()
				.map(f -> f.getGenres())
				.flatMap(lista -> lista.stream())
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		return result;
	}

	public Collection<Film> findByAnyGenre(String... genres) {
		return queryService.anyGenre(genres).exec();
	}

	public Collection<Film> findByAllGenres(String... genres) {
		return queryService.allGenres(genres).exec();
	}

	public Collection<Film> findByYear(String year) {
		return queryService.year(year).exec();
	}

	public Collection<Film> findBetweenYears(String from, String to) {
		return queryService.betweenYears(from, to).exec();
	}

	public Collection<Film> findByTitleContains(String title) {
		return queryService.titleContains(title).exec();
	}

	public Collection<Film> findAll() {
		return filmDao.findAll();
	}
}
