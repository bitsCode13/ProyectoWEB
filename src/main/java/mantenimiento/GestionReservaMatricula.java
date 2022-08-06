package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReservaMatriculaInterface;
import model.ReservaMatricula;
import utils.MySQLConexion;

public class GestionReservaMatricula implements ReservaMatriculaInterface {

	@Override
	public int insertReserva(ReservaMatricula rm) {
		int rs = 0; // valor de control en caso de error
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{CALL SP_INSERTRESERVAMATRICULA(null,?,curdate(),?,?,?)}";
			pstm = con.prepareStatement(sql);
			
			rm.setCodRes(generarCodigoReserva());
			
			pstm.setString(1, rm.getCodRes());
			pstm.setDouble(2, rm.getCueRes());
			pstm.setString(3, rm.getCodAlu());
			pstm.setInt(4, rm.getIdEst());
			
			rs = pstm.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en el registro : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int updateReserva(ReservaMatricula rm) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call SP_UPDATERESERVAMATRICULA(?,?,curdate(),?,?,?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, rm.getIdRes());
			pstm.setString(2, rm.getCodRes());
			pstm.setDouble(3, rm.getCueRes());
			pstm.setString(4, rm.getCodAlu());
			pstm.setInt(5, rm.getIdEst());

			rs = pstm.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al actualizar : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<ReservaMatricula> listadoReserva() {
		ArrayList<ReservaMatricula> lista = new ArrayList<ReservaMatricula>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from reservamatricula";
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				ReservaMatricula rm = new ReservaMatricula();
				rm.setIdRes(rs.getInt(1));
				rm.setCodRes(rs.getString(2));
				rm.setFecReg(rs.getString(3));
				rm.setCueRes(rs.getDouble(4));
				rm.setCodAlu(rs.getString(5));
				rm.setIdEst(rs.getInt(6));

				lista.add(rm);
			}

		} catch (Exception e) {
			System.out.println("Error en el listado : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}
	
	@Override
	public ReservaMatricula buscar(int idRes) {
		ReservaMatricula rm = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{CALL SP_SEARCHRESERVAMATRICULA(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idRes);

			rs = pstm.executeQuery();

			if (rs.next()) {
				rm = new ReservaMatricula();
				rm.setIdRes(rs.getInt(1));
				rm.setCodRes(rs.getString(2));
				rm.setFecReg(rs.getString(3));
				rm.setCueRes(rs.getDouble(4));
				rm.setCodAlu(rs.getString(5));
				rm.setIdEst(rs.getInt(6));
				
			}

		} catch (Exception ex) {
			System.out.println("Error al buscar Reserva : " + ex.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rm;
	}

	@Override
	public String generarCodigoReserva() {
		String codigo = "RES00001";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(cod_reserva),4) from reservamatricula;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {

				codigo = String.format("RES%05d", rs.getInt(1) + 1);
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

	

}
