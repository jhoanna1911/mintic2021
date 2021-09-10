package modelo.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conector {
	private static Connection con = null;

	public static void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda_virtual", "root", "abc123");
			System.out.println("Conexion exitosa con la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el controlador de conexión" + e);
		} catch (SQLException e) {
			System.out.println("No se puede conectar con la base de datos");
			e.printStackTrace();
		}
	}

	public Boolean validarUsuario(String usuario, String contrasena) {
		conectar();
		Boolean valido = false;
		String consultaU = "SELECT contrasenaUsuario FROM tienda_virtual.usuarios WHERE usuario = '" + usuario + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consultaU);
			if (rs.next()) {
				String contrasenaI = rs.getString("contrasenaUsuario");
				if (contrasenaI.equals(contrasena)) {
					valido = true;
				}
				else {	
					System.out.println("La contrasena ingresada es incorrecta");
				}
			} else {
				System.out.println("El usuario no existe");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valido;
	}
}
