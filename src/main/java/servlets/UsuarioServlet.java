package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.GestionUsuario;
import model.User;
import model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name= "UsuCrud", description= "Mantenedor de clase USUARIO", urlPatterns={"/UsuCrud"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("btnAction");
		
		System.out.println("Acción seleccionada: " + accion);
		
		// de acuerdo a lo que seleccione:
		
		switch (accion) {
		case "regUsr":
			insert(request,response);
			break;
		case "actUsr":
			update(request,response);
			break;
		case "eliUsr":
			delete(request,response);
			break;
		case "lstUsr":
			list(request,response);
			break;
		case "busUsr":
			search(request,response);
			break;
		case "logUsr":
			login(request,response);
			break;
		case "lstRol":
			login(request,response);
			break;
		case "listUs":
			lista(request,response);
			break;
		default:
			break;
		}
		
		
	}

	

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//int cod = Integer.parseInt(request.getParameter("codUsr"));
		String nom = request.getParameter("nomUsr");
		String pas = request.getParameter("pasUsr");
		int rol = Integer.parseInt(request.getParameter("rolUsr"));
		String codemp = request.getParameter("codEmp");
		int est = Integer.parseInt(request.getParameter("estId"));
		
		Usuario u = new Usuario();
		
		//u.setcodUsu(cod);
		u.setnomUsu(nom);
		u.setpasUsu(pas);
		u.setrolUsu(rol);
		u.setcodEmp(codemp);
		u.setestId(est);
		
		GestionUsuario gu = new GestionUsuario();
		
		int ok = gu.insertUsuario(u);
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al Registrar"
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "  Usuario Registrado"
					+ "</div>");
		}
		
		request.getRequestDispatcher("usuarioRegistro.jsp").forward(request, response);
		
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod = Integer.parseInt(request.getParameter("codUsr"));
		String nom = request.getParameter("nomUsr");
		String pas = request.getParameter("pasUsr");
		int rol = Integer.parseInt(request.getParameter("rolUsr"));
		String codemp = request.getParameter("codEmp");
		int est = Integer.parseInt(request.getParameter("estId"));
		
		Usuario u = new Usuario();
		
		u.setcodUsu(cod);
		u.setnomUsu(nom);
		u.setpasUsu(pas);
		u.setrolUsu(rol);
		u.setcodEmp(codemp);
		u.setestId(est);
		
		GestionUsuario gu = new GestionUsuario();
		int ok =gu.updateUsuario(u);
		
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al Actualizar"
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "  Usuario Actualizado"
					+ "</div>");
		}
		
		request.getRequestDispatcher("usuarioRegistro.jsp").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cod = Integer.parseInt(request.getParameter("codUsr"));
		
		Usuario u = new Usuario();
		u.setcodUsu(cod);
	
		
		GestionUsuario gu = new GestionUsuario();	
		int ok = gu.deleteUsuario(u);
		
		if(ok ==0) {
			// mensaje de error
			request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
				+ "  Error al eliminar , ' El usuario continua activo' "
				+ "</div>");
		}else {
			request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
					+ "Eliminación Exitosa"
					+ "</div>");
		}
		
		request.getRequestDispatcher("usuarioRegistro.jsp").forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionUsuario gu = new GestionUsuario();
		ArrayList<User> lista = gu.listUsuario();
		
		// Enviar el listado a la pagina --> como atributo
		request.setAttribute("lstUsr", lista);
		
		// redireccionar a la página donde se mostrara el listado		
		request.getRequestDispatcher("usuarioListado.jsp").forward(request, response);
	}
	
	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionUsuario gu = new GestionUsuario();
		ArrayList<Usuario> lista = gu.listaUsuario();
		
		// Enviar el listado a la pagina --> como atributo
		request.setAttribute("listUs", lista);
		
		// redireccionar a la página donde se mostrara el listado		
		request.getRequestDispatcher("usuarioListado.jsp").forward(request, response);
		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Lee cod del Usuario a buscar
		int cod = Integer.parseInt(request.getParameter("codUsr")) ;
		
		GestionUsuario gu = new GestionUsuario();
		Usuario u = gu.searchUsuario(cod);
		request.setAttribute("u", u);
		
		// Actualiza el listado para el combo
		GestionUsuario gEst = new GestionUsuario();
		ArrayList<Usuario> lstEstados = gEst.listaUsuario();
		request.setAttribute("lstEstados", lstEstados);
		
		
		
		request.getRequestDispatcher("usuarioRegistro.jsp").forward(request, response);		
	}
    
	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
}
