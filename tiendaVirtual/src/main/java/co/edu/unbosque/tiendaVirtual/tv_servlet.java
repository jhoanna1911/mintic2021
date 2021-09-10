package co.edu.unbosque.tiendaVirtual;

import modelo.conector.conector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	response.getWriter().append("Served at: ").append(request.getContextPath());
		String Usuario = request.getParameter("Usuario");
		String Contrasena = request.getParameter("Contrasena");
		PrintWriter writer = response.getWriter();
		
		if (Usuario != null && Contrasena != null) {
			writer.println("Bienvenido " + Usuario + " a la tienda virtual");
		}
		else 
			writer.println("Debe llenar todos los campos");  */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		conexion = new conector();
		String Usuario = request.getParameter("Usuario");
		String Contrasena = request.getParameter("Contrasena");
		
		Boolean validaUsuario = conexion.validarUsuario(Usuario, Contrasena);
		
		if(validaUsuario) {
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("/administracion.jsp");
			rd.forward(request, response);
		}
		else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			PrintWriter writer = response.getWriter();
			writer.println("Datos invalidos");
		}
		
		
		
		// doGet(request, response);
	}

}
