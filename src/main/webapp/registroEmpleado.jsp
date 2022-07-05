<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Empleado</title>
<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<nav class="menu">
		<jsp:include page="menu.jsp"></jsp:include>					
	</nav>
	<br />
	<div class="container">
		<section style="width: 70%; float: left">
				<h1>Registro Empleado</h1>

				<form action="" method="post">
					<div class="form-group">
						<label for="inputCodigo">Código:</label> <input name="txtCodigo" value="${u.codigo }"
							class="form-control" id="InputCodigo"
							placeholder="Ingrese Código" readonly>
					</div>
					<div class="form-group">
						<label for="inputNombre">Nombre:</label> <input type="text" value="${u.nombre }"
							name="txtNombre" class="form-control" id="InputText"
							placeholder="Ingrese su nombre" required maxlength="30">
					</div>
					<div class="form-group">
						<label for="inputApellido">Apellido:</label> <input type="text" value="${u.apellido }"
							name="txtApellido" class="form-control" id="InputText"
							placeholder="Ingrese su Apellido" maxlength="30">
					</div>
					<div class="form-group">
						<label for="inputUser">DNI. Empleado:</label> <input type="email" value="${u.correo }"
							name="txtCorreo" class="form-control" id="InputEmail"
							placeholder="Ingrese su correo" required maxlength="40">
					</div>
					<div class="form-group">
						<label for="inputPassword">Telefono:</label> <input value="${u.clave }"
							type="password" name="txtClave" class="form-control"
							id="InputPassword" placeholder="Ingrese password" required
							maxlength="10">
					</div>
					<div class="form-group">
						<label for="inputFecha">Fecha de Nacimiento:</label> <input value="${u.fnacim }"
							type="date" name="txtFechaNac" class="form-control"
							id="InputDate" placeholder="año/mes/dia">
					</div>
					<button name="btnAccion" value="reg" type="submit"class="btn btn-primary">Registrar</button>
					<button name="btnAccion" value="act" type="submit"class="btn btn-primary">Actualizar</button>
					<button name="btnAccion" value="eli" type="submit"class="btn btn-danger">Eliminar</button>
					<button name="btnAccion" value="lis" type="submit"class="btn btn-warning">Listado</button>
				</form>
				<br /> 
			</section>
	</div>
		
</body>
</html>