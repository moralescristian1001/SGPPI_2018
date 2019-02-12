<%@page import="java.util.Map"%>
<%@page import="com.mybatis.models.Asignatura"%>
<%@page import="com.mybatis.models.Equipo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Calificar Socialización</h1>
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
						<div class="panel-heading">Equipos del Salón
							${salon.getDescripcion()}</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Número del equipo</th>
										<th>Titulo Proyecto</th>
										<th>Módulo Sol</th>
										<th>Nota</th>
										<th>Acción</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
										List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");
										Map<Integer, Double> notas = (Map<Integer, Double>)request.getAttribute("notas");
										for (Equipo equipo : equipos) {
											String asignatura = "";
											String nota = "";
											for (Asignatura asig : asignaturas) {
												if (asig.getIdAsignatura() == equipo.getIdAsignatura()) {
													asignatura = asig.getNombre();
													break;
												}
											}
											if(notas.containsKey(equipo.getIdEquipo())){
												nota = notas.get(equipo.getIdEquipo()).toString();
											}
									%>

									<tr>
										<td><%=equipo.getCodigo()%></td>
										<td><%=equipo.getNombre()%></td>
										<td><%=asignatura%></td>
										<td><%=nota%></td>
										<td><%if(!nota.isEmpty()){%>Ya se calificó este equipo<%}else{%><input type="button" data-toggle="modal"
											data-target="#myModal" class="btn btn-default pull-left"
											onclick="abrirEquipo(<%=equipo.getIdEquipo()%>,'<%=equipo.getCodigo()%>','<%=equipo.getNombre()%>','<%=asignatura%>',<%=equipo.getIdAsignatura()%>,'<%=nota%>')"
											value="Calificar" /><%}%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
				<input type="hidden" data-toggle="modal"
					class="btn btn-default pull-left" name="id_socializacion"
					id="id_socializacion" value="${id_socializacion}"></input>
			</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Calificar equipo</h4>
					</div>
					<div class="modal-body">
						<div id="errorModal" class="alert alert-danger alert-dismissible" role="alert" style="display: none">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong id="messageErrorModal"></strong>
						</div>
						<input type='hidden' id="id_equipo" name="id_equipo"
							class="form-control" />

						<div class="form-group">
							<label for="empleado">*Código Equipo:</label><span id="codigo"></span>
						</div>
						<div class="form-group">
							<label for="empleado">*Nombre Equipo:</label><span id="nombre"></span>
						</div>

						<div class="form-group">
							<label for="empleado">*Módulo Sol:</label><span id="asignatura"></span>
						</div>
						<fieldset>
							<legend>Rúbricas</legend>
							<div id="rubricas"></div>
						</fieldset>
						<div class="form-group">
							<label for="empleado">*Observaciones:</label>
							<textarea id="observaciones" name="observaciones"
								class="form-control"></textarea>
						</div>
					</div>
					<div class="modal-footer">
					   	<input type="button" class="btn btn-primary" value="Guardar Calificación" onclick="saveQualify()" id="guardar_calificacion">
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/qualify.js"></script>
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>

<jsp:include page="footer.jsp" />