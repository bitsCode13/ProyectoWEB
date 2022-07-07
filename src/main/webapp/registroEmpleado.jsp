<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Empleado</title>
<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
					<label for="inputCodigo">Código:</label> <input name="txtCodigo"
						value="" class="form-control" id="InputCodigo"
						placeholder="Genere un código para el empleado Ej. 'EM1234'"
						required maxlength="6">
				</div>
				<div class="form-group">
					<label for="inputNombre">Nombre:</label> <input type="text"
						name="txtNombre" class="form-control" id="InputText"
						placeholder="Ingrese su nombre" required maxlength="30">
				</div>
				<div class="form-group">
					<label for="inputApellido">Apellido:</label> <input type="text"
						value="" name="txtApellido" class="form-control" id="InputText"
						placeholder="Ingrese su Apellido" required maxlength="30">
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputDni">DNI:</label> <input type="number"
							name="txtDni" class="form-control" id="inputDni" min="0" required
							placeholder="Dni">
					</div>
					<div class="form-group col-md-6">
						<label for="inputCelular">Celular:</label> <input type="number"
							class="form-control" name="txtCelular" id="inputCelular" min="0" required maxlength="9"
							placeholder="'Ej.' 932145678">
					</div>
				</div>
				<div class="form-group">
					<label for="inputDomicilio">Domicilio:</label> <input type="text"
						value="" name="txtDomicilio" class="form-control"
						id="InputDomicilio" placeholder="Ingrese su dirección" required
						maxlength="50">
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputEdad">Edad:</label> <input type="number"
							name="txtEdad" class="form-control" id="inputEdad" min="0"
							placeholder="Edad">
					</div>
					<div class="form-group col-md-6">
							<label for="inputState">Estado:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<option value="1">Estado 1</option>
								<option value="2">Estado 2</option>
							</select>
						</div>
				</div>
				<button name="btnAccion" value="reg" type="submit"
					class="btn btn-primary">Registrar</button>
				<button name="btnAccion" value="act" type="submit"
					class="btn btn-primary">Actualizar</button>
				<button name="btnAccion" value="eli" type="submit"
					class="btn btn-danger">Eliminar</button>
				<button name="btnAccion" value="lis" type="submit"
					class="btn btn-warning">Listado</button>
			</form>
			<br />
		</section>
	</div>

</body>
</html>