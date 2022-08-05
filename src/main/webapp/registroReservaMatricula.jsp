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
<title>Agua Viva - Registro Reserva Matricula</title>
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
				<h1>Mantenimiento Reserva Matricula</h1>

				<form action="reservaMatricula" method="post">
					<div class="form-group">
						<div class="form-group">
							<label for="inputCode">Nro. Identificador:</label> <input
								type="text" name="txtIdRes" class="form-control" id="inputCode"
								value="${ rm.idRes }" placeholder="Generado por el Sistema" readonly>
						</div>

						<div class="form-group">
							<label for="inputCode">Código Reserva:</label> <input type="text"
								name="txtCodRes" value="${ rm.codRes }" class="form-control" id="inputCode"
								maxlength="6" placeholder="Generado por el Sistema" readonly>
						</div>
						<div class="form-group">
							<label for="inpuDate">Fecha Registro:</label> <input type="text"
								name="txtFecReg" value="${ rm.fecReg }" class="form-control" id="inputDate"
								placeholder="Generado por el Sistema" readonly/>
						</div>
						<div class="form-group">
							<label for="inputPrice">Monto a Pagar:</label> <input type="number"
								class="form-control" id="inputPrice" name="txtMontPag" value="${ rm.cueRes }"
								min="0" step="0.01" placeholder="0.00" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputState">Alumno:</label> <select id="text"
								class="form-control" name="cboAlumno">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstAlumnos }" var="a">
									<c:if test="${ rm.codAlu == a.codAlu}">
										<option value="${a.codAlu }" selected>${a.nomAlu }</option>
									</c:if>
									<c:if test="${ rm.codAlu != a.codAlu }">
										<option value="${a.codAlu }">${a.nomAlu }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label for="inputState">Estado:</label> <select id="text"
								class="form-control" name="cboEstado">
								<option selected value="-1">Seleccione...</option>
								<%-- Generamos  --%>
								<c:forEach items="${lstEstados }" var="es">
									<c:if test="${ rm.idEst == es.idEst}">
										<option value="${es.idEst }" selected>${es.desEst }</option>
									</c:if>
									<c:if test="${ rm.idEst != es.idEst }">
										<option value="${es.idEst }">${es.desEst }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>



					<button name="btnAccion" value="reg" type="submit"
						class="btn btn-success">Registrar</button>
					<button name="btnAccion" value="act" type="submit"
						class="btn btn-primary">Actualizar</button>

					<a class="btn btn-warning" href="reservaMatricula?btnAccion=lst">Listado</a>

				</form>
				<br /> ${ mensaje }
			</section>
		</main>
		<footer> </footer>
	</div>
</body>
</html>