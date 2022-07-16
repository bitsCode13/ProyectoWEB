package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EmpleadoInterfaces;
import model.Empleado;
import utils.MySQLConexion;

public class GestionEmpleado implements EmpleadoInterfaces {

	@Override
	public int insertEmpleado(Empleado e) {
		int rs = 0; // valor de control en caso de error		
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
			con = MySQLConexion.getConexion();
			// insert into tb_productos values ('P0001','Panadol cj 10',20,1.85,1,1)
			String sql = "{CALL SP_INSERTEMPLEADO(null,?,?,?,?,?,?,?,?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, e.getIdEmple());
			pstm.setString(2, e.getCodEmp());
			pstm.setString(3, e.getNomEmp());
			pstm.setString(4, e.getApeEmp());
			pstm.setInt(5, e.getDocEmp());
			pstm.setInt(6, e.getTelEmp());
			pstm.setString(7, e.getDirEmp());
			pstm.setInt(8, e.getEdadEmp());
			pstm.setInt(9, e.getEstadoEmp());
			
			rs = pstm.executeUpdate();			
			
		} catch (Exception ex) {
			System.out.println("Error en el registro : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs ;
	}

	@Override
	public int updateEmpleado(Empleado e) {
		int rs = 0; 
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
			con = MySQLConexion.getConexion();
			String sql = "{call SP_UPDATEEMPLEADO(?,?,?,?,?,?,?,?,?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, e.getIdEmple());
			pstm.setString(2, e.getCodEmp());
			pstm.setString(3, e.getNomEmp());
			pstm.setString(4, e.getApeEmp());
			pstm.setInt(5, e.getDocEmp());
			pstm.setInt(6, e.getTelEmp());
			pstm.setString(7, e.getDirEmp());
			pstm.setInt(8, e.getEdadEmp());
			pstm.setInt(9, e.getEstadoEmp());
			
			rs = pstm.executeUpdate();			
			
		} catch (Exception ex) {
			System.out.println("Error al actualizar : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int deleteEmpleado(Empleado e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
			con = MySQLConexion.getConexion();
			String sql = "{call SP_DELETEEMPLEADO(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, e.getIdEmple());			
			
			rs = pstm.executeUpdate();			
			
		} catch (Exception ex) {
			System.out.println("Error al eliminar : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Empleado> listado() {
		ArrayList<Empleado> lista = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {			
			con = MySQLConexion.getConexion();
			String sql = "{call SP_SEARCHEMPLEADO(?)}";
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();	
			
			lista = new ArrayList<Empleado>();
			while (rs.next()) {
				Empleado e = new Empleado();
				e.setIdEmple(rs.getInt(1));
				e.setCodEmp(rs.getString(2));
				e.setNomEmp(rs.getString(3));
				e.setApeEmp(rs.getString(4));
				e.setDocEmp(rs.getInt(5));
				e.setTelEmp(rs.getInt(6));
				e.setDirEmp(rs.getString(7));
				e.setEdadEmp(rs.getInt(8));
				e.setEstadoEmp(rs.getInt(9));
							
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
