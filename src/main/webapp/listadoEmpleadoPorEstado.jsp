<%@page import="model.Empleado"%>
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
<title>Listado Empleados por Estado</title>
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
				<h1>Listado de Empleados por estado</h1>
				<%-- Formulario para el filtro por estado --%>
				<form action="registroEmpleado" method="post">
					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="inputCategory">Estado:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstEstados }" var="c">
									<c:if test="${ e.estadoEmp == c.idEst }">
										<option value="${c.idEst}" selected>${c.desEst }</option>
									</c:if>
									<c:if test="${ e.estadoEmp != c.idEst }">
										<option value="${c.idEst }">${c.desEst }</option>
									</c:if>																																
								</c:forEach>								
							</select>
						</div>								
					</div>
					<div class="form-row">
							<div class="form-group col-md-3">
								<button name="btnAccion" value="filtro" type="submit"
								class="btn btn-primary btn-lg btn-block">Filtrar</button>
							</div>			
						</div>					
				</form>
				
				<br />
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
						</tr>
					</thead>
					<tbody>
					
						
						
						<%-- leer el listado enviado para generar la tabla, usando JSTL 
						forEach
						items="nombre del objeto a iterar o recorrer"--%>
						
						<c:forEach items="${ lstEmpleados }" var="e">
						<tr>							
							<td></td>
							<td>${e.idEmple}</td>
							<td>${e.codEmp }</td>
							<td>${e.nomEmp }</td>
							<td>${e.apeEmp}</td>
							<td>${e.docEmp }</td>
							<td>${e.telEmp }</td>
							<td>${e.dirEmp }</td>
							<td>${e.edadEmp }</td>
							<td>${e.estadoEmp }</td>
							<td></td>
						</tr>
						
						</c:forEach>
						
						
						<%
						ArrayList<Empleado> lista = (ArrayList<Empleado>) request.getAttribute("lstEmpleados");
						if (lista != null) { // pregunta si la lista tiene datos
							for (Empleado e : lista) { // for each que lee el contenido de la lista
						%>						
						
						<%
						}
						}
						%>


					</tbody>
				</table>
				
				
			</section>
		</main>		
		<footer>
		
		</footer>
	</div>
</body>
</html>