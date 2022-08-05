package interfaces;

import java.util.ArrayList;

import model.ReservaMatricula;

public interface ReservaMatriculaInterface {

	public int insertReserva(ReservaMatricula rm);

	public int updateReserva(ReservaMatricula rm);

	public ArrayList<ReservaMatricula> listadoReserva();

	// Buscar por codigo
	public ReservaMatricula buscar (int idRes);
	
	// Generar c�digo automatico
	public String generarCodigoReserva();
}
