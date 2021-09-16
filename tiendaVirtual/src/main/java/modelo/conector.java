package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class conector {
	private static Connection con = null;
	private Iterable<usuario> usuario;

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
	
	//Modulo usuarios

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
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valido;
	}
	
	public usuario consultarUsuario(String cedulaI) {
		conectar();
		usuario usuario = new usuario();
		String consulta = "SELECT * FROM tienda_virtual.usuarios WHERE cedulaUsuario = '" + cedulaI + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			 if (rs.next()) {
				  String id = rs.getString("idusuarios");
				  usuario.setIdUsuario(id);
				  String nombre = rs.getString("nombreUsuario");
				  usuario.setNombreUsuario(nombre);
				  String cedula = rs.getString("cedulaUsuario");
				  usuario.setCedulaUsuario(cedula);
				  String correo = rs.getString("correoUsuario");
				  usuario.setCorreoUsuario(correo);
				  String usuarioC = rs.getString("usuario"); 
				  usuario.setUsuario(usuarioC);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public usuario consultarUsuarioU(String usuario) {
		conectar();
		usuario usuarioU = new usuario();
		String consulta = "SELECT * FROM tienda_virtual.usuarios WHERE usuario = '" + usuario + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			 if (rs.next()) {
				  String nombre = rs.getString("nombreUsuario");
				  usuarioU.setNombreUsuario(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioU;
	}
	
	public void InsertarUsuario(String cedula, String nombre, String correo, String usuario, String contrasena) {
		conectar();

		String consulta = "INSERT INTO tienda_virtual.usuarios (cedulaUsuario,nombreUsuario,correoUsuario,usuario,contrasenaUsuario) VALUES ('" + cedula + "' , '" + nombre + "' , '"+ correo + "' , '"+ usuario + "' , '"+ contrasena + "')";
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}
	
	public void ActualizarUsuario(String cedula, String nombre, String correo, String usuario, String contrasena) {
		conectar();
		usuario idActualiza = consultarUsuario(cedula);
		String id = idActualiza.getIdUsuario();
		String consulta = "UPDATE tienda_virtual.usuarios SET nombreUsuario = '" + nombre + "' , correoUsuario = '"+ correo + "' , usuario = '"+ usuario + "' , contrasenaUsuario = '"+ contrasena + "' WHERE idusuarios = " + id;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}
	
	public void EliminaUsuario(String cedulaE) {
		conectar();
		usuario idElimina = consultarUsuario(cedulaE);
		String id = idElimina.getIdUsuario();
		String consulta = "DELETE FROM tienda_virtual.usuarios WHERE idusuarios = " + id;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}
	
	//Modulo clientes
	
	public cliente consultarCliente(String cedulaI) {
		conectar();
		cliente cliente = new cliente();
		String consulta = "SELECT * FROM tienda_virtual.clientes WHERE cedulaCliente = '" + cedulaI + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			 if (rs.next()) {
				  String cedula = rs.getString("cedulaCliente");
				  cliente.setCedulaCliente(cedula);
				  String nombre = rs.getString("nombreCliente");
				  cliente.setNombreCliente(nombre);
				  String direccion = rs.getString("direccionCliente");
				  cliente.setDireccionCliente(direccion);
				  String telefono = rs.getString("telefonoCliente");
				  cliente.setTelefonoCliente(telefono);
				  String correo = rs.getString("correoCliente"); 
				  cliente.setCorreoCliente(correo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
}
