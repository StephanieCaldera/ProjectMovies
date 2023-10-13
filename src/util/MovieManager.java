package util;

import java.util.ArrayList;
import java.util.List;
import entitties.Movie;
import entitties.MovieGenre;

//clase MovieManager
public class MovieManager {
	//atributos
	private String nombre;
	private List<Movie>movies;

	public MovieManager() {
	}

	public MovieManager(String nombre) {
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

	//se genera el metodo para insertar peliculas en la lista
	public void addMovie (Movie mov) {
		this.movies.add(mov);	
	}

	/*se genera metodo de listado de peliculas
	 * se recorre el cliclo for para que muestre las peliculas
	 */
	
	public void listMovies () {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}
	
	//se genera metodo para mostrar peliculas segun su genero, si esta vacia la lista muestra un mensaje
	//se recorre el ciclo y muestra codigo y tutlo de la pelicula
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
	
	//se selecciona la pelicula segun el codigo y se muestran todos los datos, se hacen validaciones
	public void selectMovie (Integer codigo) {
		boolean isValid = false;
			for (Movie cod : movies) {
				if (codigo == cod.getCodigo()) {
					isValid = true;
				    System.out.println(cod.toString());
			    }
		    }
			if (!isValid)

			    System.out.println("El código no es válido");
	}
	


		


	
}
