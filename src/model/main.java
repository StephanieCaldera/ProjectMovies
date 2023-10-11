package model;

import java.io.IOException;
import java.util.Scanner;

import dao.Dao;
import dao.imp.MovieDaoImp;
import entitties.Movie;
import entitties.MovieGenre;
import util.MovieManager;

public class main {
	

	public main() {	
	}

	
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		

		ConexionBD cbd = new ConexionBD();

		MovieManager movieManager = new MovieManager();
		movieManager.setMovies(cbd.movieDao.listar());
		
		getGestorPelicula(movieManager, cbd);
	  
		
		Movie gg = cbd.movieDao.buscarPorCodigo(1);
		//movie1.setTitulo("Aventuras del Mar");
		//movieDao.actualizar(movie1);
		
	
	}
	
	public static void getGestorPelicula(MovieManager movieManager, ConexionBD cbd) {
	    Scanner scanner = new Scanner (System.in); 
		System.out.println("---- BIENVENIDO A TU GESTOR DE PELÍCULAS CINEMA -----");
		System.out.println("MENU");
		System.out.println("1. LISTAR PELÍCULAS");
		System.out.println("2. FILTRAR PELÍCULAS POR GÉNERO");
		System.out.println("3. BUSCAR PELÍCULA");
		System.out.println("4. ADMINISTRAR PELÍCULAS");
		System.out.println("5. SALIR");
		int seleccion = scanner.nextInt();
		
		switch (seleccion) {
		  case 1: 
			movieManager.listMovies();
			System.out.println("¿Volver?: 1. SI");
			int ingreso = scanner.nextInt();
			switch (ingreso) {
			case 1: 
				getGestorPelicula(movieManager, cbd);
				break;
			}	
			break;
			
		  case 2:
			    System.out.println("Seleccione el género de la película");
				System.out.println(MovieGenre.TERROR.name());
				System.out.println(MovieGenre.SUSPENSO.name());
				System.out.println(MovieGenre.COMEDIA.name());
				System.out.println(MovieGenre.ROMANCE.name());
				System.out.println(MovieGenre.FICCION.name());
				System.out.println(MovieGenre.ACCION.name());
				System.out.println(MovieGenre.AVENTURA.name());
				String genero = scanner.next();
				
				try {
				MovieGenre gen = MovieGenre.valueOf(genero.toUpperCase());
				movieManager.showMovies(gen);
				
				} catch (Exception e){
					System.out.println("Genero seleccionado no es valido");
				}
				System.out.println("¿Volver?: 1. SI");
				int volver2 = scanner.nextInt();
				switch (volver2) {
				case 1: 
					getGestorPelicula(movieManager, cbd);
					break;
				}	
			
			break;
		  case 3: 
			  System.out.println("Indique el código de la película a consultar");
			  int codigo = scanner.nextInt();
			  movieManager.selectMovie(codigo);
			  System.out.println("¿Volver?: 1. SI");
			  int selecc = scanner.nextInt();
			  switch (selecc) {
				case 1: 
					getGestorPelicula(movieManager, cbd);
					break;
				}	
			break;

		  case 4: 

				System.out.println("Seleccione la opcion de su preferencia");
				System.out.println("1. Insertar pelicula");
				System.out.println("2. Modificar pelicula");
				System.out.println("3. Eliminar pelicula");
				System.out.println("4. Volver");
				int opcionAdm = scanner.nextInt();
				switch (opcionAdm) {
				case 1: 
					System.out.println("Inserte el título");
					String titulo = scanner.next();
					boolean genereValid = false;
					MovieGenre codGenere = null;
					while (!genereValid) {
						codGenere = getGenere(scanner);	
						if (codGenere != null) {
							genereValid = true;
						} else {
							  System.out.println("Volver a intentar: 1. SI, 2. NO");
							  int selecc1 = scanner.nextInt();
							  switch (selecc1) {
								case 1: 
									break;
								case 2: 
									getGestorPelicula(movieManager, cbd);
									break;
								}	
						}
					}
					System.out.println("Ingrese la URL");
					String url = scanner.next();
					
					boolean imgValid = false;
					String img = null;
					while (!imgValid) {
						System.out.println("Ingrese la ruta de la imagen");
						img = scanner.next();	
						try {
							Movie movie = new Movie(titulo, codGenere, url, img);
							cbd.movieDao.insertar(movie);
							movieManager.setMovies(cbd.movieDao.listar());
							System.out.println("Su película se insertó con éxito");
							imgValid = true;
						}catch (Exception e){
							System.out.println("Uno o varios datos son inválidos, valida la dirección de la imagen");
							System.out.println("Volver a intentar: 1. SI, 2. NO");
							  int selecc1 = scanner.nextInt();
							  switch (selecc1) {
								case 1: 
									break;
								case 2: 
									getGestorPelicula(movieManager, cbd);
									break;
								}	
						}
					}
					
					  System.out.println("¿Volver?: 1. SI");
					  int selecc1 = scanner.nextInt();
					  switch (selecc1) {
						case 1: 
							getGestorPelicula(movieManager, cbd);
							break;
						}
					break;
				case 2: 
					//
					System.out.println("Indique el código de la película a modificar");
					int codigoModif = scanner.nextInt();
					  Movie peli = cbd.movieDao.buscarPorCodigo(codigoModif);
					  if(peli == null)
						    System.out.println("Código no valido");
						else  {   
							System.out.println("Inserte el nuevo título");
							String titulo1 = scanner.next();
							
							
							boolean genereValid1 = false;
							MovieGenre codGenere1 = null;
							while (!genereValid1) {
								codGenere1 = getGenere(scanner);	
								if (codGenere1 != null) {
									genereValid1 = true;
								} else {
									  System.out.println("Volver a intentar: 1. SI, 2. NO");
									  int selecc0 = scanner.nextInt();
									  switch (selecc0) {
										case 1: 
											break;
										case 2: 
											getGestorPelicula(movieManager, cbd);
											break;
										}	
								}
							}
							
													System.out.println("Ingrese la nueva ruta URL");
						String url1 = scanner.next();
						boolean imgValid1 = false;
						String img1 = null;
						while (!imgValid1) {
							System.out.println("Ingrese la nueva ruta de la imagen");
							img = scanner.next();	
							try {
								Movie movie = new Movie(codigoModif, titulo1, codGenere1, url1, img);
								cbd.movieDao.actualizar(movie);
								movieManager.setMovies(cbd.movieDao.listar());
								System.out.println("Su película se modificó con éxito");
								imgValid1 = true;
								}catch (Exception e){
									System.out.println("Uno o varios datos son inválidos, valida la dirección de la imagen");
									System.out.println("Volver a intentar: 1. SI, 2. NO");
									  int selecc3 = scanner.nextInt();
									  switch (selecc3) {
										case 1: 
											break;
										case 2: 
											getGestorPelicula(movieManager, cbd);
											break;
										}	
								}
							}
						}
							  System.out.println("¿Volver?: 1. SI");
							  int selecc3 = scanner.nextInt();
							  switch (selecc3) {
								case 1: 
									getGestorPelicula(movieManager, cbd);
									break;
								}
					  
							break;
				case 3: 
					//
				  System.out.println("Indique el código de la película a eliminar");
				  int codigoEliminar = scanner.nextInt();
				  Movie peli1 = cbd.movieDao.buscarPorCodigo(codigoEliminar);
				  if(peli1 == null)
					    System.out.println("Pelicula no valida");
					else  {
						cbd.movieDao.eliminar(codigoEliminar);
						movieManager.setMovies(cbd.movieDao.listar());
						System.out.println("Película eliminada con éxito");
						
					}

					System.out.println("¿Volver?: 1. SI");
					int volver4 = scanner.nextInt();
					switch (volver4) {
					case 1: 
						getGestorPelicula(movieManager, cbd);
						break;
					}	
					break;
				case 4: 
					getGestorPelicula(movieManager, cbd);
					break;
				}	
			break;

		  case 5: 
			break;
			
		default:
				System.out.println("Opcion invalida");
			}
	}
	
	
	public static MovieGenre getGenere (Scanner scanner) {

		String codGenere;
		System.out.println("Inserte el género : ");
		System.out.println(MovieGenre.TERROR.name());
		System.out.println(MovieGenre.SUSPENSO.name());
		System.out.println(MovieGenre.COMEDIA.name());
		System.out.println(MovieGenre.ROMANCE.name());
		System.out.println(MovieGenre.FICCION.name());
		System.out.println(MovieGenre.ACCION.name());
		System.out.println(MovieGenre.AVENTURA.name());
		codGenere = scanner.next();
		
		try {
			return MovieGenre.valueOf(codGenere.toUpperCase());
			
		} catch (Exception e){
			System.out.println("Genero seleccionado no es valido");
		}
		return null;		
	}

}
