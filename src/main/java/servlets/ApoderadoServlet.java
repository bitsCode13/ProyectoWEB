package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.GestionApoderado;
import model.Apoderado;


/**
 * Servlet implementation class ApoderadoServlet
 */
@WebServlet(name = "apoCrud", urlPatterns = { "/apoCrud" })
public class ApoderadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("btnAction");
		System.out.println("BOTON SELECCIONADO "+accion);
		
		switch (accion) {
		case "regApo": insert(request,response);
		case "actApo": update(request,response);
		case "eliApo": delete(request,response);
		case "lstApo": list(request,response);
		case "lstApoMul":lstApoMul(request,response);  
		case "busApo": search(request,response);
		case "blokReg": bloquearRegistro(request,response);
		}
		
		
	}

	private void bloquearRegistro(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("readonly","readonly");
		
		
		
	}

	private void lstApoMul(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod = request.getParameter("textoMultiple");
		
		GestionApoderado ga = new GestionApoderado();
		
		ArrayList<Apoderado> lista = ga.listmultipleApoderado(cod);
		
		System.out.println(lista);
		
		
		request.setAttribute("listadoApoderados", lista);
		
		request.getRequestDispatcher("listadoApoderado.jsp").forward(request, response);
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int cod = Integer.parseInt(request.getParameter("codApo"));
		String des = request.getParameter("desApo");
		String nom = request.getParameter("nomApo");
		String ape = request.getParameter("apeApo");
		int dni = Integer.parseInt(request.getParameter("dniApo"));
		int tel = Integer.parseInt(request.getParameter("telApo"));
		String dom = request.getParameter("domApo");
		
		Apoderado a = new Apoderado();
		
		//a.setCodApo(cod);
		
			
			
			a.setDesApo(des);
			a.setNomApo(nom);
			a.setApeApo(ape);
			a.setDniApo(dni);
			a.setTelApo(tel);
			a.setDomApo(dom);
			
			GestionApoderado ga = new GestionApoderado();
			
			int ok = ga.insertApoderado(a);
			
			if(ok ==0) {
				// mensaje de error
				request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
					+ "  Error al Registrar"
					+ "</div>");
			}else {
				request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
						+ "  Apoderado Registrado"
						+ "</div>");
			}
			
			request.getRequestDispatcher("apoderadoRegistro.jsp").forward(request, response);
		}
		
		
		
		
	

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				int cod = Integer.parseInt(request.getParameter("codApo"));
				String des = request.getParameter("desApo");
				String nom = request.getParameter("nomApo");
				String ape = request.getParameter("apeApo");
				int dni = Integer.parseInt(request.getParameter("dniApo"));
				int tel = Integer.parseInt(request.getParameter("telApo"));
				String dom = request.getParameter("domApo");
				
				Apoderado a = new Apoderado();
				
				a.setCodApo(cod);
				a.setDesApo(des);
				a.setNomApo(nom);
				a.setApeApo(ape);
				a.setDniApo(dni);
				a.setTelApo(tel);
				a.setDomApo(dom);
				
				GestionApoderado ga = new GestionApoderado();
				
				int ok = ga.updateApoderado(a);
				
				if(ok ==0) {
					// mensaje de error
					request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
						+ "  Error al Registrar"
						+ "</div>");
				}else {
					request.setAttribute("alerta","<script>Swal.fire(title:'Good job!',icon:'success')</script>");
				}
				
				request.getRequestDispatcher("apoderadoRegistro.jsp").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				int cod = Integer.parseInt(request.getParameter("codApo"));
				
				
				Apoderado a = new Apoderado();
				
				a.setCodApo(cod);
			
				
				GestionApoderado ga = new GestionApoderado();
				
				int ok = ga.deleteApoderado(a);
				
				if(ok ==0) {
					// mensaje de error
					request.setAttribute("alerta", "<div class='alert alert-danger' role='alert'>"
						+ "  Error al eliminar"
						+ "</div>");
				}else {
					request.setAttribute("alerta", "<div class='alert alert-success' role='alert'>"
							+ "Eliminación Exitosa"
							+ "</div>");
				}
				
				System.out.println("DATOS"+ a);
				
				request.getRequestDispatcher("listadoApoderado.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionApoderado ga = new GestionApoderado();
		
		ArrayList<Apoderado> lista = ga.listApoderado();
		
		request.setAttribute("listadoApoderados", lista);
		System.out.println(lista);
		
		request.getRequestDispatcher("listadoApoderado.jsp").forward(request, response);
		
	}

	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bloquearRegistro(request, response);
		
		int cod = Integer.parseInt(request.getParameter("codList"));
		
		
		GestionApoderado ga = new GestionApoderado();
		
		Apoderado a = ga.searchApoderado(cod);
		
		request.setAttribute("a", a);
		
		request.getRequestDispatcher("apoderadoRegistro.jsp").forward(request, response);
				
	}

}

