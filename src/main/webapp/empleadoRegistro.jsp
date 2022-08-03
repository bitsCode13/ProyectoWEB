
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
        		 	<label for="codigo" class="col-3 col-form-label">Código:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="codigo" name="" value="" />
        		 	</div>
        		</div>
        		<div class="row mb-3">
        		 	<label for="nombre" class="col-3 col-form-label">Nombre:</label>
        		 	<div class="col-9">        		 		
        		 		<input type="text" class="form-control" id="nombre" name="" value="" />
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