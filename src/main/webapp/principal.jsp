<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agua Viva - Principal</title>

<link rel="stylesheet" href="css/estilos.css" type="text/css" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
	<nav class="menu">
		<jsp:include page="menu.jsp"></jsp:include>					
	</nav>
		<a class="btn btn-warning" href="apoCrud?btnAction=lstApo">s</a> <%-- BOTON LISTADO --%>
		
		<div>
		<jsp:include page="apoderadoRegistro.jsp"></jsp:include>
		</div>
		${alerta }
		   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        ></script>
</body>
</html>