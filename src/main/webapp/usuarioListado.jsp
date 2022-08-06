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

<title>Listado de Usuarios</title>
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
					<th scope="col">USUARIO</th>
					<th scope="col">CONTRASEÑA</th>
					<th scope="col">ROL</th>
					<th scope="col">COD. DE EMPLEADO</th>
					<th scope="col">ESTADO</th>
					
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${lstUsr }" var="u">

					<tr>

						<td>${u.codUs }</td>
						<td>${u.nomUs }</td>
						<td>${u.pasUs }</td>
						<td>${u.rolUs }</td>
						<td>${u.codEm }</td>
						<td>${u.estadoId }</td>
									
						<td>
							<a href="UsuCrud?btnAction=busUsr&codUsr=${u.getCodUs()}" class="btn btn-link">
								Editar
							</a>
						</td>
						

						<td>
						<form action="UsuCRUD" method="post"> 
						<input type="hidden" name="codUsr" value="${a.codUs}">
								<button   class="btn btn-link" name="btnAction" value="eliUsr">
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