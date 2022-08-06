package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.codegen.AnnotationTargetTypeConstants;

import mantenimiento.GestionAlumno;
import mantenimiento.GestionApoderado;
import model.Alumno;
import model.Apoderado;

/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet(name = "AluCrud", description = "Mantenedor del la clase Alumno", urlPatterns = { "/AluCrud" })
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
		String accion;
		
		accion = request.getParameter("btnAction");


		
		switch (accion) {
		case "regAlu":registrar(request,response);
			break;
			
		case "actAlu":actualizar(request,response);
		break;
		
		case "eliAlu":eliminar(request,response);
		break;
		
		case "lisAlu":listar(request,response);
		break;
		
		
		case "busAlu":search(request,response);
		break;
		
		case "cargar":cargar(request,response);
		break;
	
		default:
			break;
		}
			
		
		
		
		
			
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String cod = request.getParameter("codList");
		
		
		GestionAlumno gstAlu = new GestionAlumno();
		
		Alumno a = gstAlu.searchAlumno(cod);
		

		
		//CARGAR COMBO BOX
		GestionApoderado gesAp = new GestionApoderado();
		ArrayList< Apoderado> lstApo=gesAp.listApoderado();
		request.setAttribute("lstApo", lstApo);

		request.setAttribute("readonly", "readonly");
		
		request.setAttribute("a", a);
		request.getRequestDispatcher("alumnoRegistro.jsp").forward(request, response);
		
		
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
			
		GestionApoderado gesAp = new GestionApoderado();
	
		ArrayList< Apoderado> lstApo=gesAp.listApoderado();
		
		request.setAttribute("lstApo", lstApo);
		
		
		request.getRequestDispatcher("alumnoRegistro.jsp").forward(request, response);
		
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionAlumno gstAl = new GestionAlumno();
		
		ArrayList<Alumno> lstAlu = gstAl.listAlumno();
		
		
		request.setAttribute("lstAlu", lstAlu);
		
		request.getRequestDispatcher("alumnoListado.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String cod = request.getParameter("codAlu");
		
		
		Alumno a = new Alumno();
		
		a.setCod_alumno(cod);
	
		
		GestionAlumno ga = new GestionAlumno();
		
		int ok = ga.deleteAlumno(cod);
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al eliminar , ' Alumno tiene una Matricula' "
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "Eliminación Exitosa"
					+ "</div>");
		}
		
		
		
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo=request.getParameter("codAlu");
		String nombre=request.getParameter("nomAlu");
		String ape_paterno=request.getParameter("apepaAlu");
		String ape_materno=request.getParameter("apemaAlu");
		int dni= Integer.parseInt(request.getParameter("dniAlu"));
		String fecha=request.getParameter("fechAlu");
		int edad= Integer.parseInt(request.getParameter("edadAlu"));
		String nacio=request.getParameter("nacioAlu");
		String domi=request.getParameter("domiAlu");
		int telf= Integer.parseInt(request.getParameter("telAlu"));
		String sexo=request.getParameter("sexAlu");
		int id_Apoderado= Integer.parseInt(request.getParameter("cboApoderado"));
		int estado= Integer.parseInt(request.getParameter("cboEstado"));
		
		
		Alumno a = new Alumno();
		
		
		a.setCod_alumno(codigo);
		a.setNombres(nombre);
		a.setApe_paterno(ape_paterno);
		a.setApe_materno(ape_materno);
		a.setDocumento(dni);
		a.setFecha_naci(fecha);
		a.setEdad(edad);
		a.setNacionalidad(nacio);
		a.setDomicilio(domi);
		a.setTelefono(telf);
		a.setSexo(sexo);
		a.setId_apoderado(id_Apoderado);
		a.setEstado_id_estado(estado);
		
		
		GestionAlumno gstA = new GestionAlumno();
		int ok =gstA.updateAlumno(a);
		
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al Actualizar"
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "  Alumno Actualizado"
					+ "</div>");
		}
		
		request.getRequestDispatcher("alumnoRegistro.jsp").forward(request, response);
		
		
		
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo=request.getParameter("codAlu");
		String nombre=request.getParameter("nomAlu");
		String ape_paterno=request.getParameter("apepaAlu");
		String ape_materno=request.getParameter("apemaAlu");
		int dni= Integer.parseInt(request.getParameter("dniAlu"));
		String fecha=request.getParameter("fechAlu");
		int edad= Integer.parseInt(request.getParameter("edadAlu"));
		String nacio=request.getParameter("nacioAlu");
		String domi=request.getParameter("domiAlu");
		int telf= Integer.parseInt(request.getParameter("telAlu"));
		String sexo=request.getParameter("sexAlu");
		int id_Apoderado= Integer.parseInt(request.getParameter("cboApoderado"));
		int estado= Integer.parseInt(request.getParameter("cboEstado"));
		
		
		Alumno a = new Alumno();
		
		
		a.setCod_alumno(codigo);
		a.setNombres(nombre);
		a.setApe_paterno(ape_paterno);
		a.setApe_materno(ape_materno);
		a.setDocumento(dni);
		a.setFecha_naci(fecha);
		a.setEdad(edad);
		a.setNacionalidad(nacio);
		a.setDomicilio(domi);
		a.setTelefono(telf);
		a.setSexo(sexo);
		a.setId_apoderado(id_Apoderado);
		a.setEstado_id_estado(estado);
		
		
		GestionAlumno gstA = new GestionAlumno();
		int ok =gstA.insertAlumno(a);
		
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al Registrar"
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "  Alumno Registrado"
					+ "</div>");
		}
		
		request.getRequestDispatcher("alumnoRegistro.jsp").forward(request, response);
		
		
		
	}

}
