package dao;

import java.util.List;

//se crea interfaz con los metodos a implementar 
public interface Dao <E, K> {
	
	void crearBD (); //permitira creacion de la Base de Datos en MySQL
	void crearTabla ();  //permitira creacion de la Tabla en MySQL
	E buscarPorCodigo (K Key);  //permitira busqueda de peliculas en la Tabla por codigo
	void insertar (E elemento);  //permitira insertar pelicula
	boolean actualizar (E elemento); //permitira modificar peliculas 
	void eliminar (K Key); //permitira elimianr pelicula 
	List<E> listar (); // listara peliculas 

}
