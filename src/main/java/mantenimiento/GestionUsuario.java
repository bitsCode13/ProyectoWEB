package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			String sql = "{CALL SP_INSERTUsuario(null,?,?,?,?,?)}";
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
	public int updateUsuario(Usuario u) {
		int usu = 0;

		Connection con = null ;
		PreparedStatement pst = null ;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_UPDATEUsuario(?,?,?,?,?,?)}";
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
	public int deleteUsuario(Usuario u) {
		int usu = 0;
		Connection con = null ;
		PreparedStatement pst = null ;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "{CALL SP_DELETEUsuario(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getnomUsu());
			
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
			
			String sql = "{CALL SP_SEARCHUsuario(?)}";
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
	public ArrayList<Usuario> listUsuario(int a) {
		// TODO Auto-generated method stub
		return null;
	}
}