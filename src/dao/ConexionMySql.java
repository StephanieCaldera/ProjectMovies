package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 //se crea una interfaz de conexion con la base de datos MySQL
public interface ConexionMySql {
   //método con retorno objeto de tipo conexion
	default Connection getConexion(String conexBD ) {
		Connection conexion = null;

		try {
			//se almacenan los datos de conexion en variables
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306" + conexBD;
			String USUARIO = "root";
			String CLAVE = "";
			Class.forName(DRIVER);
			
			//se inicializa el objeto conexion.
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexion;
	}

}
