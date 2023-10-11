package dao.imp;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.JOptionPane;
import dao.ConexionMySql;
import dao.Dao;
import entitties.Movie;
import entitties.MovieGenre;
import util.GestorArchivos;


public class MovieDaoImp implements ConexionMySql, Dao<Movie, Integer> {

	public MovieDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crearBD () {
		String sentenciaSQL = "CREATE DATABASE cinema";
		Connection conexion = getConexion("");
		try {
			
			Statement st = conexion.createStatement();
		    st.executeUpdate(sentenciaSQL);
			st.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear Base de dato");
			e.printStackTrace();
		}
		
	}
	
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
