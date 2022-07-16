package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.GestionEmpleado;
import model.Empleado;

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
		default:
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String codEmp, nomEmp, apeEmp, dirEmp;
		int idEmple, docEmp, telEmp, edadEmp, estEmp;
		
		// Leer Datos
		
		idEmple = Integer.parseInt(request.getParameter("txtIdEmp"));
		codEmp = request.getParameter("txtCodEmp");
		if(!codEmp.matches("EM[0-9]{4}")) {
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'>" + "Ingrese Código</div>");
			request.getRequestDispatcher("empleadoRegistro.jsp").forward(request, response);
			return;
		}
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
		request.getRequestDispatcher("empleadoRegistro.jsp").forward(request, response);
	}

}
