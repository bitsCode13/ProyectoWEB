package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterfaces {

	public int insertUsuario(Usuario u);
	
	public int updateUsuario(Usuario u);
	
	public int deleteUsuario(Usuario u);
	
	public Usuario searchUsuario(int u);
	
	public Usuario loginUsuario(String usuario, String clave);
	
	ArrayList<Usuario> listUsuario(int u);
}
