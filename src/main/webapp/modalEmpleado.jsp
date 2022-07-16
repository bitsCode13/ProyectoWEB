
<!-- Button trigger modal -->


<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal Registra Empleado -->

<div class="modal" id="exampleModal" tabindex="-1">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Registro Empleados</h5>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container-fluid" >
        	<form>
        		<div class="row mb-3">
        		 	<label for="codigo" class="col-3 col-form-label">Nro. Identificador:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="codigo" name="txtIdEmp" value="" />
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="codigo" class="col-3 col-form-label">Código Empleado:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="codigo" name="txtCodEmp" value="" 
        		 		placeholder="Ingrese código empleado Ej. EM0001"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Nombre:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtNombre" value="" 
        		 		placeholder="Ingrese nombre"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Apellidos:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtApellido" value="" 
        		 		placeholder="Ingrese apellidos"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Dni:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtDni" value="" 
        		 		placeholder="Ingrese Nro. Dni"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Telefono:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtTelefono" value="" 
        		 		placeholder="Ingrese Nro. Telefono"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Dirección:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtDireccion" value="" 
        		 		placeholder="Ingrese una dirección"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Edad:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="txtEdad" value="" 
        		 		placeholder="Ingrese edad"/>
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Estado:</label> 
        		 	<div class="col-9">
        		 	<select id="text" class="form-control" name="cboEstado">
						<option selected value="-1">Seleccione...</option>								
								
					</select> 
					</div>       		 	
        		</div>         					
						
					
        	</form>
        </div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Registrar</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>