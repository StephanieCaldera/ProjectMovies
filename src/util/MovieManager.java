package util;

import java.util.ArrayList;
import java.util.List;

import entitties.Movie;
import entitties.MovieGenre;

public class MovieManager {
	
	private String nombre;
	private List<Movie>movies;

	public MovieManager() {
		// TODO Auto-generated constructor stub
	}

	public MovieManager(String nombre) {
		super();
		this.nombre = nombre;
		this.movies = new ArrayList<>();
	}
	
	//metodos getter y setter
	
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//metodos
	public void addMovie (Movie mov) {
		this.movies.add(mov);	
	}
	
	public void listMovies () {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}
	
	public void showMovies (MovieGenre genero) {
		if (movies.isEmpty()) {
			System.out.println("no hay peliculas que mostrar");
		}else {
			for (Movie mov : movies) {
				if (genero == mov.getGenero()) {
				System.out.println("el codigo de la pelicula es " + mov.getCodigo());
				System.out.println("titulo " + mov.getTitulo());
			    }
		    }
	    }
	}
	
	public void selectMovie (Integer codigo) {
		boolean isValid = false;
			for (Movie cod : movies) {
				if (codigo == cod.getCodigo()) {
					isValid = true;
				    System.out.println(cod.toString());
			    }
		    }
			if (!isValid)

			    System.out.println("El código " + codigo.toString()+ " no es válido");
	}
	


		


	
}
