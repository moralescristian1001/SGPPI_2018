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
				<h1 class="page-header">Reporte Usuarios</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<form id="form-editar-usuario" method="GET">
			<div class="row">
				<div class="col-lg-12 no-mostrar">
					<div class="panel panel-default">
						<div class="panel-heading">Buscar Usuario</div>
						<!-- /.panel-heading -->
						
						<div class="panel-body" style="overflow-x: auto;">
							<div class="row">
							
							
								<div class="col-sm-6">
									<div class="form-group">
										<label for="estado">*Cargo:</label>
										<div class='input-group col-lg-12'>
											<select class="form-control" name="id_cargo" id="id_cargo">
												<option value="-1">Todos</option>
												<c:forEach items="${cargos}" var="cargo">
													<option value="${cargo.idCargo}">${cargo.descripcion}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label for="estado">Estado:</label>
										<div class='input-group col-lg-12'>
											<select class="form-control" name="estado" id="estado">
												<option value="-1">Todos</option>
												<option value="1">Activo</option>
												<option value="0">Inactivo</option>
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
						<div class="panel-heading">Reporte Usuarios</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="overflow-x: auto;">
							<div class="no-mostrar"><button onclick="window.print()" type="button"><i class="fa fa-file-pdf-o"> Exportar Reporte</i></button></div>
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Usuario</th>
										<th>Nombre y Apellidos</th>
										<th>Cédula</th>
										<th>Fecha de nacimiento</th>
										<th>Cargo</th>
										<th>Asesorias</th>
										<th>Equipos</th>
										<th>Estado</th>
									</tr>
								</thead>
								<tbody>
								<%
								JSONArray usuarios = (JSONArray)request.getAttribute("usuarios");
								for(int i = 0; i < usuarios.size(); i++){
									JSONObject usuario = (JSONObject)usuarios.get(i);
								%>
								<tr>
									<td><%=usuario.get("usuario")%></td>
									<td><%=usuario.get("nombre")%></td>
									<td><%=usuario.get("cedula")%></td>
									<td><%=usuario.get("birthday")%></td>
									<td><%=usuario.get("cargo")%></td>
									<td><%=usuario.get("asesorias")%></td>
									<td><%=usuario.get("equipos")%></td>
									<td><%=usuario.get("estado")%></td>
								</tr>
								<%
								}
								%>
								</tbody>
							</table>
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

