<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.mybatis.models.Asignatura"%>
<%@page import="com.mybatis.models.Equipo"%>
<%@page import="com.mybatis.models.Estudiantesxequipos"%>
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
				<h1 class="page-header">Equipos de trabajo</h1>
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
			style="display: <%=request.getParameter("success") != null ? "block" : "none"%>; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<span class="alert-content">${success}<%=request.getParameter("success")%></span>
		</div>
		<form>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Gestionar Equipos de trabajo</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<%
								int[] semestres = new int[]{1, 2, 3, 4};

								List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
								List<Estudiantesxequipos> estudiantesxequipos = (List<Estudiantesxequipos>) request
										.getAttribute("estudiantesxequipos");
								List<Usuarios> estudiantes = (List<Usuarios>) request.getAttribute("estudiantes");
								List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");

								for (int semestre : semestres) {

									List<Integer> asignaturasSemestre = new ArrayList();
									for (Asignatura asig : asignaturas) {
										if (asig.getSemestre() == semestre) {
											asignaturasSemestre.add(asig.getIdAsignatura());
										}
									}
							%>

							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example-<%=semestre%>">
								<caption>
									Semestre
									<%=semestre%></caption>
								<thead>
									<tr>
										<th>Código</th>
										<th>Nombre</th>
										<th>Módulo sol</th>
										<th>Estudiantes</th>
										<th>Acción</th>
									</tr>
								</thead>
								<tbody>

									<%
										List<Equipo> equiposXSemestre = new ArrayList();
																		for (Equipo eq : equipos) {
																			if (asignaturasSemestre.contains(eq.getIdAsignatura())) {

																				equiposXSemestre.add(eq);
																			}
																		}
																		for (Equipo eq : equiposXSemestre) {
																			String asignaturaNombre = "";
																			for (Asignatura asig : asignaturas) {
																				if (asig.getIdAsignatura() == eq.getIdAsignatura()) {
																					asignaturaNombre = asig.getNombre();
																					break;
																				}

																			}
																			String estudiantesEquipo = "";
																			String jsonEstudiante = "";
																			for (Estudiantesxequipos exe : estudiantesxequipos) {
																				if (exe.getIdEquipo() == eq.getIdEquipo()) {
																					for (Usuarios usu : estudiantes) {
																						if (usu.getIdUsuario() == exe.getIdEstudiante()) {
																							estudiantesEquipo += "<li>" + usu.getNombre() + " " + usu.getApellidos() + "</li>";
																							jsonEstudiante += ",{nombre:'" + usu.getNombre() + " " + usu.getApellidos()
																									+ "', id_usuario:" + usu.getIdUsuario() + "}";
																						}
																					}
																				}
																			}
																			if(jsonEstudiante.isEmpty()){
																				jsonEstudiante = "[]";	
																			}else{
																				jsonEstudiante = "[" + jsonEstudiante.substring(1) + "]";
																			}
																			
												estudiantesEquipo = "<ul>" + estudiantesEquipo + "</ul>";
									%>
									<tr>
										<td><%=eq.getCodigo()%></td>
										<td><%=eq.getNombre()%></td>
										<td><%=asignaturaNombre%></td>
										<td><%=estudiantesEquipo%></td>

										<td><input type="button" data-toggle="modal"
											data-target="#myModalEditar"
											class="btn btn-default pull-left"
											onclick="updateTeamForm(<%=eq.getIdEquipo()%>,<%=eq.getCodigo()%>,'<%=eq.getNombre()%>',<%=eq.getIdAsignatura()%>,<%=jsonEstudiante%>)"
											value="Actualizar" /> <input type="button"
											class="btn btn-default pull-left"
											onclick="confirmationTeam(<%=eq.getIdEquipo()%>);"
											value="Eliminar" /></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<script>
					         					        	
					             $("#dataTables-example-<%=semestre%>").DataTable({
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
				<div class="row" style="padding: 50px">
					<input type="button" data-toggle="modal" data-target="#myModalEditar"
					class="btn btn-default pull-left" name="guardar" value="Nuevo equipo" onclick="guardarTeamForm()"></input>
					<br><br><br><br><br><br>
				</div>
				
			</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Subir Equipos</h4>
					</div>
					<form method="POST" enctype="multipart/form-data"
						action="team/saveTeam.html">
						<div class="modal-body">
							<div class="form-group text-center">
								<span>Campos que debe tener el archivo: <br>
									Código,Nombre, Código asignatura,Cédulas Estudiantes(Separadas
									por ",")
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
		<div class="modal fade" id="myModalEditar" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Equipo</h4>
					</div>
					<div class="modal-body">
						<div id="errorModal" class="alert alert-danger alert-dismissible" role="alert" style="display: none">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong id="messageErrorModal"></strong>
						</div>
						<input type='hidden' id="id_equipo" name="id_equipo"
							class="form-control" />
						<div class="form-group">
							<label class="col-12" for="nombre"><li style="list-style: none; display: inline-flex;">
										<span class="glyphicon glyphicon-info-sign" aria-hidden="true" data-toggle="tooltip" 
										title="El campo código solo admite caracteres númericos y no admite valores negativos ni 0"></span>
										</li> *Codigo:</label>
							<div class='input-group col-lg-12'>
								<input type="number" class="form-control" name="codigo"
									id="codigo" placeholder="Ingrese el código del equipo">
							</div>
						</div>

						<div class="form-group">
							<label for="apellidos">*Nombre:</label>
							<div class='input-group col-lg-12'>
								<input type="text" class="form-control" name="nombre"
									id="nombre" placeholder="Ingrese el nombre del equipo">
							</div>
						</div>
						<div class="form-group">
							<label for="cedula">*Asignatura:</label>
							<div class='input-group col-lg-12'>
								<select class="form-control" name="id_asignatura"
									id="id_asignatura">
									<option value="-1">Seleccione la asignatura...</option>
									<c:forEach var="asig" items="${asignaturas}">
										<option value="${asig.idAsignatura}">${asig.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<fieldset>
							<legend><li style="list-style: none; display: inline-flex;">
										<span class="glyphicon glyphicon-info-sign" aria-hidden="true" data-toggle="tooltip" 
										title="En esta sección podrás agregar los estudiantes a un equipo, minimamente debe agregar un estudiante al equipo y con un máximo de 3 estudiantes."></span>
										</li> Estudiantes</legend>
							<div class="row">
								<div class="col-sm-12" id="div_tabla_estudiantes"></div>
							</div>
						</fieldset>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<input type="button" class="btn btn-default pull-left"
							name="guardar" value="Guardar" onclick="updateTeam();">
					</div>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/team.js"></script>
<template id="template-sin-equipo"> <c:forEach var="est"
	items="${estudiantesSinEquipo}">
	<option value="${est.idUsuario}">${est.nombre}
		${est.apellidos}</option>
</c:forEach> </template>
<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip(); 
});
</script>
<jsp:include page="footer.jsp" />