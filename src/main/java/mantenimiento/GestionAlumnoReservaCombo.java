package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.AlumnoReservaComboInterface;
import model.AlumnoReservaCombo;
import utils.MySQLConexion;

public class GestionAlumnoReservaCombo implements AlumnoReservaComboInterface {

	@Override
	public ArrayList<AlumnoReservaCombo> listado() {
		ArrayList<AlumnoReservaCombo> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {			
			con = MySQLConexion.getConexion();		
			String sql = "{CALL SP_LISTADOALUMNOSCOMBO()}";
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();	
			
			while (rs.next()) {
				AlumnoReservaCombo arc = new AlumnoReservaCombo();
				arc.setCodAlu(rs.getString(1));
				arc.setNomAlu(rs.getString(2));	
				
				lista.add(arc);
			}
			
		} catch (Exception e) {
			System.out.println("Error en el listado para alumno reserva : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
