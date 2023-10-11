package dao;

import java.util.List;

public interface Dao <E, K> {
	//implementando Dao
	
	void crearBD ();
	void crearTabla ();
	E buscarPorCodigo (K Key);
	void insertar (E elemento);
	boolean actualizar (E elemento);
	void eliminar (K Key);
	List<E> listar (); 

}
