package com.maria.movieadvisor.service;

import java.util.Collection;

import com.maria.movieadvisor.model.Film;

public interface IFilmQueryService {

	public Collection<Film> exec();
	
	public IFilmQueryService anyGenre(String... genres);

	public IFilmQueryService allGenres(String... genres);

	public IFilmQueryService year(String year);

	public IFilmQueryService betweenYears(String from, String to);

	public IFilmQueryService titleContains(String title);
}
