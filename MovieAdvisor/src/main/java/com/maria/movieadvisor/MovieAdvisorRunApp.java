package com.maria.movieadvisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maria.movieadvisor.model.Film;
import com.maria.movieadvisor.service.FilmService;
import com.maria.movieadvisor.service.IFilmQueryService;

@Component
public class MovieAdvisorRunApp {

	@Autowired
	private FilmService filmService;
	
	@Autowired
	private IFilmQueryService filmQueryService;
	
	@Autowired
	private MovieAdvisorHelp help;
	
	public void run(String[] args) {
		
		if(args.length < 1) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else if(args.length == 1) {
			switch (args[0].toLowerCase()) {
				case "-lg":
					filmService.findAllGenres().forEach(System.out::println);
					break;
				case "-h":
					System.out.println(help.getHelp());
					break;
				default:
					System.out.println("Error de sintaxis");
					System.out.println(help.getHelp());
			}
		} else if(args.length % 2 != 0) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else if(args.length > 8) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else {
			// De esta forma hemos asegurado que el n�mero de argumentos
			// es par (opci�n valoropci�n) y que no hay m�s de cuatro parejas.

			List<String[]> argumentos = new ArrayList<>();

			for (int i = 0; i < args.length; i += 2) {
				argumentos.add(new String[] { args[i], args[i + 1] });
			}
			
			boolean error = false;

			for (String[] argumento : argumentos) {
				switch (argumento[0].toLowerCase()) {
				case "-ag":
					filmQueryService.anyGenre(argumento[1].split(","));
					break;
				case "-tg":
					filmQueryService.allGenres(argumento[1].split(","));
					break;
				case "-y":
					filmQueryService.year(argumento[1]);
					break;
				case "-b":
					String[] years = argumento[1].split(",");
					filmQueryService.betweenYears(years[0], years[1]);
					break;
				case "-t":
					filmQueryService.titleContains(argumento[1]);
					break;
				default: error = true;
						 System.out.println("Error de sintaxis");
						 System.out.println(help.getHelp());
				}
			}
			
			if (!error) {
				Collection<Film> result = filmQueryService.exec();
				if (result != null && !result.isEmpty()) {
					System.out.printf("%s\t%-50s\t%s\t%s\n","ID","T�tulo", "A�o", "G�neros");
					result.forEach(f -> System.out.printf("%s\t%-50s\t%s\t%s\n", 
							f.getId(), f.getTitle(), f.getYear(), 
							f.getGenres().stream().collect(Collectors.joining(", "))));
				} else {
					System.out.println("No hay pel�culas que cumplan esos criterios. Lo sentimos");
				}
			}
		}
	}
}
