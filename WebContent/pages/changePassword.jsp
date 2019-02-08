<%@page import="com.mybatis.models.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:include page="header.jsp" />
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>
<div id="wrapper">
	<%
	Usuarios user = (Usuarios) request.getAttribute("user");
	if(user.getCambioClave()){
	%>
	<jsp:include page="menu.jsp"></jsp:include>
	<%
	}
	%>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cambiar Contrase&ntilde;a</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="alert alert-danger" role="alert" id="errorDiv"
			style="display: none; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>

			<span class="alert-content">La contrase&ntilde;a no puede ser la misma que la anterior</span>
		</div>
		<div class="alert alert-success" role="alert" id="successDiv"
			style="display: none; width: 100%;">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<span class="alert-content">La contrase&ntilde;a ha sido cambiada satisfactoriamente</span>
		</div>
		<form>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Cambiar Contrase&ntilde;a</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-6 form-group">
									<label for="nombre">*Contrase&ntilde;a anterior:</label>
									<div class='input-group col-lg-12'>
										<input type="password" class="form-control" name="clave_anterior"
											id="clave_anterior" placeholder="Ingrese la clave anterior">
									</div>
								</div>
		
								<div class="col-sm-6 form-group">
									<label for="apellidos">*Contrase&ntilde;a nueva:</label>
									<div class='input-group col-lg-12'>
									<input type="password" class="form-control" name="clave_nueva"
											id="clave_nueva" placeholder="Ingrese la clave nueva">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3 form-group"></div>
								<div class="col-sm-6 form-group">
									<label for="apellidos">*Repetir contrase&ntilde;a nueva:</label>
										<div class='input-group col-lg-12'>
											<input type="password" class="form-control" name="clave_nueva_repetir"
												id="clave_nueva_repetir" placeholder="Ingrese la clave nueva">
										</div>
									</div>
								</div>
							</div>
							<div class="row" align="center">
								<div class="col-sm-12 form-group" align="center">
									<input type="hidden" name="cambioClave" id="cambioClave" value="<%=user.getCambioClave()%>">
									<input type="button" class="btn btn-default pull-left" name="guardar" value="Cambiar Clave" onclick="changePassword()"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>	
		</form>
	</div>
</div>	
<script src="../pagesJs/changePassword.js"></script>
<jsp:include page="footer.jsp" />