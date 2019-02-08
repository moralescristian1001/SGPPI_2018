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
				<h1 class="page-header">Solicitar Asesoria</h1>
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
							<div class="row">
								<%
									String[] colores = new String[] { "fff3aa", "ffd0a8", "ffb1b1", "d9d1ff", "b7efff", "fff3aa", "ffd0a8", "ffb1b1", "d9d1ff", "b7efff", "fff3aa", "ffd0a8", "ffb1b1", "d9d1ff", "b7efff", "fff3aa", "ffd0a8", "ffb1b1", "d9d1ff", "b7efff" };

									List<Usuarios> asesores = (List<Usuarios>) request.getAttribute("listAsesores");
									Map<Integer, String> coloresXAsesor = new HashMap();
									String scriptColores = "";

									int colSize = 12 / asesores.size();

									int i = 0;
									for (Usuarios asesor : asesores) {
										coloresXAsesor.put(asesor.getIdUsuario(), colores[i]);
								%>
								<div class="col-sm-<%=colSize%>">
									<div class="alert" style="background-color: #<%=colores[i]%>"
										role="alert"><%=asesor.getNombre() + " " + asesor.getApellidos()%></div>
								</div>
								<%
									i++;
									}
								%>
							</div>
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
										//desde las 6am hasta las
										List<Asesorias> asesorias = (List<Asesorias>) request.getAttribute("listAsesorias");
										List<SolicitudAsesoria> solicitudes = (List<SolicitudAsesoria>) request.getAttribute("listSolicitudes");
										Equipo equipoEstudiante = (Equipo) request.getAttribute("equipoEstudiante");
										for (double hora = 6; hora < 22; hora += 0.5) {
									%>
									<tr>
										<td><%=hora == 12 || hora == 12.5 ? ((int) hora) + ":" + (hora % 1 == 0 ? "00" : "30") + "PM"
						: (((int) hora % 12) + ":" + (hora % 1 == 0 ? "00" : "30") + (hora > 12 ? "PM" : "AM"))%></td>
										<%
											for (int dia = 1; dia < 7; dia++) {
										%>
										<td class="schedule-td"
											id="td-<%=dia + "-" + ((int) hora) + ":" + (hora % 1 == 0 ? 0 : 30)%>">
											<%
												boolean encontrado = false;
														List<Integer> asesoresEncontrados = new ArrayList();
														for (Asesorias a : asesorias) {

															if (a.getHoraSemana() == hora && a.getDiaSemana() == dia) {
																if (a.getIdEquipo() != null && !encontrado) { // esta ocupada por otro equipo
																	if (a.getIdEquipo() == equipoEstudiante.getIdEquipo()) {
																		String nombreAsesor = "";
																		for (Usuarios asesor : asesores) {
																			if(asesor.getIdUsuario() == a.getIdAsesor()){
																				nombreAsesor = asesor.getNombre() + " " + asesor.getApellidos();
																				break;
																			}
																		}
											%><a
											href="javascript:verMiAsesoria(<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>', '<%=nombreAsesor%>')"><i
												class='fa fa-calendar-check-o fa-fw' data-toggle="tooltip" 
										title="Tienes una asesoría programada, click aquí para más información"></i></a> <%
 	encontrado = true;
 							asesoresEncontrados.add(a.getIdAsesor());
 						} else {
 %> No esta disponible <%
 	}

 					} else { // no esta ocupada por otro equipo

 						asesoresEncontrados.add(a.getIdAsesor());
 						if (!encontrado) {
 							boolean yaSolicito = false;
 							for (SolicitudAsesoria s : solicitudes) {
 								if (s.getHoraSemana() == hora && s.getDiaSemana() == dia) {
 									yaSolicito = true;
 									break;
 								}
 							}
 							if (!yaSolicito) {
 %> <a
											href="javascript:solicitarCitaForm(<%=dia%>,<%=hora%>,'<%=diasSemana[dia - 1]%>')"><i
												class='fa fa-calendar-plus-o fa-fw' data-toggle="tooltip" 
										title="Puedes solicitar esta asesoria."></i></a> <%
 	}

 							encontrado = true;
 						}
 					}

 				}
 			}

 			if (encontrado) {
 				String coloresAgregados = "";

 				int porcentajeColorPorParte = 100 / asesoresEncontrados.size();
 				int porcentajeColor = 100;
 				for (Integer asesorEncontrado : asesoresEncontrados) {
 					porcentajeColor -= porcentajeColorPorParte;
 					coloresAgregados += ", #" + coloresXAsesor.get(asesorEncontrado) + " " + porcentajeColor
 							+ "%";

 				}
 				if (asesoresEncontrados.size() == 1) {
 					coloresAgregados += ", #" + coloresXAsesor.get(asesoresEncontrados.get(0));
 				}
 				String horaStr = hora == 12 || hora == 12.5 ? ((int) hora) + "\\:" + (hora % 1 == 0 ? "00" : "30") + "PM"
						: (((int) hora % 12) + "\\:" + (hora % 1 == 0 ? "00" : "30"));
 				%><script>console.log('<%=dia +"-"+ horaStr + " " + coloresAgregados%>')</script><%
 				scriptColores += "$('#td-" + dia + "-" + horaStr + "').css({background: 'linear-gradient(to right"
 						+ coloresAgregados + ")'});";
 			}
 			for (SolicitudAsesoria s : solicitudes) {
 				if (s.getHoraSemana() == hora && s.getDiaSemana() == dia) {
 %> <a href="javascript:deleteSolicitud(<%=s.getIdSolicitud()%>)"><i
												class='fa fa-calendar-times-o fa-fw' data-toggle="tooltip" 
										title="La solicitud de la asesoría aun esta pendiente por aprobación, click aquí si desea eliminar la solicitud."></i></a> <%
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
						<h4 class="modal-title">Solicitud de Asesorias</h4>
					</div>
					<div class="modal-body">
						<div id="errorModal" class="alert alert-danger alert-dismissible" role="alert" style="display: none">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong id="messageErrorModal"></strong>
						</div>
						<input type='hidden' id="id_solicitud" name="id_solicitud"
							class="form-control" /> <input type='hidden' id="dia_semana"
							name="dia_semana" class="form-control" /> <input type='hidden'
							id="hora_semana" name="hora_semana" class="form-control" />
						<div class="form-group">
							<label for="dia-hora-asesoria">Dia y Hora:</label><span
								id="dia-hora-asesoria"></span><i class="fa fa-calendar fa-fw"></i>
						</div>
						<div class="form-group">
							<span id="asesor-nombre"></span>
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
<script src="../pagesJs/request.js"></script>
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
