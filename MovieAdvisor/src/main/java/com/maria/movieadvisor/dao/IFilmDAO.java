package com.maria.movieadvisor.dao;

import java.util.Collection;

import com.maria.movieadvisor.model.Film;

public interface IFilmDAO {

	public Film findById(long id);
	public Collection<Film> findAll();
	public void insert(Film film);
	public void edit(Film film);
	public void delete(long id);
}
