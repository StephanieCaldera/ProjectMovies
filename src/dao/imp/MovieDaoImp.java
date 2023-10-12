package dao.imp;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import dao.ConexionMySql;
import dao.Dao;
import entitties.Movie;
import entitties.MovieGenre;

//Se crea la clase que implementa las interfaces de conexion y metodos ABM
public class MovieDaoImp implements ConexionMySql, Dao<Movie, Integer> {

	public MovieDaoImp() {
		// TODO Auto-generated constructor stub
	}

	//metodo de creacion de Base de Datos
	@Override
	public void crearBD () {
		String sentenciaSQL = "CREATE DATABASE cinema";  //sentencia SQL
		Connection conexion = getConexion("");  //conexion a MySQL
		try {
			
			Statement st = conexion.createStatement(); //el objeto conexion se instancia e invoca metodo propio
		    st.executeUpdate(sentenciaSQL);   //ejecucion sentencia SQL
			st.close();  //cierre conexion
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear Base de dato");
			e.printStackTrace();
		}
		
	}
	
	//metodo creacion tabla de datos
	//se hace la conexion a la Baase de Datos creada, recibe @parametro el nombre BD
	//se ejecuta la sentencia SQL y cierra conexion
	@Override
	public void crearTabla () {
		Connection conexion = getConexion("/cinema");
		String sentenciaSQL = "CREATE TABLE movies " +
                "(mov_codigo INTEGER NOT NULL AUTO_INCREMENT, " +
                " mov_titulo VARCHAR(255), " + 
                " mov_genero ENUM('terror','suspenso','comedia','romance','ficcion','accion','aventura')," +
                " mov_url VARCHAR(255), " +
                " mov_imagen VARCHAR(255), " +
                " PRIMARY KEY (mov_codigo))";
		
		try {
			
			Statement st = conexion.createStatement();
		    st.executeUpdate(sentenciaSQL);
			st.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear tabla movies");
			e.printStackTrace();
		}
		
	}
	
	/*metodo de busqueda de pelicula por codigo
	 * Se instancia la conexion con BD y la sentencia SQL
	 * se trabaja con ResultSet y se crea un ciclo while para pasar los valores de las variables al objeto SearchMovie
	 */
	@Override
	public Movie buscarPorCodigo(Integer Key)  {
		Movie searchMovie = null;
		Connection conexion = getConexion("/cinema");
		String sentenciaSql = "SELECT * FROM movies WHERE mov_codigo = " + Key;
		Statement st = null;
		
		Image image = null;

			try {
				st = conexion.createStatement();
				ResultSet resultado = st.executeQuery(sentenciaSql);
				while (resultado.next()){
					int codigo = resultado.getInt("mov_codigo");
					String titulo = resultado.getString("mov_titulo");
					String generoSeleccion = resultado.getString("mov_genero");
					MovieGenre genero = MovieGenre.valueOf(generoSeleccion.toUpperCase());
					String url = resultado.getString("mov_url");
					String imagen =  resultado.getString("mov_imagen");	
					searchMovie = new Movie(codigo, titulo, genero, url, imagen);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					st.close();
					conexion.close();	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			return searchMovie;	
		}	
		
	

	/* el metodo hace conexion con la BD a traves del objeto conexion y se instancia la sentencia SQL
	 * se inicializa objeto tipo File y el objeto tipo Movie ies pasado como parametro con el metodo de mostrar ruta imagen
	 * se convierte la imagen con FileInputStream y se inicializa con @parametro del obejto tipo File
	 *  el objeto tipo PreparedStream invoca metodo set pasando por @parametro la posicion a ocuparse y el objeto tipo Movie convocando metodos get
	 */
	
	@Override
	public void insertar(Movie elemento) {
		Connection conexion = getConexion("/cinema");
		String sentenciaSQL = "INSERT INTO movies (mov_titulo, mov_genero, mov_url, mov_imagen) VALUES (?,?,?,?)";
		
		File archivoImagen = new File (elemento.getRutaImagen());
		
		try {
			FileInputStream convertirImagen = new FileInputStream(archivoImagen);
			PreparedStatement st = conexion.prepareStatement(sentenciaSQL);
			st.setString(1, elemento.getTitulo());
			st.setString(2, elemento.getGenero().name());
			st.setString(3, elemento.getUrl());
			st.setString(4, elemento.getRutaImagen());
	
		    st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al intentar almacenar informacion");
			e.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error al intentar almacenar imagen");
			ex.printStackTrace();
		}finally {
			try {
				if (conexion!=null) {
					conexion.close();
				}	
				}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "error al intentar cerrar la conexion");
				ex.printStackTrace();
				}
			}
	    
	}
	

