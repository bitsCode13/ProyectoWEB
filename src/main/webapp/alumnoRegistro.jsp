<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>REGISTRO ALUMNO</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">

<link rel="stylesheet" href="css/estilos.css" type="text/css" />

<link rel="stylesheet" href="sweetalert2.min.css">
</head>
<body>



<nav class="menu">

			<jsp:include page="menu.jsp"></jsp:include>

</nav>

	<div class="container">
	

			<header>
			<h1 class="display-2">Alumno</h1>
			</header>
	

		<form action="AluCrud" method="post">

			<div class="form-group mt-3">
				<label for="inputDescripcion">CÓDIGO</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${a.cod_alumno }"
					placeholder="Ingrese Codigo " name="codAlu" required>
			</div>


			<div class="form-group mt-3 ">
				<label for="inputDescripcion">NOMBRES</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${a.nombres }"
					placeholder="Ingrese nombre " name="nomAlu" required>
			</div>

			<div class="form-group mt-3">
				<label for="inputDescripcion">APELLIDO PATERNO</label> <input
					type="text" class="form-control" id="inputDescripcion" value="${a.ape_paterno }"
					placeholder="Ingrese apellido" name="apepaAlu" required>
			</div>


			<div class="form-group mt-3">
				<label for="inputDescripcion">APELLIDO MATERNO</label> <input
					type="text" class="form-control" id="inputDescripcion" value="${a.ape_materno }"
					placeholder="Ingrese apellido" name="apemaAlu" required>
			</div>


			<div class="form-group mt-3">
				<label for="inputDescripcion">DNI</label> <input type="number"
					class="form-control" id="inputDescripcion" value="${a.documento }"
					placeholder="Ingrese el dni" name="dniAlu" required>
			</div>

			<div class="form-group mt-3">
				<label for="inputDescripcion">FECHA NACIMIENTO</label> <input
					type="date" class="form-control" id="inputDescripcion" value="${a.fecha_naci }"
					placeholder="ingrese el telefono" name="fechAlu" required>
			</div>

			<div class="form-group mt-3">
				<label for="inputDescripcion">EDAD</label> <input type="number"
					class="form-control" id="inputDescripcion" value="${a.edad }" 
					placeholder="Ingrese un domicilio" name="edadAlu" required>
			</div>


			<div class="form-group mt-3">
				<label for="inputDescripcion">NACIONALIDAD</label> <input
					type="text" class="form-control" id="inputDescripcion" value="${a.nacionalidad }"
					placeholder="Ingrese apellido" name="nacioAlu" required>
			</div>


			<div class="form-group mt-3">
				<label for="inputDescripcion">DOMICILIO</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${a.domicilio }"
					placeholder="Ingrese apellido" name="domiAlu" required>
			</div>

			<div class="form-group mt-3">
				<label for="inputDescripcion">TELEFONO</label> <input type="number"
					class="form-control" id="inputDescripcion" value="${a.telefono }"
					placeholder="Ingrese un domicilio" name="telAlu" required>
			</div>
			
			
			<div class="form-group mt-3">
				<label for="inputDescripcion">SEXO</label> <input type="text"
					class="form-control" id="inputDescripcion" value="${a.sexo }"
					placeholder="Ingrese un domicilio" name="sexAlu" required>
			</div>
			
			
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputState">Apoderado</label> 
							<select id="inputState" class="form-control" name="cboApoderado">
								<option value="-1" selected>Seleccionar..</option>
										
							<c:forEach items="${ lstApo}" var= "p">
							
							<c:if test="${a.id_apoderado== p.codApo}">
							<option value="${ p.codApo}" selected>${ p.nomApo}</option>
							</c:if>
							<c:if test="${a.id_apoderado!= p.codApo}">
							<option value="${ p.codApo}">${ p.nomApo}</option>
							</c:if>
							
							</c:forEach>
		
							</select>

						</div>
					</div>


				<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputState">Estado</label>
					 <select id="inputState" class="form-control" name="cboEstado">
						<option value="-1" selected>Seleccionar..</option>
						<c:forEach items="${ lstEst}" var= "r">
							
							<c:if test="${a.estado_id_estado== r.idEst}">
							<option value="${ r.idEst}" selected>${ r.desEst}</option>
							</c:if>
							<c:if test="${a.estado_id_estado!= r.idEst}">
							<option value="${ r.idEst}">${ r.desEst}</option>
							</c:if>
							
							</c:forEach>
		
					</select>

				</div>
			</div>





			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary mt-3 btn-lg"
					name="btnAction" value="regAlu">Registrar</button>


					
				<button type="submit" class="btn btn-primary mt-3 btn-lg"
					name="btnAction" value="actAlu">Actualizar</button>

			
		
				<button type="submit" class="btn btn-primary mt-3 btn-lg"
					name="btnAction" value="eliAlu">Eliminar</button>
	
			
				<a class="btn btn-primary mt-3 btn-lg" href="AluCrud?btnAction=lisAlu"> Listado</a>			
			
		
			</div>
		
		</form>


${alerta }
	</div>




<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>





</body>
</html>