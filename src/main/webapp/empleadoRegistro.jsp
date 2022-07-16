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
<title>Agua Viva - Empleado Registro</title>
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
			<section style="width: 75%; float: left;">
				<h1>Mantenimiento Empleados</h1>

				<form action="registroEmpleado" method="post">
					<div class="form-group">
						<div class="form-group">
							<label for="inputCode">Nro. Identificador:</label> <input
								type="text" name="txtIdEmp" class="form-control" id="inputCode"
								value="" readonly>
						</div>

						<div class="form-group">
							<label for="inputCode">Código Empleado:</label> <input
								type="text" name="txtCodEmp" value=""
								class="form-control" id="inputCode" maxlength="6"
								placeholder="Ingrese código empleado Ej. EM0001">
						</div>
						<div class="form-group">
							<label for="inputName">Nombre:</label> <input type="text"
								name="txtNomEmp" value="" class="form-control"
								id="inputName"
								placeholder="IngreseNombre"/>
						</div>
						<div class="form-group">
							<label for="inputSurname">Apellidos:</label>
								<input type="text" class="form-control" id="inputSurname"
									name="txtApeEmp" value="" placeholder="Ingrese apellidos" />
						</div>
						<div class="form-group">
        		 			<label for="inputDni">Dni:</label>
        		 				<input type="text" class="form-control" id="inputDni" 
        		 				name="txtDniEmp" value="" maxlength="8"
        		 				placeholder="Ingrese Nro. Dni"/>
        				</div>
        				<div class="form-group">
        		 			<label for="inputPhone">Telefono:</label>
        		 				<input type="text" class="form-control" id="inputPhone" 
        		 				name="txtTelEmp" value="" maxlength="9"
        		 				placeholder="Ingrese Nro. Telefono"/>
        				</div>
        				<div class="form-group">
        		 			<label for="inputDirection">Dirección:</label>
        		 				<input type="text" class="form-control" id="inputDirection" 
        		 				name="txtDirEmp" value="" 
        		 				placeholder="Ingrese una dirección"/>
        				</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCategory">Edad:</label> 							       		 	
        		 				<input type="number" class="form-control" id="nombre" 
        		 				name="txtEdaEmp" value="" min="0"
        		 				placeholder="Ingrese edad"/>        		 			
						</div>

						<div class="form-group col-md-6">
							<label for="inputState">Estado:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								
							</select>
						</div>
					</div>
					
					

					<button name="btnAccion" value="reg" type="submit"
						class="btn btn-primary">Registrar</button>
					<button name="btnAccion" value="act" type="submit"
						class="btn btn-primary">Actualizar</button>
					<button name="btnAccion" value="eli" type="submit"
						class="btn btn-danger">Eliminar</button>

					<a class="btn btn-warning" href="actualiza?btnAccion=lst">Listado</a>

				</form>
				<br />
				 ${ mensaje }
			</section>
		</main>		
		<footer>
		
		</footer>
	</div>
</body>
</html>