	/*el metodo  tipo boolean modifica datos de la pelicula y para esto recibe como @parametro un objeto tipo Movie y lo retorna
	 * Se hace la conexion a la BD y se pasa la sentencia SQL como String 
	 * el objeto conexion invoca el metodo preparateStatement pasando por @parametro la sentencia SQL
	 * el objeto PreparateStatement invoca metodo set y se pasa por @parametro la posicion ocupada en BD y el objeto tipo movie con su metodo get
	 * se cierra el metodo y las conexiones
	 */
	
	
@Override
	public boolean actualizar(Movie elemento) {
		boolean isUpdate = false;
		Connection conexion = getConexion("/cinema");
		String sentenciaSQL = "UPDATE cinema.movies SET mov_titulo = ?, mov_genero = ?, mov_url = ?, mov_imagen = ? WHERE mov_codigo = ?";
		
		try {
			PreparedStatement st = conexion.prepareStatement(sentenciaSQL);
			st.setString(1, elemento.getTitulo());
			st.setString(2, elemento.getGenero().name());
			st.setString(3, elemento.getUrl());
			st.setString(4, elemento.getRutaImagen());
			st.setInt(5, elemento.getCodigo());
			int result = st.executeUpdate();
			if (result==1) {
				isUpdate = true;
			}
			
			st.executeUpdate();
			st.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdate;
	}

     /*
      * metodo void para elminar pelicula, se pasa por @parametro dato tipo Interger que coincide con la Key en BD
      * se crea la conexion y el objeto tipo PrepredStatament e invoca metodo set recibiendo por @paramentro la Key
      * 																																																																																																																																																																																																																																								
      * 
      */
	@Override
	public void eliminar(Integer Key) {
			Connection conexion = getConexion("/cinema");
			String sentenciaSQL = "DELETE FROM cinema.movies WHERE mov_codigo = ?";			
			try {
				PreparedStatement st = conexion.prepareStatement(sentenciaSQL);
				st.setInt(1, Key);
				st.executeUpdate();
			
				st.close();
				conexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	/*
	 * El metodo listar pelicula es de tipo List y retorna el listado movies
	 * se instancia de tipo String la variable que almacena la sentencia SQL
	 * Se encierra en el ciclo While el objeto tipo Resulset con metodo next.
	 * se instancia las variables y objeto tipo Movie
	 * se añade al listado cada objto tipo Movie 
	 * se cierran las conexiones
	 */
	
	@Override
	public List<Movie> listar() {
		List<Movie> movies = new ArrayList <Movie>();
		Connection conexion = getConexion("/cinema");
		String sentenciaSql = "SELECT * FROM movies";
		
		try {
			PreparedStatement st = conexion.prepareStatement(sentenciaSql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()){
				int codigo = resultado.getInt("mov_codigo");
				String titulo = resultado.getString("mov_titulo");
				String generoSeleccion = resultado.getString("mov_genero");
				MovieGenre genero = MovieGenre.valueOf(generoSeleccion.toUpperCase());
				String url = resultado.getString("mov_url");
				String imagen = resultado.getString("mov_imagen");
				Movie searchMovie = new Movie(codigo, titulo, genero, url, imagen);
				movies.add(searchMovie);
			}
			st.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movies;
	}

}
