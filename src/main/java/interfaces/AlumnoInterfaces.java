package interfaces;

import java.util.ArrayList;

import model.Alumno;

public interface AlumnoInterfaces {

	
	
	
	public int insertAlumno(Alumno a);
	
	public int deleteAlumno(String codigo);
	
	public int updateAlumno(Alumno a);
	
	public ArrayList<Alumno> listAlumno();
	
	
	public Alumno searchAlumno(String cod);
	
	
	
	
	
	
	
	
	
	
}
