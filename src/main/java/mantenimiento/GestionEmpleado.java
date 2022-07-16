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
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {			
			con = MySQLConexion.getConexion();
			//String sql = "call SP_SEARCHEMPLEADO";
			String sql = "select * from empleados";
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();	
			
			while (rs.next()) {
				Empleado emp = new Empleado();
				emp.setIdEmple(rs.getInt(1));
				emp.setCodEmp(rs.getString(2));
				emp.setNomEmp(rs.getString(3));
				emp.setApeEmp(rs.getString(4));
				emp.setDocEmp(rs.getInt(5));
				emp.setTelEmp(rs.getInt(6));
				emp.setDirEmp(rs.getString(7));
				emp.setEdadEmp(rs.getInt(8));
				emp.setEstadoEmp(rs.getInt(9));
							
				lista.add(emp);
			}
			
		} catch (Exception e) {
			System.out.println("Error en el listado : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public Empleado buscar(int idEmp) {
		Empleado e = null;
		Connection con = null;
		PreparedStatement pstm = null;		
		ResultSet rs = null;
		try {			
			con = MySQLConexion.getConexion();		
			String sql = "{CALL SP_SEARCHEMPLEADO(?)}";
			pstm = con.prepareStatement(sql);	
			pstm.setInt(1, idEmp);	
			
			rs = pstm.executeQuery();				
			
			if(rs.next()) { 			
				e = new Empleado(); 				
				e.setIdEmple(rs.getInt(1));
				e.setCodEmp(rs.getString(2));
				e.setNomEmp(rs.getString(3));
				e.setApeEmp(rs.getString(4));
				e.setDocEmp(rs.getInt(5));
				e.setTelEmp(rs.getInt(6));
				e.setDirEmp(rs.getString(7));
				e.setEdadEmp(rs.getInt(8));
				e.setEstadoEmp(rs.getInt(9));
									   	
			}
			
		} catch (Exception ex) {
			System.out.println("Error en el listado : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return e;
	}

}
