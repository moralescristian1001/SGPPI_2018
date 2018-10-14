<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mybatis.models.Usuarios"%>
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
				<h1 class="page-header">Seguimiento Asesorias</h1>
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
						<div class="panel-heading">Asesorias equipo ${equipoEstudiante.nombre}</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Fecha Asesoria</th>
										<th>Fecha Seguimiento</th>
										<th>Asesor</th>
										<th>Observaciones</th>
										<th>Faltantes</th>
									</tr>
								</thead>
								<tbody>
									<%
									
										List<Asesorias> asesorias = (List<Asesorias>) request.getAttribute("listAsesorias");
										List<Usuarios> asesores = (List<Usuarios>) request.getAttribute("listAsesores");
										JSONArray seguimientos = (JSONArray) request.getAttribute("jsonSeguimientos");
										
										for(int i = 0; i < seguimientos.size(); i++){
											JSONObject seguimiento = (JSONObject)seguimientos.get(i);
											
											Asesorias asesoria = null;
											for(Asesorias asesoriaObj : asesorias){
												if((Integer)seguimiento.get("id_asesoria") == asesoriaObj.getIdAsesoria()){
													asesoria = asesoriaObj;
													break;
												}
											}
											Usuarios asesor = null;
											
											for(Usuarios asesorObj : asesores){
												
												if(asesoria.getIdAsesor() == asesorObj.getIdUsuario()){
													asesor = asesorObj;
													break;
												}
											}
											double hora = asesoria.getHoraSemana();
											 
									%>
										<tr>
											<td><%=asesoria.getDiaSemana() + hora == 12 || hora == 12.5 ? ((int)hora) + ":" + (hora%1 == 0 ? "00" : "30") + "PM" : (((int)hora % 12) + ":" + (hora%1 == 0 ? "00" : "30") + (hora > 12 ? "PM" : "AM"))%></td>
											<td><%=seguimiento.get("fecha").toString()%></td>
											<td><%=asesor.getNombre() + " " + asesor.getApellidos()%></td>
											<td><%=seguimiento.get("observaciones").toString()%></td>
											<td><%=seguimiento.get("estudiantes_faltaron").toString()%></td>
										</tr>
										<%} 
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
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<input type='hidden' id="idCuadra" name="idCuadra"
							class="form-control" value="${id_cuadrante}" />
						<div class="form-group">
							<label for="cliente">*Número:</label>
							<div class='input-group col-lg-12' id='fecha'>
								<select class="form-control" id="num" name="num">
									<option>Seleccione</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="empleado">*Nombre:</label>
							<div class='input-group col-lg-12' id='fecha'>
								<input type="text" class="form-control" name="nomCuadra"
									id="nomCuadra" placeholder="Ingrese el nombre del cuadrante">
							</div>
						</div>

						<div class="form-group">
							<label for="medioPago">*Descripción:</label>
							<div class='input-group col-lg-12' id='fecha'>
								<textarea class="form-control" rows="5" name="desCuadra"
									id="desCuadra"
									placeholder="Ingrese la descripción del cuadrante"></textarea>
							</div>
						</div>
						<div class="form-group ">
							<label for="totalVenta">*Asignatura asociada:</label>
							<div class='input-group col-lg-12' id='fecha'>
								<span class="input-group-addon"><i class="glyphicon glyphicon-ok"></i></span> <select
									class="form-control" id="asigAso" name="asigAso" required>
									<option value="0">Seleccione</option>
									<c:forEach items="${listAsig}" var="listAs">
										<option value="${listAs.idAsignatura}">${listAs.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="button" class="btn btn-default pull-left"
							name="guardar" value="Guardar" onclick="saveCuadra();"></input>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/quadrant.js"></script>
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
<jsp:include page="footer.jsp" />