<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mybatis.models.Usuarios"%>
<%@page import="com.mybatis.models.SolicitudAsesoria"%>
<%@page import="com.mybatis.models.Equipo"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mybatis.models.Asesorias"%>
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
				<h1 class="page-header">Seguimiento de Asesoria</h1>
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
						<div class="panel-heading">Asesorias</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%" class="table table-bordered"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Hora</th>
										<%
											String[] diasSemana = new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" };
											for (String dia : diasSemana) {
										%>

										<th><%=dia%></th>

										<%
											}
										%>
									</tr>
								</thead>
								<tbody>
									<%
										//desde las 6am hasta las 10
										List<Asesorias> asesorias = (List<Asesorias>) request.getAttribute("listAsesorias");
										List<Equipo> equipos = (List<Equipo>) request.getAttribute("listEquipos");
										int horaHoy = Integer.parseInt(request.getAttribute("hora").toString()); // 6 - 10
										int diaHoy = LocalDate.now().getDayOfWeek().getValue(); // 1- 7
										// 										int diaHoy = Integer.parseInt(request.getAttribute("dia").toString()); // 1- 7
										String scriptColores = "";
										for (double hora = 6; hora < 22; hora+=0.5) {
											%>
											<tr>
												<td><%=hora == 12 || hora == 12.5 ? ((int)hora) + ":" + (hora%1 == 0 ? "00" : "30") + "PM" : (((int)hora % 12) + ":" + (hora%1 == 0 ? "00" : "30") + (hora > 12 ? "PM" : "AM"))%></td>
												<%
													for (int dia = 1; dia < 7; dia++) {
												%>
												<td class="schedule-td" id="td-<%=dia + "-" + ((int)hora) + ":" + (hora%1 == 0 ? 0 : 30)%>">
											<%
												boolean encontrado = false;

														for (Asesorias a : asesorias) {

															if (a.getHoraSemana() == hora && a.getDiaSemana() == dia) {
																String iconSeguimiento = "calendar";
																if (dia == diaHoy) {
																	if (hora == horaHoy) {
																		//se señana
																		scriptColores += "$('#td-" + dia + "-" + hora + "').css('backgroundColor', 'red');";
																	}
																	iconSeguimiento += "-plus-o";
																	//habilitado para hacer seguimiento

																}
																String nombreEquipo = "";
																for (Equipo eq : equipos) {
																	if (eq.getIdEquipo() == a.getIdEquipo()) {
																		nombreEquipo = eq.getNombre();
																		break;
																	}
																}
											%><a
											href="javascript:verSeguimientoForm(<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>',<%=a.getIdAsesoria()%>,'<%=nombreEquipo%>', <%=diaHoy%>)"><i
												class='fa fa-<%=iconSeguimiento%> %> fa-fw'></i></a> <%
 	encontrado = true;
 					break;

 				}
 			}
 %>
										</td>
										<%
											}
										%>

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
			</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Seguimiento de Asesorias</h4>
					</div>
					<div class="modal-body">
						<div id="errorModal" class="alert alert-danger alert-dismissible" role="alert" style="display: none">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong id="messageErrorModal"></strong>
						</div>
						<input type='hidden' id="id_seguimiento" name="id_seguimiento"
							class="form-control" /> <input type='hidden' id="id_asesoria"
							name="id_asesoria" class="form-control" />
						<div class="form-group">
							<label for="dia-hora-asesoria">Dia y Hora:</label><span
								id="dia-hora-asesoria"></span><i class="fa fa-calendar fa-fw"></i>
						</div>
						<div class="form-group">
							<label>Equipo:</label><span id="equipo-nombre"></span>
						</div>
						<div id="div-agregar-seguimiento" style="display: none;">
							<div class="row">
								<div class="col-sm-12">
									<fieldset>

										<legend>Seguimiento Hoy</legend>
										<div class="row">
											<div class="col-sm-12 form-group">
												<label>*Observaciones:</label>
												<textarea id="observaciones" name="observaciones"
													class="form-control"></textarea>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12 form-group">
												<label><li style="list-style: none; display: inline-flex;">
												<span class="glyphicon glyphicon-info-sign" aria-hidden="true" data-toggle="tooltip" 
												title="Seleccione los estudiantes que asistieron"></span>
												</li> Estudiantes:</label> <select
													id="asistencia" name="asistencia" class="form-control"
													multiple>
												</select>
											</div>
										</div>
									</fieldset>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<fieldset>
									<legend>Historial de Seguimiento</legend>
									<div class="row">
										<div class="col-sm-12">
											<table id="seguimientos-tabla" class="table table-bordered">
												<thead>
													<tr>
														<th>Fecha</th>
														<th>Observaciones</th>
														<th>Estudiantes Faltaron</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					</div>
					<div id="foot-MyModal"></div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/tracing.js"></script>
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>
<%
	if (!scriptColores.equals("")) {
%>
<script><%=scriptColores%></script>
<%
	}
%>
<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip(); 
});
</script>

<jsp:include page="footer.jsp" />
