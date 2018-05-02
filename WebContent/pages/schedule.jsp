<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
				<h1 class="page-header">Programar Asesoria</h1>
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
						<div class="panel-heading">Asesoria</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%" class="table table-bordered"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Hora</th>
										<%
											String[] diasSemana = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
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
										//desde las 6am hasta las
										List<Asesorias> asesorias = (List<Asesorias>) request.getAttribute("listSchedules");
										List<Equipo> equipos = (List<Equipo>) request.getAttribute("listTeams");
										List<SolicitudAsesoria> listRequests = (List<SolicitudAsesoria>)request.getAttribute("listRequests");
										
										String scriptsColor = "";
										DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

										for (int hora = 6; hora < 22; hora++) {
									%>
									<tr>
										<td><%=hora == 12 ? hora + "PM" : ((hora % 12) + "" + (hora > 12 ? "PM" : "AM"))%></td>
										<%
											for (int dia = 1; dia < 7; dia++) {
										%>
										<td class="schedule-td" id="td-<%=dia + "-" + hora%>">
											
											<%
												boolean encontrado = false;
											
														for (Asesorias a : asesorias) {

															if (a.getHoraSemana() == hora && a.getDiaSemana() == dia) {
																if(!encontrado){
																	%><div class="row"><%
																}
																
																int idEquipoSolicitud = -1;
																if (a.getIdEquipo() == null) {
																	
																	//buscamos solicitudes
																	boolean encuentraSolicitud = false;
																	String nombreEquipo = "";
																	for(SolicitudAsesoria s : listRequests){
																		if(s.getHoraSemana() == hora && s.getDiaSemana() == dia){
																			
																			encuentraSolicitud = true;
																			for (Equipo equipo : equipos) {
																				if (equipo.getIdEquipo() == s.getIdEquipo()) {
																					nombreEquipo = "Solicitud: " + equipo.getNombre() + "(" + equipo.getCodigo() + ")";
																					break;
																				}
																			}
																			%>
																			<div class="col-sm-6">
																				<div class="text-left">
																					<a
																						href="javascript:modificarCitaForm(<%=a.getIdAsesoria()%>, <%=s.getIdEquipo()%>,<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>',<%=s.getIdSolicitud()%>, '<%=df.format(s.getFechaSolicitud())%>')"><i
																						class="fa fa-edit fa-fw"><%=nombreEquipo%></i></a>
																				</div>
																			</div><%
																			
																		}
																	}
																	if(!encuentraSolicitud){
																		%>
																		<div class="col-sm-6">
																			<div class="text-left">
																				<a
																					href="javascript:modificarCitaForm(<%=a.getIdAsesoria()%>, <%=a.getIdEquipo()%>,<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>', '','')"><i
																					class="fa fa-edit fa-fw">Sin Equipo</i></a>
																			</div>
																		</div><%
																	}
																} else {
																	String nombreEquipo = "";
																	for (Equipo equipo : equipos) {
																		if (equipo.getIdEquipo() == a.getIdEquipo()) {
																			nombreEquipo = equipo.getNombre() + "(" + equipo.getCodigo() + ")";
																			break;
																		}
																	}
																	
																	%>
																	<div class="col-sm-6">
																		<div class="text-left">
																			<a
																				href="javascript:modificarCitaForm(<%=a.getIdAsesoria()%>, <%=a.getIdEquipo()%>,<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>', '', '')"><i
																				class="fa fa-edit fa-fw"><%=nombreEquipo%></i></a>
																		</div>
																	</div><%
																	
																}
																scriptsColor += "$('#td-" + dia + "-" + hora + "').css('backgroundColor','#D9EDF7');";
																
																%><div class="col-sm-6"><div class="text-right">
																	<a
																		href="javascript:confirmationAsesoria(<%=a.getIdAsesoria()%>)"><i
																		class="fa fa-calendar-times-o fa-fw"></i></a>
																</div>
															</div> <%
							if(!encontrado){
								%></div><%
							}
 	encontrado = true;
 					break;
 				}
 			}
														
 			if (!encontrado) {
 %><a
											href="javascript:asignarCitaForm(<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>')"><i
												class='fa fa-calendar-plus-o fa-fw'></i></a> <%
 	}
 %></div>
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
						<h4 class="modal-title">Programación de Asesorias</h4>
					</div>
					<div class="modal-body">
						<input type='hidden' id="id_asesoria" name="id_asesoria"
							class="form-control" /> <input type='hidden' id="dia_semana"
							name="dia_semana" class="form-control" /> <input type='hidden'
							id="hora_semana" name="hora_semana" class="form-control" />
						<input type='hidden'
							id="id_solicitud" name="id_solicitud" class="form-control" />
						<div class="form-group">
							<label for="dia-hora-asesoria">Dia y Hora:</label><span
								id="dia-hora-asesoria"></span><i class="fa fa-calendar fa-fw"></i>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="id_equipo">*Equipo:</label>
									<div class='input-group'>
										<select class="form-control" id="id_equipo" name="id_equipo"
											required>
											<option value="-1">Sin equipo programado...</option>
											<c:forEach items="${listTeams}" var="equipo">
												<option value="${equipo.idEquipo}">${equipo.nombre}
													(${equipo.codigo})</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							
						</div>
						<div class="form-group">
							<span id="fecha-solicitud"></span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<input type="button" class="btn btn-default pull-left btn-primary"
							name="guardar" value="Guardar" onclick="saveAsesoria();"></input>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/schedule.js"></script>
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
			responsive : true
		});
	});
</script>
<%
	if(!scriptsColor.equals("")){
		%>
		<script>
		<%=scriptsColor%>
		</script>
		<% 
	}
%>
<jsp:include page="footer.jsp" />