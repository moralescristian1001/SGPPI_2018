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
						<div class="panel-body" style="overflow-x:auto;">
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
			</div>
		</form>
		
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/quadrant.js"></script>
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