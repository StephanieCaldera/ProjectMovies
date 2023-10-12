package model;

import java.io.IOException;
import dao.Dao;
import dao.imp.MovieDaoImp;
import entitties.Movie;
import entitties.MovieGenre;


public class ConexionBD {
	
	//se instancia el objeto movieDao
	Dao<Movie, Integer> movieDao = new MovieDaoImp();
	
	public ConexionBD() {}
	

	//Se genera constructor para pasar recibir por @parametro un tipo de dato boolean
	//se instancian objetos de la clase Movie
	//objeto this.movieDao invoca metodo crearBD, crearTabla e insertar.
	public ConexionBD(boolean create) {
		try {
			
			Movie movie1 = new Movie("Dumbo", MovieGenre.AVENTURA, "https://www.multiplex.com.ar/peliculas/dumbo/?comp=0&dia=0&frm=0", "C:\\Datos\\Poster_DUMBO-280x400-1.jpg");
			Movie movie2 = new Movie("Una Flor en el Barro", MovieGenre.ROMANCE, "https://www.atlascines.com/#!/pelicula/230928232C", "C:\\Datos\\una+flor+en+el+barro+web.jpg");
			Movie movie3 = new Movie("Juegos del Miedo 5", MovieGenre.FICCION, "https://www.atlascines.com/#!/pelicula/230928212C", "C:\\Datos\\juego+del+miedo+x+web.jpg");
			Movie movie4 = new Movie("Oppenheimer", MovieGenre.ACCION, "https://www.atlascines.com/#!/pelicula/230720221S", "C:\\Datos\\oppenheimer+web.jpg");
			Movie movie5 = new Movie("La Monja 2", MovieGenre.TERROR, "https://www.cinemarkhoyts.com.ar/pelicula/LA-MONJA-2", "C:\\Datos\\laMonja.jpg");
			Movie movie6 = new Movie("Hazme el favor", MovieGenre.COMEDIA, "https://www.cinepolis.com.ar/peliculas/hazme-el-favor", "C:\\Datos\\Hazme el favoe.jpg");
			Movie movie7 = new Movie("Trolls 3", MovieGenre.COMEDIA, "https://www.cinemarkhoyts.com.ar/proximamente/TROLLS-3", "C:\\Datos\\Trolls3.jpg");
			Movie movie8 = new Movie("As Bestas", MovieGenre.SUSPENSO, "https://www.cinemarkhoyts.com.ar/pelicula/AS-BESTAS", "C:\\D\\AsBestas.jpg");
			
			this.movieDao = new MovieDaoImp();
			
			this.movieDao.crearBD();
			this.movieDao.crearTabla();
			this.movieDao.insertar(movie1);
			this.movieDao.insertar(movie2);
			this.movieDao.insertar(movie3);
			this.movieDao.insertar(movie4);
			this.movieDao.insertar(movie5);
			this.movieDao.insertar(movie6);
			this.movieDao.insertar(movie7);
			this.movieDao.insertar(movie8);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
