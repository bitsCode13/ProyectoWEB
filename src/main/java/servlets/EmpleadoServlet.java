package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.GestionEmpleado;
import mantenimiento.GestionEstado;
import model.Empleado;
import model.Estado;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet(name = "registroEmpleado", urlPatterns = { "/registroEmpleado" })
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
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
		
		// Segun la acción selecionada, realizar procesos
		
		switch (accion) {
		case "reg": // proceso de registrar (request, response); --> recibir y enviar datos
			registrar(request, response);
			break;
		case "act":
			actualizar(request, response);
			break;
		case "eli":
			eliminar(request, response);
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
		default:
			break;
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Leer el codigo del producto a buscar
		int idEmp = Integer.parseInt(request.getParameter("cod")) ;
		
		GestionEmpleado ge = new GestionEmpleado();
		Empleado e = ge.buscar(idEmp);
		
		// Enviar el OBJ Empleado como atributo
		request.setAttribute("e", e);
		
		// Actualiza el listado para el combo
		GestionEstado gEst = new GestionEstado();
		ArrayList<Estado> lstEstados = gEst.listado();
		request.setAttribute("lstEstados", lstEstados);
		
		// reenviar a la pagina
		request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener los listados para el combo
		GestionEstado gEst = new GestionEstado();
		ArrayList<Estado> lstEstados = gEst.listado();
		request.setAttribute("lstEstados", lstEstados);
		
		
		
		// Enviar el listado a la página --> registroEmpleado
		request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionEmpleado ge = new GestionEmpleado();
		ArrayList<Empleado> lista = ge.listado();
		
		// Enviar el listado a la pagina --> como atributo
		request.setAttribute("lstEmpleados", lista);
		
		// redireccionar a la página donde se mostrara el listado		
		request.getRequestDispatcher("listadoEmpleado.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variable
		int idEmp;
		
		// Leer datos
		idEmp = Integer.parseInt(request.getParameter("txtIdEmp"));
		
		// Proceso
		Empleado e = new Empleado();
		e.setIdEmple(idEmp);
		System.out.println("Datos: " + e);
		
		GestionEmpleado ge = new GestionEmpleado();
		int ok = ge.deleteEmpleado(e);
		
		if (ok == 0) {
			// mensaje error
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Error al eliminar!</div>");
		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>"
					+ "Empleado ha cambiado de estado a Separado!</div>");
		}

		// salida
		request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String codEmp, nomEmp, apeEmp, dirEmp;
		int idEmple, docEmp, telEmp, edadEmp, estEmp;
		
		// Leer Datos
		idEmple = Integer.parseInt(request.getParameter("txtIdEmp"));
		codEmp = request.getParameter("txtCodEmp");		
		nomEmp = request.getParameter("txtNomEmp");
		apeEmp = request.getParameter("txtApeEmp");
		docEmp = Integer.parseInt(request.getParameter("txtDniEmp"));
		telEmp = Integer.parseInt(request.getParameter("txtTelEmp"));
		dirEmp = request.getParameter("txtDirEmp");
		edadEmp = Integer.parseInt(request.getParameter("txtEdaEmp"));
		estEmp = Integer.parseInt(request.getParameter("cboEstado"));
		
		// Proceso
		Empleado e = new Empleado();
		e.setIdEmple(idEmple);
		e.setCodEmp(codEmp);
		e.setNomEmp(nomEmp);
		e.setApeEmp(apeEmp);
		e.setDocEmp(docEmp);
		e.setTelEmp(telEmp);
		e.setDirEmp(dirEmp);
		e.setEdadEmp(edadEmp);
		e.setEstadoEmp(estEmp);
		System.out.println("Datos: " +e); // Llama por default --> toString()
		
		GestionEmpleado ge = new GestionEmpleado();
		int ok = ge.updateEmpleado(e);
		
		if (ok == 0) {
			// mensaje error
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Error al actualizar!</div>");
		} else {
			request.setAttribute("mensaje",
					"<div class='alert alert-success' role='alert'>" + "Empleado actualizado!</div>");
		}

		// salida
		request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String codEmp, nomEmp, apeEmp, dirEmp;
		int /*idEmple*/ docEmp, telEmp, edadEmp, estEmp;
		
		// Leer Datos
		//idEmple = Integer.parseInt(request.getParameter("txtIdEmp"));
		
		codEmp = request.getParameter("txtCodEmp");
		/*if(!codEmp.matches("EM[0-9]{4}")) {
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Ingrese Código</div>");
			request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
			return;
		}*/
		nomEmp = request.getParameter("txtNomEmp");
		apeEmp = request.getParameter("txtApeEmp");
		docEmp = Integer.parseInt(request.getParameter("txtDniEmp"));
		telEmp = Integer.parseInt(request.getParameter("txtTelEmp"));
		dirEmp = request.getParameter("txtDirEmp");
		edadEmp = Integer.parseInt(request.getParameter("txtEdaEmp"));
		estEmp = Integer.parseInt(request.getParameter("cboEstado"));
		
		// Proceso
		Empleado e = new Empleado();
		//e.setIdEmple(idEmple);
		e.setCodEmp(codEmp);
		e.setNomEmp(nomEmp);
		e.setApeEmp(apeEmp);
		e.setDocEmp(docEmp);
		e.setTelEmp(telEmp);
		e.setDirEmp(dirEmp);
		e.setEdadEmp(edadEmp);
		e.setEstadoEmp(estEmp);
		System.out.println("Datos: " +e); // Llama por default --> toString()
		
		// Llamar
		GestionEmpleado ge = new GestionEmpleado();
		int ok = ge.insertEmpleado(e);
		
		if (ok == 0) {
			// mensaje error
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Error al registrar!</div>");
			} else {
				request.setAttribute("mensaje",
					"<div class='alert alert-success' role='alert'>" + "Empleado registrado!</div>");
			}
		
		// Salida
		request.getRequestDispatcher("registroEmpleado.jsp").forward(request, response);
	}

}
