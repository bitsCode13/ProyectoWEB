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
<title>Agua Viva - Registro Empleado</title>
<!-- CSS only -->



<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet" href="cssApo/cssApo.css" type="text/css" />
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
		
		<div class="centrarRegistro">
			<section class="">
				<h1>REGISTRO MATRICULA</h1>
				
				
				
				

				<form action="registroEmpleado" method="post">
					<div class="form-group">
					
						<div class="centrar_Montos">
						<div class="form-group ">
							<label for="inputCode">CODIGO RESERVA:</label> <input
								type="text" name="txtIdEmp" class="form-control" id="inputCode"
								value=""   placeholder="Codigo"   readonly >
						</div> 
						
							<div class="form-group mt-2 pt-4">
							<a class="btn btn-warning" href="registroEmpleado?btnAccion=lst">BUSCAR</a>
						</div> 
							</div> 
						
						
						
						
					
						<div class="form-group margin4">
						
							
        		 			<label for="inputDni">Dni:</label>
        		 				<input type="text" class="form-control" id="inputDni" 
        		 				name="txtDniEmp" value="${e.docEmp }" maxlength="8"
        		 				placeholder="Ingrese Nro. Dni" required/>
        				
        				</div>
						

						<div class="form-group">
							<label for="inputCode">Nombre Alumno:</label> <input
								type="text" name="txtCodEmp" value="${e.codEmp}"
								class="form-control" id="inputCode" maxlength="6"
								placeholder="Nombres" required >
						</div>
						<div class="form-group">
							<label for="inputName">Apellido Materno Alumno:</label> <input type="text"
								name="txtNomEmp" value="${e.nomEmp }" required class="form-control"
								id="inputName"
								placeholder="Apellidos paternos"/>
						</div>
						<div class="form-group">
							<label for="inputSurname">Apellido paterno Alumno</label>
								<input type="text" class="form-control" id="inputSurname"
									name="Apellidos maternos" value="${e.apeEmp }" placeholder="Ingrese apellidos" />
						</div>
						
						<hr class="mt-4 mb-3">
						
						<div class="centrar_Montos">
        				<div class="form-group">
        		 			<label for="inputPhone">Monto A Cuenta:</label>
        		 				<input type="text" class="form-control" id="inputPhone" 
        		 				name="txtTelEmp" value="${e.telEmp }" maxlength="9"
        		 				placeholder="Monto a cuenta" required/>
        				</div>
        				<div class="form-group">
        		 			<label for="inputDirection">Saldo Restante:</label>
        		 				<input type="text" class="form-control" id="inputDirection" 
        		 				name="txtDirEmp" value="${e.dirEmp }" 
        		 				placeholder="Saldo restante" required/>
        				</div>
					
					
						<div class="form-group ">
							<label for="inputCategory">Codigo Matricula:</label> 							       		 	
        		 				<input type="number" class="form-control" id="nombre" 
        		 				name="txtEdaEmp" value="${e.edadEmp }" min="0"
        		 				placeholder="Ingresar codigo" required/>        		 			
						</div>
					
						
</div>
						<div class="form-group margin4" >
							<label for="inputState">Nivel:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstEstados }" var="c">
									<c:if test="${ e.estadoEmp == c.idEst}">
										<option value="${c.idEst }" selected>${c.desEst }</option>
									</c:if>
									<c:if test="${ e.estadoEmp != c.idEst }">
										<option value="${c.idEst }">${c.desEst }</option>
									</c:if>																																
								</c:forEach>
							</select>
						</div>
						
						
						<div class="form-group margin4">
							<label for="inputState">Grado:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstEstados }" var="c">
									<c:if test="${ e.estadoEmp == c.idEst}">
										<option value="${c.idEst }" selected>${c.desEst }</option>
									</c:if>
									<c:if test="${ e.estadoEmp != c.idEst }">
										<option value="${c.idEst }">${c.desEst }</option>
									</c:if>																																
								</c:forEach>
							</select>
						</div>
						
						
						<div class="form-group margin4">
							<label for="inputState">Seccion:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstEstados }" var="c">
									<c:if test="${ e.estadoEmp == c.idEst}">
										<option value="${c.idEst }" selected>${c.desEst }</option>
									</c:if>
									<c:if test="${ e.estadoEmp != c.idEst }">
										<option value="${c.idEst }">${c.desEst }</option>
									</c:if>																																
								</c:forEach>
							</select>
							
						</div>
					
					
					

					<button name="btnAccion" value="reg" type="submit"
						class="btn btn-primary">Registrar</button>
					<button name="btnAccion" value="act" type="submit"
						class="btn btn-primary">Actualizar</button>
					<button name="btnAccion" value="eli" type="submit"
						class="btn btn-danger">Eliminar</button>

					<a class="btn btn-warning" href="registroEmpleado?btnAccion=lst">Listado</a>
</div>
				</form>
				<br />
				 ${ mensaje }
			</section>
			</div>
		</main>		
		<footer>
		
		</footer>
	</div>
	
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>