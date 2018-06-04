<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.mybatis.models.TipoEvento"%>
<%@page import="com.mybatis.models.Evento"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Socializaciones y Eventos</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="alert alert-danger" role="alert" id="errorDiv"
			style="display: none; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<span class="alert-content">${errors}</span>
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
						<div class="panel-heading">Eventos</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Fecha</th>
										<th>Tipo Evento</th>
										<th>Duración</th>
										<th>Acción</th>
									</tr>
								</thead>
								<%
									List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
									List<TipoEvento> tiposEvento = (List<TipoEvento>) request.getAttribute("tiposEvento");

									DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
									DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

									for (Evento evento : eventos) {
										String tipoEventoString = "";
										String fechaString = df.format(evento.getFecha());
										for (TipoEvento tipoEvento : tiposEvento) {
											if (tipoEvento.getIdTipoEvento() == evento.getIdTipoEvento()) {
												tipoEventoString = tipoEvento.getNombreEvento();
												break;
											}
										}
								%>
								<tr>

									<td><%=fechaString%></td>
									<td><%=tipoEventoString%></td>
									<td><%=evento.getDuracionHoras()%> horas</td>
									<td><input type="button" data-toggle="modal"
										data-target="#myModal" class="btn btn-default pull-left"
										onclick="updateSocializacionForm(<%=evento.getIdEvento()%>,<%=evento.getIdTipoEvento()%>,
										'<%=df2.format(evento.getFecha())%>',<%=evento.getDuracionHoras()%>)"
										value="Actualizar" /> <input type="button"
										class="btn btn-default pull-left"
										onclick="confirmationSocializacion(<%=evento.getIdEvento()%>);" value="Eliminar" /></td>
								</tr>
								<%
									}
								%>
							</table>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
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
						<h4 class="modal-title">Crear Evento</h4>
					</div>
					<div class="modal-body">
						<input type='hidden' id="idEvento" name="idEvento"
							class="form-control" value="" />
						<fieldset>
							<legend>Información Socialización</legend>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="fecha">*Fecha:</label> <input type="datetime-local"
											class="form-control" name="fecha" id="fecha"
											placeholder="Ingrese la fecha del evento">

									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label for="id_tipo_evento">*Tipo evento:</label> <select
											class="form-control" name="id_tipo_evento"
											id="id_tipo_evento">
											<option value="0">Seleccione...</option>
											<c:forEach items="${tiposEvento}" var="tipoEvento">
												<option value="${tipoEvento.idTipoEvento}">${tipoEvento.nombreEvento}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group ">
										<label for="duracion_horas">*Duración horas:</label> <input
											type="number" class="form-control" name="duracion_horas"
											id="duracion_horas"
											placeholder="Integrese la Duración en horas">

									</div>
								</div>
							</div>
						</fieldset>
						<fieldset>
							<legend>Salones</legend>

							<c:forEach items="${salones}" var="salon">
								<label class="checkbox-inline"><input type="checkbox"
									value="${salon.idSalon}" id="salon_${salon.idSalon}"
									name="salones[]"
									onclick="if(this.checked){agregarSalon(${salon.idSalon},'${salon.descripcion}')}else{eliminarSalon(${salon.idSalon})}">${salon.descripcion}</label>
							</c:forEach>
						</fieldset>
						<fieldset>
							<legend>Salones Información</legend>
							<div id="salones_informacion"></div>
						</fieldset>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="button" class="btn btn-default pull-left"
							value="Guardar" onclick="saveSocializacion();">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>
<template id="template-salon">
<div id="salon_div_{id_salon}">
	<div class="row">
		<div class="col-sm-12">
			<h4>{salon}</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div id="equipos_div_{id_salon}"></div>
		</div>
		<div class="col-sm-6">
			<div id="evaluadores_div_{id_salon}"></div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-6">
			<label>Agregar Equipos</label><font size="4"><a
				href="javascript:agregarEquipo({id_salon})"><span
					class="fa fa-plus-circle"></span></a></font>
		</div>

		<div class="col-sm-6">
			<label>Agregar Evaluadores</label><font size="4"><a
				href="javascript:agregarEvaluador({id_salon})"><span
					class="fa fa-plus-circle"></span></a></font>

		</div>
	</div>
</template>

<template id="template-equipo">
<div class="row" id="div_row_equipo_{id_salon}_{cont}">

	<div class="col-sm-9">
		<select class="form-control" id="id_equipo_{id_salon}_{cont}"
			name="id_equipo[{id_salon}_{cont}]" required>
			<option value="0">Seleccione...</option>
			<c:forEach items="${equipos}" var="equipo">
				<option value="${equipo.idEquipo}">${equipo.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-3">
		<a href="javascript:quitarEquipo({id_salon},{cont})"><span
			class="fa fa-remove"></span></a>
	</div>
</div>
</template>
<template id="template-evaluador">
<div class="row" id="div_row_evaluador_{id_salon}_{cont}">

	<div class="col-sm-9">
		<select class="form-control" id="id_evaluador_{id_salon}_{cont}"
			name="id_evaluador[{id_salon}_{cont}]" required>
			<option value="0">Seleccione...</option>
			<c:forEach items="${evaluadores}" var="evaluador">
				<option value="${evaluador.idUsuario}">${evaluador.nombre}
					${evaluador.apellidos}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-3">
		<a href="javascript:quitarEvaluador({id_salon},{cont})"><span
			class="fa fa-remove"></span></a>
	</div>
</div>
</template>
<script src="../pagesJs/social.js"></script>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>
<script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true
             });
         });
      </script>
</body>
</html>
