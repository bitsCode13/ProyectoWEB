package interfaces;
import java.util.ArrayList;
import model.Empleado;

public interface EmpleadoInterfaces {
	
	public int insertEmpleado(Empleado e);
	
	public int updateEmpleado(Empleado e);
	
	public int deleteEmpleado(Empleado e);
	
	public ArrayList<Empleado> listado(); 
	
	// Buscar por codigo
	public Empleado buscar (int idEmp);
	
	// Generar c�digo automatico
	public String generarCodigo();
	
	// filtro
	public ArrayList<Empleado> listado(int estado);
	
}
