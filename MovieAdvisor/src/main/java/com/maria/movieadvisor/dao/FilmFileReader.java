package com.maria.movieadvisor.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.maria.movieadvisor.model.Film;

public class FilmFileReader {

	public static List<Film> readFile(final String path, final String separator, final String listSeparator) {
		
		List<Film> result = new ArrayList<>();
		
		try {
			result = Files.lines(Paths.get(ResourceUtils.getFile(path).toURI()))
				.skip(1) // nos saltamos la primera línea
				.map(line -> {
					String[] values = line.split(separator);
					return new Film(Long.parseLong(values[0]), values[1], values[2],
							Arrays.asList(values[3].split(listSeparator)));
				}).collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			System.err.println("Fichero de datos 'imbd_data.csv' no encontrado");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error leyendo el fichero de datos: imbd_data.csv");
			System.exit(-1);
		}
		
		return result;
	}
}
