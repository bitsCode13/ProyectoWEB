<%@page import="model.ReservaMatricula"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.mysql.cj.protocol.ValueDecoder"%>
<%@page import="com.mysql.cj.xdevapi.Schema.Validation"%>
<%@page import="java.lang.StackWalker.Option"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agua Viva - Listado Reservas Matricula</title>
<!-- CSS only -->

<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

	<nav class="menu">
		<jsp:include page="menu.jsp"></jsp:include>					
	</nav>
	
	<div class="container">		
		
		<main>
		<br />
			<section style="width: 100%; ">
				<h1>Listado de Reservas</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">Nro. Id</th>
							<th scope="col">Cod. Reserva</th>
							<th scope="col">Fecha Registro</th>
							<th scope="col">Cuenta</th>
							<th scope="col">Cod. Alumno</th>
							<th scope="col">Id. Estado</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					
						
						
						<%-- usar el atributo enviado (Object) --%>
						<%
						ArrayList<ReservaMatricula> lista = (ArrayList<ReservaMatricula>) request.getAttribute("lstReservas");
						if (lista != null) { // pregunta si la lista tiene datos
							for (ReservaMatricula rm : lista) { // for each que lee el contenido de la lista
						%>						
						<tr>
							<%-- muestra las variables java de productos --%>
							<td></td>
							<td ><%=rm.getIdRes()%></td>
							<td><%=rm.getCodRes()%></td>
							<td><%=rm.getFecReg()%></td>
							<td>
							<fmt:setLocale value="es-PE"/>
							<fmt:formatNumber type="currency" value="<%=rm.getCueRes()%>" />
							</td>
							<td><%=rm.getCodAlu()%></td>
							<td><%=rm.getIdEst()%></td>
							<td>
								<%--Forma 1: Usnado hipervindculos --%> 
								<a href="reservaMatricula?btnAccion=buscar&cod=<%=rm.getIdRes()%>" 
								class="btn btn-link">  
									<img
									alt="" src="img/editar.png" 
									onmouseover="src='img/editar1.png'"
									onmouseout="src='img/editar.png'"></a>

							</td>
							
						</tr>
						<%
						}
						}
						%>


					</tbody>
				</table>
				
				<br />
				 ${ mensaje }
			</section>
		</main>		
		<footer>
		
		</footer>
	</div>
</body>
</html>