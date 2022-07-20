<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Apoderado</title>

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
<div class="container_Listado">

${alerta }
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
       <td>
       		<form action="apoCrud" method="post">
									<input type="hidden"  name="codList" value="${a.codApo}">
									<button class="btn btn-link "  name="btnAction" value="busApo"> 
									<img class="boton_editar" alt="" src="img/edit.png" > 
									</button>
								</form>
       
       </td>
    </tr>
  
  
  </c:forEach>
  
    
    
  
  </tbody>
  
</table>

</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>