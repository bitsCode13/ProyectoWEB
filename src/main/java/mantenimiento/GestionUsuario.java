package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterfaces;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterfaces{

	@Override
	public int insertUsuario(Usuario u) {
		int usu = 0;
		Connection con = null ;
		PreparedStatement pst = null ;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_INSERTUSUARIO(null,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getnomUsu());
			pst.setString(2, u.getpasUsu());
			pst.setInt(3, u.getrolUsu());
			pst.setString(4, u.getcodEmp());
			pst.setInt(5, u.getestId());
	
			usu = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Registrar el Usuario "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usu;
	}
	
	@Override
	public int generarCodigo() {
		int codigo = 0;
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(id_usuarios),3) from empleados";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {

				codigo =  rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			System.out.println("Error en generar codigo : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return codigo;
	}

	
	
	
	@Override
	public int updateUsuario(Usuario u) {
		int usu = 0;

		Connection con = null ;
		PreparedStatement pst = null ;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_UPDATEUSUARIO(?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1,u.getcodUsu());
			pst.setString(2, u.getnomUsu());
			pst.setString(3, u.getpasUsu());
			pst.setInt(4, u.getrolUsu());
			pst.setString(5, u.getcodEmp());
			pst.setInt(6, u.getestId());
			
			usu = pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error al Actualizar el Usuario "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usu;
	}
	
	@Override
	public int deleteUsuario(int u) {
		int usu = 0;
		Connection con = null ;
		PreparedStatement pst = null ;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_DELETEUSUARIO(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1,u);
			
			usu = pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error al Eliminar el Usuario "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		
		return usu;
	}
	
	@Override
	public Usuario searchUsuario(int u) {
		
		Usuario usu = null;
		Connection con = null ;
		PreparedStatement pst = null ;
		ResultSet rs = null;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_SEARCHUSUARIO(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1,u);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				 usu = new Usuario();
				usu.setcodUsu(rs.getInt(1));
				usu.setnomUsu(rs.getString(2));
				usu.setpasUsu(rs.getString(3));
				usu.setrolUsu(rs.getInt(4));
				usu.setcodEmp(rs.getString(5));
				usu.setestId(rs.getInt(6));
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error al Buscar un Usuario "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usu ;
	}

	@Override
	public Usuario loginUsuario(String usuario, String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> listUsuario() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			// String sql = "call SP_SEARCHUSUARIOS";
			String sql = "select * from usuarios";
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setcodUsu(rs.getInt(1));
				u.setnomUsu(rs.getString(2));
				u.setpasUsu(rs.getString(3));
				u.setrolUsu(rs.getInt(4));
				u.setcodEmp(rs.getString(5));
				u.setestId(rs.getInt(6));

				lista.add(u);
			}

		} catch (Exception e) {
			System.out.println("Error en el listado : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}
	
}