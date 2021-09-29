package co.edu.unbosque.tiendaVirtual;

import modelo.conector;
import modelo.productos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
 
/**
 * Servlet implementation class UploadServlet
 */

@WebServlet("/FileTest")
public class FileTest extends HttpServlet {
 
	 // Subir directorio de almacenamiento de archivos
	private static final String UPLOAD_DIRECTORY = "C:\\Documentos\\MinTic\\Ciclo3";
 
	 // Cargar configuración
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
 
	/**
	  * Cargar datos y guardar archivos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // detecta si es una carga multimedia
		if (!ServletFileUpload.isMultipartContent(request)) {
			 // detente si no
			PrintWriter writer = response.getWriter();
			 writer.println ("Error: el formulario debe contener enctype = multipart / form-data");
			writer.flush();
			return;
		}
 
		 // Configurar parámetros de carga
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 // Establecer los archivos temporales de umbral de memoria se generarán y almacenarán en el directorio temporal
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		 // Establecer el directorio de almacenamiento temporal
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
		ServletFileUpload upload = new ServletFileUpload(factory);
 
		 // Establecer el valor máximo de carga de archivos
		upload.setFileSizeMax(MAX_FILE_SIZE);
 
		 // Establecer el valor máximo de solicitud (incluidos los datos de archivo y formulario)
		upload.setSizeMax(MAX_REQUEST_SIZE);
 
		 // procesamiento chino
		upload.setHeaderEncoding("UTF-8");
 
		 // Construye una ruta temporal para almacenar archivos cargados
		 // Esta ruta es relativa al directorio actual de la aplicación
		String uploadPath = UPLOAD_DIRECTORY;
 
		 // Crear si el directorio no existe
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
 
		try {
			 // Analiza el contenido solicitado para extraer los datos del archivo
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest((HttpServletRequest) request);
 
			if (formItems != null && formItems.size() > 0) {
				 // iterar sobre los datos del formulario
				for (FileItem item : formItems) {
					 // manejar campos que no están en el formulario
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						 // Salida de la ruta de carga del archivo en la consola
						System.out.println(filePath);
						 // guardar archivo en el disco duro
						item.write(storeFile);
						System.out.println("mensaje ¡Archivo cargado correctamente!");
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
 
		conector conexion;
		conexion = new conector();
		
		List<productos> productos = conexion.leerProductos();
		try {
			Boolean valido = conexion.subirProductos(productos);
			if(valido) {	
			JOptionPane optionPane = new JOptionPane("Los productos se cargaron exitosamente", JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("MinTech");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			response.sendRedirect("cargarProductos.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("Por favor verifique que los proveedores de los productos existan en el sistema", JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("cargarProductos.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}