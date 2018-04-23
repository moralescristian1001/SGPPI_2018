<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.mybatis.models.Cargo"%>
<%@page import="java.util.Map"%>
<%@page import="com.mybatis.models.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:include page="header.jsp" />
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>
<div id="wrapper">

	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Usuarios</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="alert alert-danger" role="alert" id="errorDiv"
			style="display: <%=request.getParameter("errors") != null ? "block" : "none"%>; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			
			<span class="alert-content">${errors}<%=request.getParameter("errors")%></span>
		</div>
		<div class="alert alert-success" role="alert" id="successDiv"
			style="display: none; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<span class="alert-content">${success}</span>
		</div>
		<form>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Gestionar Usuarios</div>
						<!-- /.panel-heading -->
						<div class="panel-body">


							<%
								Map<Cargo, List<Usuarios>> usuariosXCargo = (Map<Cargo, List<Usuarios>>) request.getAttribute("users");
								SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
								for (Entry<Cargo, List<Usuarios>> usuXCargo : usuariosXCargo.entrySet()) {
									Cargo cargo = usuXCargo.getKey();
									List<Usuarios> usuarios = usuXCargo.getValue();

									// 								foreach
							%>

							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example-<%=cargo.getIdCargo()%>">
								<caption><%=cargo.getDescripcion()%></caption>
								<thead>
									<tr>
										<th>Correo</th>
										<th>Nombre y Apellidos</th>
										<th>Cédula</th>
										<th>Fecha de nacimiento</th>

										<%
											String thAdicional = "";
												switch (cargo.getIdCargo()) {
													case 1 : //Estudiante
														thAdicional = "<th>Equipos</th>";
														break;
													case 2 ://Profesor
														thAdicional = "<th>Asignaturas</th>";
														break;
													case 4 ://Evaluador
														thAdicional = "<th>Salones</th>";
														break;
												}
										%>
										<%=thAdicional%>
										<th>Estado</th>
										<th>Acción</th>
									</tr>
								</thead>
								<tbody>

									<%
										String nombreCompleto = "";
											String fechaFormateada = "";
											String estado = "";
											for (Usuarios usu : usuarios) {
												nombreCompleto = usu.getNombre() + " " + usu.getApellidos();

												fechaFormateada = format.format(usu.getFechaNac());
												estado = usu.getEstado() ? "Activo" : "Inactivo";
									%>
									<tr>
										<td><%=usu.getCorreo()%></td>
										<td><%=nombreCompleto%></td>
										<td><%=usu.getCedula()%></td>
										<td><%=fechaFormateada%></td>
										<%=usu.getUsuario()%>
										<td><%=estado%></td>
										<td><input type="button" data-toggle="modal"
											data-target="#myModal" class="btn btn-default pull-left"
											onclick="updateCuadrantes(${listCuad.id_cuadrante},${listCuad.numero},'${listCuad.nombre}','${listCuad.descripcion}','${listCuad.nombreAsig}')"
											value="Actualizar" /> <input type="button"
											class="btn btn-default pull-left"
											onclick="confirmationCuadra(${listCuad.id_cuadrante});"
											value="Eliminar" /></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<script>
					         					        	
					             $("#dataTables-example-<%=cargo.getIdCargo()%>").DataTable({
					                 responsive: true
					             });
					         
							</script>
							<%
								}
							%>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
				<input type="button" data-toggle="modal" data-target="#myModal"
					class="btn btn-default pull-left" name="guardar" value="Nuevo"></input>
			</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Subir Usuarios</h4>
					</div>
					<form method="POST" enctype="multipart/form-data"
						action="users/saveUser.html">
						<div class="modal-body">
							<div class="form-group text-center">
								<span>Campos que debe tener el archivo: <br> Correo,
									Nombre, Apellido, Cédula, Fecha de nacimiento(dd/mm/yyyy)
								</span>
							</div>
							<div class="form-group">
								<label for="cliente">*Archivo:</label>
								<div class='input-group col-lg-12' id='fecha'>
									<input type="file" class="form-control" name="archivoUpload"
										id="archivoUpload">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-default pull-left"
								name="guardar" value="Guardar"></input>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Usuario Modificar</h4>
					</div>


					<div class="modal-body">

						<input type='hidden' id="idUser" name="idUser"
							class="form-control" />
						<div class="form-group">
							<label for="nombre">*Nombre:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="nombre"
									id="nombre" placeholder="Ingrese el nombre del usuario">
							</div>
						</div>

						<div class="form-group">
							<label for="apellidos">*Apellidos:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="apellidos"
									id="apellidos" placeholder="Ingrese el apellido del usuario">
							</div>
						</div>
						<div class="form-group">
							<label for="cedula">*Cédula:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="cedula"
									id="cedula" placeholder="Ingrese la cédula del usuario">
							</div>
						</div>

						<div class="form-group">
							<label for="correo">*Correo:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="correo"
									id="correo" placeholder="Ingrese el correo del usuario">
							</div>
						</div>
						<div class="form-group">
							<label for="correo">*Fecha de nacimiento:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="fecha_nac"
									id="fecha_nac" placeholder="Ingrese la fecha de nacimiento del usuario">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="button" class="btn btn-default pull-left"
							name="guardar" value="Guardar" onclick="updateUser();">
					</div>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/users.js"></script>


<jsp:include page="footer.jsp" />