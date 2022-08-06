<%-- Para el menu de las paginas --%>
<section class="menu__container">
			<h1 class="menu__logo">Agua Viva School</h1>

			<ul class="menu__links">
				<li class="menu__item">
					<a href="principal.jsp" class="menu__link">Inicio</a>
				</li>

				<li class="menu__item">
					<a href="#"	class="menu__link">Mantenimiento <img src="assets/arrow.svg"
						class="menu__arrow"></a>

					<ul class="menu__nesting">
						<li class="menu__inside">
							<a href="apoderadoRegistro.jsp"	class="menu__link menu__link--inside" >Apoderado</a>
						</li>
						<li class="menu__inside">

							<a href="AluCrud?btnAction=cargar"	class="menu__link menu__link--inside">Registro de Alumno</a>

						</li>
						<li class="menu__inside">
							<a href="reservaMatricula?btnAccion=cargar"	class="menu__link menu__link--inside">Registro de Reserva Matricula</a>
						</li>						
						<li class="menu__inside">
							<a href="registroEmpleado?btnAccion=cargar" class="menu__link menu__link--inside">Registro de Empleados</a>
						</li>
					</ul>
				</li>

				<li class="menu__item">
					<a href="#" class="menu__link">Reportes <img src="assets/arrow.svg"
						class="menu__arrow"></a>

					<ul class="menu__nesting">
						<li class="menu__inside">
							<a href="#"	class="menu__link menu__link--inside">Reporte Alumnos por Año</a>
						</li>
						<li class="menu__inside">
							<a href="#"	class="menu__link menu__link--inside">Reporte de Alumnos Deudores</a>
						</li>
						<li class="menu__inside">
							<a href="reservaMatricula?btnAccion=lst" class="menu__link menu__link--inside">Reporte de Reservas</a>
						</li>
						<li class="menu__inside">
							<a href="#"	class="menu__link menu__link--inside">Reporte de Alumnos por Apoderado</a>
						</li>						
						<li class="menu__inside">
							<a href="registroEmpleado?btnAccion=listado" class="menu__link menu__link--inside">Reporte de Empleados por Estado</a>
						</li>
					</ul>
				</li>
				
				<li class="menu__item">
					<a href="usuarioRegistro.jsp" class="menu__link">Administración de Usuarios</a>
				</li>

				<li class="menu__item">
					<a href="#" class="menu__link">Contacto</a>
				</li>
			</ul>
		</section>