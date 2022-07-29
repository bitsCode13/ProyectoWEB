<%@page import="model.Empleado"%>
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
<title>Agua Viva - Listado Empleados</title>
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
				<h1>Listado de Empleados</h1>
				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">Nro. Id</th>
							<th scope="col">Cod. Empleado</th>
							<th scope="col">Nombre</th>
							<th scope="col">Apellidos</th>
							<th scope="col">DNI</th>
							<th scope="col">Telf.</th>
							<th scope="col">Dirección</th>
							<th scope="col">Edad</th>
							<th scope="col">Estado</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					
						
						
						<%-- usar el atributo enviado (Object) --%>
						<%
						ArrayList<Empleado> lista = (ArrayList<Empleado>) request.getAttribute("lstEmpleados");
						if (lista != null) { // pregunta si la lista tiene datos
							for (Empleado e : lista) { // for each que lee el contenido de la lista
						%>						
						<tr>
							<%-- muestra las variables java de productos --%>
							<td></td>
							<td ><%=e.getIdEmple()%></td>
							<td><%=e.getCodEmp()%></td>
							<td><%=e.getNomEmp()%></td>
							<td><%=e.getApeEmp()%></td>
							<td><%=e.getDocEmp()%></td>
							<td><%=e.getTelEmp()%></td>
							<td ><%=e.getDirEmp()%></td>
							<td ><%=e.getEdadEmp()%></td>
							<td ><%=e.getEstadoEmp()%></td>
							<td>
								<%--Forma 1: Usnado hipervindculos --%> 
								<a href="registroEmpleado?btnAccion=buscar&cod=<%=e.getIdEmple()%>" 
								class="btn btn-link">  
									<img
									alt="" src="img/editar.png" 
									onmouseover="src='img/editar1.png'"
									onmouseout="src='img/editar.png'"></a>

							</td>
							<td>
								<%-- cambiar de estado empleado--%> 
								<a href="registroEmpleado?btnAccion=buscar&eli=<%=e.getIdEmple()%>" 
								class="btn btn-link">  
									<img
									alt="" src="img/trash.png" 
									onmouseover="src='img/trash1.png'"
									onmouseout="src='img/trash.png'"></a>
									
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