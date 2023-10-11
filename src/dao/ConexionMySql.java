package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConexionMySql {
   //creando data source
	default Connection getConexion(String conexBD ) {
		Connection conexion = null;

		try {
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306" + conexBD;
			String USUARIO = "root";
			String CLAVE = "";
			Class.forName(DRIVER);
			
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexion;
	}

}
