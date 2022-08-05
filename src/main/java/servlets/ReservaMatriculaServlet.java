package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.GestionAlumnoReservaCombo;
import mantenimiento.GestionEstado;
import mantenimiento.GestionReservaMatricula;
import model.AlumnoReservaCombo;
import model.Estado;
import model.ReservaMatricula;

/**
 * Servlet implementation class ReservaMatriculaServlet
 */
@WebServlet(name = "reservaMatricula", urlPatterns = { "/reservaMatricula" })
public class ReservaMatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaMatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion;
		accion = request.getParameter("btnAccion");
		System.out.println("Acción seleccionada: " + accion);
		
		switch (accion) {
		case "reg": // proceso de registrar (request, response); --> recibir y enviar datos
			registrar(request, response);
			break;
		case "act":
			actualizar(request, response);
			break;
		case "lst":
			listar(request, response);
			break;
		case "cargar":
			cargar(request, response);
			break;
		case "buscar":
			buscar(request, response);
			break;
		case "listado":
			muestraListado(request, response);
			break;
		default:
			break;
		}
	}

	private void muestraListado(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer el codigo de la reserva a buscar
		int idRes = Integer.parseInt(request.getParameter("cod"));
		
		GestionReservaMatricula grm = new GestionReservaMatricula();
		ReservaMatricula rm = grm.buscar(idRes);
		
		// Enviar el OBJ ReservaMatricula como atributo
		request.setAttribute("rm", rm);
		
		// Actualiza el listado para el combo
		GestionAlumnoReservaCombo gar = new GestionAlumnoReservaCombo();
		ArrayList<AlumnoReservaCombo> lstAlumnos = gar.listado();
		request.setAttribute("lstAlumnos", lstAlumnos);
		
		GestionEstado gEst = new GestionEstado();
		ArrayList<Estado> lstEstados = gEst.listado();
		request.setAttribute("lstEstados", lstEstados);
	
		// Reenviar a la página
		request.getRequestDispatcher("registroReservaMatricula.jsp").forward(request, response);
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener los listados para el combo
		GestionAlumnoReservaCombo gar = new GestionAlumnoReservaCombo();
		ArrayList<AlumnoReservaCombo> lstAlumnos = gar.listado();
		request.setAttribute("lstAlumnos", lstAlumnos);
		
		GestionEstado gEst = new GestionEstado();
		ArrayList<Estado> lstEstados = gEst.listado();
		request.setAttribute("lstEstados", lstEstados);
		
		// Enviar el listado a la página
		request.getRequestDispatcher("registroReservaMatricula.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionReservaMatricula grm = new GestionReservaMatricula();
		ArrayList<ReservaMatricula> lista = grm.listadoReserva();
		
		// Enviar el listado
		request.setAttribute("lstReservas", lista);
		
		// redireccionar
		request.getRequestDispatcher("listadoReservasMatricula.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String codRes, codAlu;
		int idRes, idEst;
		double cueRes;
		
		// Leer datos
		idRes = Integer.parseInt(request.getParameter("txtIdRes"));
		codRes = request.getParameter("txtCodRes");
		cueRes = Double.parseDouble(request.getParameter("txtMontPag"));
		codAlu = request.getParameter("cboAlumno");
		idEst = Integer.parseInt(request.getParameter("cboEstado"));
		
		// Proceso
		ReservaMatricula rm = new ReservaMatricula();
		rm.setIdRes(idRes);
		rm.setCodRes(codRes);
		rm.setCueRes(cueRes);
		rm.setCodAlu(codAlu);
		rm.setIdEst(idEst);
		System.out.println("Datos: " + rm); // Llama por default al toString()
		
		GestionReservaMatricula grm = new GestionReservaMatricula();
		int ok = grm.updateReserva(rm);
		
		if (ok == 0) {
			// mensaje error
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Error al actualizar Reserva!</div>");
			} else {
				request.setAttribute("mensaje",
					"<div class='alert alert-success' role='alert'>" + "Reserva Actualizada!</div>");
		}
		
		// Salida
		request.getRequestDispatcher("registroReservaMatricula.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String codRes, codAlu;
		int idEst;
		double cueRes;
		
		// Leer Datos
		
		codRes = request.getParameter("txtCodRes");
		cueRes = Double.parseDouble(request.getParameter("txtMontPag"));
		codAlu = request.getParameter("cboAlumno");
		idEst = Integer.parseInt(request.getParameter("cboEstado"));
		
		// Proceso
		
		ReservaMatricula rm = new ReservaMatricula();
		rm.setCodRes(codRes);
		rm.setCueRes(cueRes);
		rm.setCodAlu(codAlu);
		rm.setIdEst(idEst);
		System.out.println("Datos: " + rm);
		
		// Llamar
		GestionReservaMatricula grm = new GestionReservaMatricula();
		int ok = grm.insertReserva(rm);
		
		if (ok == 0) {
			// mensaje error
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Error al registrar Reserva!</div>");
			} else {
				request.setAttribute("mensaje",
					"<div class='alert alert-success' role='alert'>" + "Reserva registrada!</div>");
		}
		
		// Salida
		request.getRequestDispatcher("registroReservaMatricula.jsp").forward(request, response);
		
	}

}
