<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Apoderado</title>

	

<link rel="stylesheet" href="css/estilos.css" type="text/css" />

<link rel="stylesheet" href="cssApo/cssApo.css" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


</head>
<body>

	<header>
		<nav class="menu">
			<jsp:include page="menu.jsp"></jsp:include>
		</nav>

	</header>
	
	
	<div class="container_Listado">
<%----%>
		 <br> <br>
		<form action="apoCrud" method="post">
		<div class="form-row">
			<div class="form-group  col-md-3">
				<input type="text" class="form-control " id="inputDescripcion"
					 placeholder="Ingrese Codigo " name="textoMultiple"> <br>
					</div>
					
					<div class="form-group ">
					<button class="btn btn-success btn-block" name="btnAction" type ="submit"value="lstApoMul" >BUSCAR</button>
			
			</div>
			
			<div class="form-group col-md-6 ">
					
			</div>
			<div class="form-group col-md-2">
					<a class="btn btn-success ml-5 btn-block" href="apoderadoRegistro.jsp" >Registrar</a>
			</div>
			
		</div>
			</form> 
${alerta }

	<div>
		<table class="table table-striped">

			<thead>
				<tr>
					<th scope="col">CODIGO</th>
					<th scope="col">DESCRIPCION</th>
					<th scope="col">NOMBRES</th>
					<th scope="col">APELLIDOS</th>
					<th scope="col">DOCUMENTO</th>
					<th scope="col">TELEFONO</th>
					<th scope="col">DOMICILIO</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${listadoApoderados }" var="a">

					<tr>

						<td>${a.codApo }</td>
						<td>${a.desApo }</td>
						<td>${a.nomApo }</td>
						<td>${a.apeApo }</td>
						<td>${a.dniApo }</td>
						<td>${a.telApo}</td>
						<td>${a.domApo }</td>
						
						
						
						
						<td>
							<form action="apoCrud" method="post">
								 <input type="hidden" name="codList" value="${a.codApo}">
								<button class="btn btn-link" name="btnAction" value="busApo">
									<img class="img_editar"  src="img/edit1.png">
									
								</button>
								
							</form>
 
						</td>
						

						<td>
						<form action="apoCrud" method="post"> 
						<input type="hidden" name="codApo" value="${a.codApo}">
								<button   class="btn btn-link" name="btnAction" value="eliApo">
									<img class="img_editar" src="img/delete.png" >
								</button>
							</form> <%--  --%>
						</td>
					<%-- 		--%>
					
						
					</tr>


				</c:forEach>




			</tbody>

		</table>
</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>