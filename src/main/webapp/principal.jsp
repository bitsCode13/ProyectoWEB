<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agua Viva - Principal</title>

<link rel="stylesheet" href="css/estilos.css" type="text/css" />
<link rel="stylesheet" href="cssApo/cssApo.css" type="text/css" />




<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<header>
	<nav class="menu">
		<jsp:include page="menu.jsp"></jsp:include>					
	</nav>
		
	</header>	
		

		<div>
		<jsp:include page="apoderadoRegistro.jsp"></jsp:include>
		</div>
		<div>
		<jsp:include page="empleadoRegistro.jsp"></jsp:include>
		</div>
		
		${alerta }

		   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        ></script>
</body>
</html>