<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
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

<div id="wrapper">

	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Reporte Equipo</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<form id="form-editar-usuario" method="GET">
			<div class="row">
				<div class="col-lg-12 no-mostrar">
					<div class="panel panel-default">
						<div class="panel-heading">Buscar Equipo</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="overflow-x: auto;">
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="estado">*Estudiante:</label>
										<div class='input-group col-lg-12'>
											<select class="form-control" name="id_estudiante" id="id_estudiante">
												<option value="-1">Todos</option>
												<c:forEach items="${estudiantes}" var="estudiante">
													<option value="${estudiante.idUsuario}">${estudiante.nombre} ${estudiante.apellidos}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label for="estado">Semestre:</label>
										<div class='input-group col-lg-12'>
											<select class="form-control" name="id_semestre" id="id_semestre">
												<option value="-1">Todos</option>
												<c:forEach items="${semestres}" var="semestre">
													<option value="${semestre.idSemestre}">${semestre.ano} - ${semestre.numero}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<input type="submit" class="btn btn-primary pull-left" value="Buscar" onclick="actualizarData();">	
								</div>
							</div>
					</div>
				</div>
			</div>	
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Reporte Equipos</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="overflow-x: auto;">
							<div class="no-mostrar"><button onclick="window.print()" type="button"><i class="fa fa-file-pdf-o"> Exportar Reporte</i></button></div>
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="example">
								<thead>
									<tr>
										<th>Código</th>
										<th>Nombre</th>
										<th>Módulo sol PPI</th>
										<th>Semestre</th>
										<th>Integrantes</th>
										<th>Asesorias</th>
									</tr>
								</thead>
								<tbody>
								<%
								JSONArray equipos = (JSONArray)request.getAttribute("equipos");
								for(int i = 0; i < equipos.size(); i++){
									JSONObject equipo = (JSONObject)equipos.get(i);
								%>
								<tr>
									<td><%=equipo.get("codigo")%></td>
									<td><%=equipo.get("nombre")%></td>
									<td><%=equipo.get("asignatura")%></td>
									<td><%=equipo.get("semestre")%></td>
									<td><%=equipo.get("integrantes")%></td>
									<td><%=equipo.get("asesorias")%></td>
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
			</div>
		</form>
	</div>

</div>


<jsp:include page="footer.jsp" />
