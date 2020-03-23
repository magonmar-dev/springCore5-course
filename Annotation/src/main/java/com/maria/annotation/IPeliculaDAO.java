package com.maria.annotation;

import java.util.List;

public interface IPeliculaDAO {

	public Pelicula findById(int id);
	public List<Pelicula> findAll();
	public void insert(Pelicula pelicula);
	public void edit(Pelicula antigua, Pelicula nueva);
	public void delete(Pelicula pelicula);
}
