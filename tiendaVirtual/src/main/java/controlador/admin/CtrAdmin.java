package controlador.admin;

import modelo.conector.conector;
import modelo.usuario.usuario;

public class CtrAdmin {
	
	//private conector conexion;
	private Iterable<usuario> usuario;
	
	public usuario consultaUsuario(String cedula) {
		for(usuario usuario: usuario){
            if(usuario.getCedulaUsuario().equals(cedula)){
                return usuario;
            }        
        }
		return null;
	}
	
	public void agregar(Integer cedula, String nombreUsuario, String correoUsuario, String usuario, String contrasenaUsuario) {
	
	}

}
