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
						<%
							
							String[] colores = new String[]{"fff3aa", "ffd0a8", "ffb1b1", "d9d1ff", "b7efff"};
							
							List<Usuarios> asesores = (List<Usuarios>) request.getAttribute("listAsesores");
							Map<Integer, String> coloresXAsesor = new HashMap();
							String scriptColores = "";
							int i = 0;
							for(Usuarios asesor : asesores){
								coloresXAsesor.put(asesor.getIdUsuario(), colores[i]);
							%>
							<div class="alert" style="background-color: #<%=colores[i]%>"role="alert"><%=asesor.getNombre() + " " + asesor.getApellidos()%></div>
							<%
							i++;
							}
						%>
							<table width="100%"
								class="table table-bordered"
								id="dataTables-example">
								<thead>
									<tr>
									<th>Hora</th>
									<%
									String[] diasSemana = new String[]{"Lunes", "Martes", "Miercoles", "Jueves","Viernes", "Sábado"};
									for(String dia : diasSemana){
									%>
																			
										<th><%=dia %></th>
									
									<%} %>
									</tr>
								</thead>
								<tbody>
									<%
										//desde las 6am hasta las
										List<Asesorias> asesorias = (List<Asesorias>) request.getAttribute("listAsesorias");
										List<SolicitudAsesoria> solicitudes = (List<SolicitudAsesoria>) request.getAttribute("listSolicitudes");
										
										
										
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
													List<Integer> asesoresEncontrados = new ArrayList();
													for (Asesorias a : asesorias) {
														
														if (a.getHoraSemana() == hora && a.getDiaSemana() == dia) {
															
															asesoresEncontrados.add(a.getIdAsesor());
															
															
															if(a.getIdEquipo() != null){ // esta ocupada por otro equipo
																%>
																	No esta disponible
																<%
															}else{ // no esta ocupada por otro equipo
																%>
																	<a href="javascript:asignarCitaForm(<%=dia%>,<%=hora%>,'<%=diasSemana[dia-1]%>')"><i class='fa fa-calendar-plus-o fa-fw'></i></a>
																<%
																encontrado = true;
															}
																														
															
														}
														
														
													}
													
													if(encontrado){
														String coloresAgregados = "";
														for(Integer asesorEncontrado : asesoresEncontrados){
															
															coloresAgregados += ", #" + coloresXAsesor.get(asesorEncontrado);
															
														}
														scriptColores += "$('#td-"+dia + "-" + hora +"').css({background: 'linear-gradient(to right"+coloresAgregados+")'});";
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
							<%
							if(!scriptColores.equals("")){
							%>
							<script><%=scriptColores %></script>
							<%
							}
							
							%>
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
						<h4 class="modal-title">Programación de Asesorias</h4>
					</div>
					<div class="modal-body">
						<input type='hidden' id="id_asesoria" name="id_asesoria"
							class="form-control" />
						<input type='hidden' id="dia_semana" name="dia_semana"
							class="form-control" />
						<input type='hidden' id="hora_semana" name="hora_semana"
							class="form-control" />
						<div class="form-group">
							<label for="dia-hora-asesoria">Dia y Hora:</label><span id="dia-hora-asesoria"></span><i class="fa fa-calendar fa-fw"></i>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="id_equipo">*Equipo:</label>
									<div class='input-group'>
										<select class="form-control" id="id_equipo" name="id_equipo" required>
											<option value="-1">Seleccione el equipo...</option>
											<c:forEach items="${listTeams}" var="equipo">
												<option value="${equipo.idEquipo}">${equipo.nombre} (${equipo.codigo})</option>
											</c:forEach>
										</select>
									</div>
								</div>								
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="button" class="btn btn-default pull-left"
							name="guardar" value="Guardar" onclick="saveAsesoria();"></input>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/request.js"></script>
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
<jsp:include page="footer.jsp" />