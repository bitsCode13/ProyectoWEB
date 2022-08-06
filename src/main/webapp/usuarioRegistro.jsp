<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>REGISTRO USUARIO</title>
<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">



<link rel="stylesheet" href="sweetalert2.min.css">
</head>
<body>



<nav class="menu">

			<jsp:include page="menu.jsp"></jsp:include>

</nav>

	<div class="container">
	

			
			<main>
			
	<section style="width: 75%; float: left;">
			<!--  --> 
		<form action="UsuCrud" method="post">
		<h2>Gestion de Usuarios</h2>
			<div class="form-row">
				<div class="form-group col-md-4">
				<label for="inputDescripcion">CÓDIGO</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${u.codUsu }"
					placeholder="Ingrese Codigo " name="idUsr" readonly>
				</div>
				
				
				<div class="form-group col-md-4">
					<label for="inputDescripcion">COD. EMPLEADO</label> <input
						type="text" class="form-control" id="inputDescripcion"value="${u.codEmp } "
						placeholder="Codigo de empleado" name="codEmp" required >
				</div>
			
			</div>

			<div class="form-row">
					
				<div class="form-group col-md-4">
				<label for="inputDescripcion">USUARIO</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${u.nomUsu }"
					placeholder="Ingrese nombre " name="nomUsr" required>
				</div>
				
				<div class="form-group col-md-4">
				<label for="inputDescripcion">CONTRASEÑA</label> <input
					type="password" class="form-control" id="inputDescripcion" value="${u.pasUsu }"
					placeholder="Ingrese contraseña" name="pasUsr" required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputState">ESTADO</label> <select id="inputState"
						class="form-control" name="estId">
						<option value="-1" selected>Seleccionar..</option>
						<option value="1" >Activo</option>
						<option value="2" >Inactivo</option>
					</select>
				</div>
				
				<div class="form-group col-md-4">
					<label for="inputState">ROL</label> <select id="inputState"
						class="form-control" name="rolUsr">
						<option value="-1" selected>Seleccionar..</option>
						<option value="2" >Director</option>
						<option value="3" >Secretaria</option>
						<option value="4" >Asistente</option>
						<option value="5" >Profesor</option>
					</select>
				</div>
			</div>


			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-success mt-3 btn-lg"
					name="btnAction" value="regUsr">Registrar</button>


					
				<button type="submit" class="btn btn-primary mt-3 btn-lg"
					name="btnAction" value="actUsr">Actualizar</button>

			
		
				<button type="submit" class="btn btn-danger mt-3 btn-lg"
					name="btnAction" value="eliUsr">Eliminar</button>
	
			
				<a class="btn btn-warning mt-3 btn-lg" href="UsuCrud?btnAction=lstUsr">Listado</a>			
			
		
			</div>
			<br>
		${alerta }
		</form>
</section>
</main>
	<br>
	
	</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>