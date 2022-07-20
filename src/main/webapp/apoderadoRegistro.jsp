<div class="container"> 
<div class="container_contenedorForm">
				<form action="apoCrud" method="post" >




<div class="form-row">
					<div class="form-group mt-2 col-md-6">
						<label for="inputDescripcion "class="mb-0">CÓDIGO</label> <input type="text"
							class="form-control " id="inputDescripcion"
							placeholder="Ingrese Codigo " name="codApo" ${readonly } required>
					</div>
					
	 			
					<div class="form-group mt-2 col-md-6">
						<label for="inputDescripcion" class="mb-0 text-uppercase">DESCRIPCIÓN</label> <input type="text"
							class="form-control" id="inputDescripcion"
							placeholder="Ingrese una descripción " name="desApo" required>
					</div>
					
					</div>
					
					<div class="form-group mt-2  ">
						<label for="inputDescripcion"class="mb-0 text-uppercase">NOMBRES</label> <input type="text"
							class="form-control" id="inputDescripcion"
							placeholder="Ingrese nombre " name="nomApo" required>
					</div>

					<div class="form-group mt-2">
						<label for="inputDescripcion"class="mb-0">APELLIDOS</label> <input type="text"
							class="form-control" id="inputDescripcion"
							placeholder="Ingrese apellido" name="apeApo" required>
					</div>

				<div class="form-row">
					<div class="form-group mt-2 col-md-6">
						<label for="inputDescripcion"class="mb-0">DNI</label> <input type="number"
							class="form-control" id="inputDescripcion"
							placeholder="Ingrese el dni" name="dniApo" required>
					</div>

					<div class="form-group mt-2 col-md-6">
						<label for="inputDescripcion"class="mb-0">TELEFONO</label> <input
							type="number" class="form-control" id="inputDescripcion"
							placeholder="ingrese el telefono" name="telApo" required>
					</div>
				</div>
					<div class="form-group mt-2">
						<label for="inputDescripcion"class="mb-0">DOMICILIO</label> <input type="text"
							class="form-control" id="inputDescripcion" placeholder="Ingrese un domicilio"
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
						<a class="btn btn-warning btn-lg" href="apoCrud?btnAction=lstApo">Listar</a> <%-- BOTON LISTADO --%>
					</div>
					
					<a class="btn btn-success btn-lg" href="apoCrud?btnAction=blokReg" >
						
					</a>
</div>
				</form>



</div>

</div>





