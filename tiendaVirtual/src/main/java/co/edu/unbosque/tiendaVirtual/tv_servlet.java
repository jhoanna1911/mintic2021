package co.edu.unbosque.tiendaVirtual;

import modelo.cliente;
import modelo.conector;
import modelo.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class tv_servlet
 */
@WebServlet("/tv_servlet")
public class tv_servlet extends HttpServlet {

	private conector conexion;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tv_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		conexion = new conector();

		

		String Usuario = request.getParameter("Usuario");
		String Contrasena = request.getParameter("Contrasena");
		
		// Modulo usuarios
		
		String botonConsultaUsuario = request.getParameter("cedulaUsuario");

		String CreaCedula = request.getParameter("CreaCedula");
		String Creanombre = request.getParameter("Creanombre");
		String CreaCorreo = request.getParameter("CreaCorreo");
		String CreaUsuario = request.getParameter("CreaUsuario");
		String CreaContrasena = request.getParameter("CreaContrasena");

		String ActualizaCedula = request.getParameter("ActualizaCedula");
		String Actualizanombre = request.getParameter("Actualizanombre");
		String ActualizaCorreo = request.getParameter("ActualizaCorreo");
		String ActualizaUsuario = request.getParameter("ActualizaUsuario");
		String ActualizaContrasena = request.getParameter("ActualizaContrasena");

		String cedulaBorrar = request.getParameter("cedulaBorrar");
		
		// Modulo clientes
		
		String botonConsultaCliente = request.getParameter("cedulaCliente");

		Boolean validaUsuario = conexion.validarUsuario(Usuario, Contrasena);
		RequestDispatcher rd;

		if (validaUsuario) {
			rd = request.getRequestDispatcher("/administracion.jsp");
			rd.forward(request, response);
		}

		else if (!validaUsuario && Usuario != null) {
			JOptionPane optionPane = new JOptionPane("Verifique los datos de ingreso", JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("MinTech");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			response.sendRedirect("index.jsp");
		}

		// Modulo usuarios
		//Consulta usuario
		
		else if (botonConsultaUsuario != null) {

			usuario usuario = conexion.consultarUsuario(botonConsultaUsuario);
			String nombreUsuario = usuario.getNombreUsuario();
			String cedulaUsuario = usuario.getCedulaUsuario();
			String correoUsuario = usuario.getCorreoUsuario();
			String usuarioConsulta = usuario.getUsuario();
			if (nombreUsuario != null) {
				JOptionPane optionPane = new JOptionPane("Nombre: " + nombreUsuario + "\n" + "Cedula: " + cedulaUsuario
						+ "\n" + "Correo: " + correoUsuario + "\n" + "Usuario: " + usuarioConsulta + "\n");
				JDialog dialog = optionPane.createDialog("Consulta");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarUsuario.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarUsuario.jsp");
			}
		}

		else if (CreaUsuario != null && CreaContrasena != null && CreaCedula != null) {
			usuario cedula = conexion.consultarUsuario(CreaCedula);
			String cedulaCrear = cedula.getCedulaUsuario();
			usuario usuario = conexion.consultarUsuarioU(CreaUsuario);
			String usuarioCrear = usuario.getCedulaUsuario();
			if (cedulaCrear != null) {
				JOptionPane optionPane = new JOptionPane("La cedula ingresada ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			} else if (usuarioCrear != null) {
				JOptionPane optionPane = new JOptionPane("El usuario ingresada ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			} else {
				conexion.InsertarUsuario(CreaCedula, Creanombre, CreaCorreo, CreaUsuario, CreaContrasena);
				JOptionPane optionPane = new JOptionPane("Usuario creado exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			}
		}

		else if (ActualizaCedula != null) {
			usuario cedula = conexion.consultarUsuario(ActualizaCedula);
			String actualizaCedula = cedula.getCedulaUsuario();
			if (actualizaCedula != null) {
				conexion.ActualizarUsuario(ActualizaCedula, Actualizanombre, ActualizaCorreo, ActualizaUsuario,
						ActualizaContrasena);
				JOptionPane optionPane = new JOptionPane(
						"El usuario " + ActualizaUsuario + " se actualizo exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarUsuario.jsp");
			} else {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario que desea actualizar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarUsuario.jsp");
			}

		}

		else if (cedulaBorrar != null) {
			usuario cedula = conexion.consultarUsuario(cedulaBorrar);
			String eliminaCedula = cedula.getCedulaUsuario();
			if (eliminaCedula == null) {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario que desea eliminar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarUsuario.jsp");
			} else {
				conexion.EliminaUsuario(cedulaBorrar);
				JOptionPane optionPane = new JOptionPane(
						"Se ha eliminado el usuario con numero de cedula " + cedulaBorrar);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarUsuario.jsp");
			}
		}
		
		//Modulo clientes
		//Consulta cliente
		
		else if (botonConsultaCliente != null) {

			cliente cliente = conexion.consultarCliente(botonConsultaCliente);
			String nombreCliente = cliente.getNombreCliente();
			String cedulaCliente = cliente.getCedulaCliente();
			String correoCliente = cliente.getCorreoCliente();
			String telefonoCliente = cliente.getTelefonoCliente();
			String direccionCliente = cliente.getDireccionCliente();
			if (nombreCliente != null) {
				JOptionPane optionPane = new JOptionPane("Nombre: " + nombreCliente + "\n" + "Cedula: " + cedulaCliente
						+ "\n" + "Correo: " + correoCliente + "\n" + "Teléfono: " + telefonoCliente + "\n" +  "Dirección: " + direccionCliente + "\n");
				JDialog dialog = optionPane.createDialog("Cliente");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarCliente.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("La cedula del cliente no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarCliente.jsp");
			}
		}
		
	}

}
