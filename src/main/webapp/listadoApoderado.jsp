<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Apoderado</title>

<link rel="stylesheet" href="css/estilos.css" type="text/css" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

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
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<table class="table table-striped">
  
   <thead>
    <tr>
      <th scope="col">CODIGO</th>
      <th scope="col">DESCRIPCIÓN</th>
      <th scope="col">NOMBRES</th>
      <th scope="col">APELLIDOS</th>
      <th scope="col">DOCUMENTO</th>
      <th scope="col">TELEFONO</th>
      <th scope="col">DOMICILIO</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listadoApoderados }" var="a">
  
  <tr>
      
      <td>${a.codApo }</td>
      <td>${a.desApo }</td>
      <td>${a.nomApo }</td>
      <td>${a.apeApo }</td>
      <td>${a.dniApo }</td>
      <td>${a.telApo }</td>
       <td>${a.domApo }</td>
    </tr>
  
  
  </c:forEach>
  
    
    
  
  </tbody>
  
</table>



 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>