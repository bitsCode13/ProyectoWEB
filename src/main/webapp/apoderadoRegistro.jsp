
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Apoderado</title>

<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet" href="cssApo/cssApo.css" type="text/css" />


<link rel="stylesheet" href="sweetalert2.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
	<header>
		<nav class="menu">
			<jsp:include page="menu.jsp"></jsp:include>
		</nav>
	</header>



	<div class="container">
		<div class="container_centrar-form">
			<h1 id="titulo">APODERADO</h1>
			<div class="container_contenedorForm">



				<form action="apoCrud" method="post">




					<div class="form-row">
						<div class="form-group mt-2 col-md-6">
							<label for="inputDescripcion " class="mb-0">CÓDIGO</label> <input
								type="text" class="form-control " id="inputDescripcion"
								value="${a.codApo }" placeholder="Ingrese Codigo " name="codApo"
								readonly>
						</div>


						<div class="form-group mt-2 col-md-6">
							<label for="inputDescripcion" class="mb-0 text-uppercase">DESCRIPCIÓN</label>
							<input type="text" class="form-control" id="inputDescripcion"
								value="${a.desApo }" placeholder="Ingrese una descripción "
								name="desApo" required>
						</div>

					</div>

					<div class="form-group mt-2  ">
						<label for="inputDescripcion" class="mb-0 text-uppercase">NOMBRES</label>
						<input type="text" class="form-control" id="inputDescripcion"
							value="${a.nomApo }" placeholder="Ingrese nombre " name="nomApo"
							required>
					</div>

					<div class="form-group mt-2">
						<label for="inputDescripcion" class="mb-0">APELLIDOS</label> <input
							type="text" class="form-control" id="inputDescripcion"
							value="${a.apeApo }" placeholder="Ingrese apellido" name="apeApo"
							required>
					</div>

					<div class="form-row">
						<div class="form-group mt-2 col-md-6">
							<label for="inputDescripcion" class="mb-0">DNI</label> <input
								type="text" class="form-control" id="inputDescripcion"
								value="${a.dniApo }" placeholder="Ingrese el dni" name="dniApo"
								min="0" maxlength="8"
								onkeydown="if(this.value.legth ==8) return false" required>
						</div>

						<div class="form-group mt-2 col-md-6">
							<label for="inputDescripcion" class="mb-0">TELEFONO</label> <input
								type="text" class="form-control" id="inputDescripcion"
								value="${a.telApo }" placeholder="ingrese el telefono"
								name="telApo" min="0" maxlength="9"
								onkeyup="if(this.value.legth ==9) return false" required>
						</div>
					</div>
					<div class="form-group mt-2">
						<label for="inputDescripcion" class="mb-0">DOMICILIO</label> <input
							type="text" class="form-control" id="inputDescripcion"
							placeholder="Ingrese un domicilio" value="${a.domApo }"
							name="domApo" required>
					</div>
					<div class="form-row ">
						<div class="form-group ml-2">
							<button type="submit" class="btn btn-success btn-lg "
								name="btnAction" value="regApo">Registrar</button>
						</div>

						<div class="form-group ml-2 mr-2">
							<button type="submit" class="btn btn-primary btn-lg "
								name="btnAction" value="actApo">Actualizar</button>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-danger btn-lg "
								name="btnAction" value="eliApo">Eliminar</button>
						</div>
						<div class="form-group ml-2 ">
							<a class="btn btn-warning btn-lg" href="apoCrud?btnAction=lstApo">Listar</a>
							<%-- BOTON LISTADO --%>
						</div>
						<div class="form-group ml-2 ">
							<a class="btn btn-success btn-lg"
								href="apoCrud?btnAction=blokReg"> Buscar </a>
						</div>
					</div>
				</form>

				${alerta }

			</div>
		</div>
	</div>



	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

