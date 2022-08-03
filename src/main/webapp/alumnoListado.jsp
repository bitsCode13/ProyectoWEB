<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet" href="css/estilos.css" type="text/css" />

<title>Listado Alumno</title>
</head>
<body>

<header>
		<nav class="menu">
			<jsp:include page="menu.jsp"></jsp:include>
		</nav>

	</header>




<div class="container"> 



<table class="table table-striped">

			<thead>
				<tr>
					<th scope="col">CODIGO</th>
					<th scope="col">NOMBRES</th>
					<th scope="col">APELLIDO PATERNO</th>
					<th scope="col">APELLIDO MATERNO</th>
					<th scope="col">DOCUMENTO</th>
					<th scope="col">TELEFONO</th>
					<th scope="col">DOMICILIO</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${lstAlu }" var="a">

					<tr>

						<td>${a.cod_alumno }</td>
						<td>${a.nombres }</td>
						<td>${a.ape_paterno }</td>
						<td>${a.ape_materno }</td>
						<td>${a.documento }</td>
						<td>${a.telefono}</td>
						<td>${a.domicilio }</td>
						
						
						
						
						<td>
							<form action="AluCrud" method="post">
								 <input type="hidden" name="codList" value="${a.cod_alumno}">
								<button class="btn btn-link" name="btnAction" value="busAlu">
									Editar
									
								</button>
								
							</form>
 
						</td>
						
						

						<td>
						<form action="AluCrud" method="post"> 
						<input type="hidden" name="codAlu" value="${a.cod_alumno}">
								<button   class="btn btn-link" name="btnAction" value="eliAlu">
									Eliminar
								</button>
							</form> <%--  --%>
						</td>
					<%-- 		--%>
					
						
					</tr>


				</c:forEach>




			</tbody>

		</table>

${alerta }


</div>




</body>
</html>