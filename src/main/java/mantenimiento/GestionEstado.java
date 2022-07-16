package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EstadoInterfaces;
import model.Estado;
import utils.MySQLConexion;

public class GestionEstado implements EstadoInterfaces{

	@Override
	public ArrayList<Estado> listado() {
		ArrayList<Estado> lista = new ArrayList<Estado>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {			
			con = MySQLConexion.getConexion();		
			String sql = "select * from estado";
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();	
			
			while (rs.next()) {
				Estado e = new Estado();
				e.setIdEst(rs.getInt(1));
				e.setDesEst(rs.getString(2));	
				
				lista.add(e);
			}
			
		} catch (Exception e) {
			System.out.println("Error en el listado : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
