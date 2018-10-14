<%@page import="com.mybatis.models.Rubrica"%>
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
				<h1 class="page-header">Rúbricas</h1>
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
						<div class="panel-heading">Gestionar Rúbricas</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<%

								Map<Asignatura, List<Rubrica>> asignaturasxrubricas = (Map<Asignatura, List<Rubrica>>) request.getAttribute("listRubricas");
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								for (Map.Entry<Asignatura, List<Rubrica>> entry : asignaturasxrubricas.entrySet()) {
									int versionActual = 0;
									Asignatura asig = entry.getKey();
										
							%>

							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example-<%=asig.getIdAsignatura()%>">
								<caption>
									<%=asig.getNombre() + " " + asig.getCodigo()%></caption>
								<thead>
									<tr>
										<th>Versión</th>
										<th>Fecha</th>
										<th>Ver</th>
										<th>Actualizar</th>
									</tr>
								</thead>
								<tbody>

									<%
									
									for(Rubrica rubrica : entry.getValue()){
										if(versionActual == 0){
											versionActual = rubrica.getVersion();
										}else if(versionActual == rubrica.getVersion()){
											continue;
										}else{
											versionActual = rubrica.getVersion();
										}
										
										
									%>
									<tr>
										<td><%=versionActual%></td>
										<td><%=sdf.format(rubrica.getFechaVersion())%></td>
										<td><input type="button" data-toggle="modal"
											data-target="#myModalEditar"
											class="btn btn-default pull-left"
											onclick="viewRubricForm(<%=asig.getIdAsignatura()%>,<%=versionActual%>,'<%=asig.getNombre()%>')"
											value="Ver"/></td>
										<td><input type="button" data-toggle="modal"
											data-target="#myModalEditar"
											class="btn btn-default pull-left"
											onclick="updateRubricForm(<%=asig.getIdAsignatura()%>,<%=versionActual%>,'<%=asig.getNombre()%>')"
											value="Actualizar"/></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<script>
					         					        	
					             $("#dataTables-example-<%=asig.getIdAsignatura()%>").DataTable({
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
				<input type="button" data-toggle="modal" data-target="#myModalEditar"
					class="btn btn-default pull-left" name="guardar" value="Nueva rúbrica" onclick="guardarRubricaForm()"></input>
					<br><br><br><br><br><br>
			</div>
		</form>
		<div class="modal fade" id="myModalEditar" role="dialog">
			<div class="modal-dialog modal-lg">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Rúbricas <span id="nombre_asignatura"></span> Versión <span id="version"></span></h4>
					</div>
					<div class="modal-body">
						<form id="rubricas_form">
							<div class="row">
								<div class="col-sm-12">
									<select id="id_asignatura" name="id_asignatura" class="form-control">
										<option value="-1">Seleccione la asignatura...</option>
										<c:forEach items="${asignaturas}" var="asig">
											<option value="<c:out value="${asig.idAsignatura}"></c:out>">
											<c:out value="${asig.nombre}"></c:out></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<fieldset>
								<div id="rubricas"></div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<input type="button" class="btn btn-primary" value="Guardar" id="guardar-btn" onclick="save()"/>
							
					</div>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- /#page-wrapper -->

<!-- /#wrapper -->
<script src="../pagesJs/rubric.js"></script>

<jsp:include page="footer.jsp" />