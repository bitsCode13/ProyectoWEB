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
								value="${e.idEmple }"   placeholder="Generado Automatico"   readonly >
						</div> 

						<div class="form-group">
							<label for="inputCode">Código Empleado:</label> <input
								type="text" name="txtCodEmp" value="${e.codEmp}"
								class="form-control" id="inputCode" maxlength="6"
								placeholder="Generado Automatico" required readonly>
						</div>
						<div class="form-group">
							<label for="inputName">Nombre:</label> <input type="text"
								name="txtNomEmp" value="${e.nomEmp }" required class="form-control"
								id="inputName"
								placeholder="IngreseNombre"/>
						</div>
						<div class="form-group">
							<label for="inputSurname">Apellidos:</label>
								<input type="text" class="form-control" id="inputSurname"
									name="txtApeEmp" value="${e.apeEmp }" placeholder="Ingrese apellidos" />
						</div>
						<div class="form-group">
        		 			<label for="inputDni">Dni:</label>
        		 				<input type="text" class="form-control" id="inputDni" 
        		 				name="txtDniEmp" value="${e.docEmp }" maxlength="8"
        		 				placeholder="Ingrese Nro. Dni" required/>
        				</div>
        				<div class="form-group">
        		 			<label for="inputPhone">Telefono:</label>
        		 				<input type="text" class="form-control" id="inputPhone" 
        		 				name="txtTelEmp" value="${e.telEmp }" maxlength="9"
        		 				placeholder="Ingrese Nro. Telefono" required/>
        				</div>
        				<div class="form-group">
        		 			<label for="inputDirection">Dirección:</label>
        		 				<input type="text" class="form-control" id="inputDirection" 
        		 				name="txtDirEmp" value="${e.dirEmp }" 
        		 				placeholder="Ingrese una dirección" required/>
        				</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCategory">Edad:</label> 							       		 	
        		 				<input type="number" class="form-control" id="nombre" 
        		 				name="txtEdaEmp" value="${e.edadEmp }" min="0"
        		 				placeholder="Ingrese edad" required/>        		 			
						</div>

						<div class="form-group col-md-6">
							<label for="inputState">Estado:</label> <select id="text"
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
					</div>
					
					

					<button name="btnAccion" value="reg" type="submit"
						class="btn btn-primary">Registrar</button>
					<button name="btnAccion" value="act" type="submit"
						class="btn btn-primary">Actualizar</button>
					<button name="btnAccion" value="eli" type="submit"
						class="btn btn-danger">Eliminar</button>

					<a class="btn btn-warning" href="registroEmpleado?btnAccion=lst">Listado</a>

				</form>
				<br />
				 ${ mensaje }
			</section>
		</main>		
		<footer>
		
		</footer>
	</div>
	
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>