package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import interfaces.AlumnoInterfaces;
import model.Alumno;
import utils.MySQLConexion;

public class GestionAlumno implements AlumnoInterfaces {

	@Override
	public int insertAlumno(Alumno a) {


		int res=0;
		
		Connection con=null ;
		PreparedStatement pst = null;
		
		
		try {
			
			con= MySQLConexion.getConexion();
			String sql = "{call Insert_Alumno(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1,a.getCod_alumno() );
			pst.setString(2,a.getNombres() );
			pst.setString(3,a.getApe_paterno() );
			pst.setString(4,a.getApe_materno() );
			pst.setInt(5, a.getDocumento());
			pst.setString(6,a.getFecha_naci() );
			pst.setInt(7, a.getEdad());
			pst.setString(8,a.getNacionalidad() );
			pst.setString(9,a.getDomicilio() );
			pst.setInt(10, a.getTelefono());
			pst.setString(11,a.getSexo() );
			pst.setInt(12, a.getId_apoderado());
			pst.setInt(13, a.getEstado_id_estado());
			
			res= pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error al Registrar el Alumno "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con)	;
		}
		
		
		
		
		
		return res;
	}

	@Override
	public int deleteAlumno(String codigo) {


		int res=0;
		
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			
			con=MySQLConexion.getConexion();
			String sql="{call Delete_Alumno(?) }";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, codigo);
					
		res=pst.executeUpdate();
			
			
		} catch (Exception e) {
			
			System.out.println("Error al Eliminar el Alumno "+e.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		
		return res;
	}

	@Override
	public int updateAlumno(Alumno a) {

		
		int res=0;
		
		Connection con=null ;
		PreparedStatement pst = null;
		
		
		try {
			
			con= MySQLConexion.getConexion();
			String sql = "{call Update_Alumno(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1,a.getCod_alumno() );
			pst.setString(2,a.getNombres() );
			pst.setString(3,a.getApe_paterno() );
			pst.setString(4,a.getApe_materno() );
			pst.setInt(5, a.getDocumento());
			pst.setString(6,a.getFecha_naci() );
			pst.setInt(7, a.getEdad());
			pst.setString(8,a.getNacionalidad() );
			pst.setString(9,a.getDomicilio() );
			pst.setInt(10, a.getTelefono());
			pst.setString(11,a.getSexo() );
			pst.setInt(12, a.getEstado_id_estado());
			pst.setInt(13, a.getId_apoderado());
			
			
			res= pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error al Actualizar el Alumno "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con)	;
		}
		
		return res;
	
	}

	@Override
	public ArrayList<Alumno> listAlumno() {
		
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Alumno al ;
		
		Connection con= null;
		PreparedStatement pst=null;
		ResultSet res = null;
		
		
		try {
				
			con= MySQLConexion.getConexion();
			String sql = "select * from alumnos";
			pst = con.prepareStatement(sql);
			
			res = pst.executeQuery();
			
			while (res.next()) {
				
				al= new Alumno();
				
				al.setCod_alumno(res.getString(2));
				al.setNombres(res.getString(3));
				al.setApe_paterno(res.getString(4));
				al.setApe_materno(res.getString(5));
				al.setDocumento(res.getInt(6));
				al.setFecha_naci(res.getString(7));
				al.setEdad(res.getInt(8));
				al.setNacionalidad(res.getString(9));
				al.setDomicilio(res.getString(10));
				al.setTelefono(res.getInt(11));
				al.setSexo(res.getString(12));
				al.setId_apoderado(res.getInt(13));
				al.setEstado_id_estado(14);
				
				
				lista.add(al);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error al Listar el Alumno "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

	/**
	 *
	 */
	@Override
	public Alumno searchAlumno(String cod) {
		
		
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Alumno al= null ;
		
		Connection con= null;
		PreparedStatement pst=null;
		ResultSet res = null;
		
		
		try {
				
			con= MySQLConexion.getConexion();
			String sql = "{CALL Search_Alumno(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setString(1,cod);
			
			res = pst.executeQuery();
			
			if (res.next()) {
				
				al= new Alumno();
				
				al.setCod_alumno(res.getString(2));
				al.setNombres(res.getString(3));
				al.setApe_paterno(res.getString(4));
				al.setApe_materno(res.getString(5));
				al.setDocumento(res.getInt(6));
				al.setFecha_naci(res.getString(7));
				al.setEdad(res.getInt(8));
				al.setNacionalidad(res.getString(9));
				al.setDomicilio(res.getString(10));
				al.setTelefono(res.getInt(11));
				al.setSexo(res.getString(12));
				al.setId_apoderado(res.getInt(13));
				al.setEstado_id_estado(14);
				
				

			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error al Buscar el Alumno "+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return al;
		

	}

	
	
	
	
	
	
}
