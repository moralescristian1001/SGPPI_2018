<%@page import="com.mybatis.models.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />

<div id="wrapper">

	<!-- Navigation -->
	<jsp:include page="menu.jsp"></jsp:include>

	<div id="page-wrapper">
		<div class="row">
			<div class="alert alert-danger alert-dismissible" role="alert" style="display:
			<%
			String errors = "";
			if(request.getAttribute("errors") != null){
				errors = String.valueOf(request.getAttribute("errors"));
			%>
			block;
			<%	
			}else{
			%>
			none;
			<%}%>
			"><%=errors%>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Dashboard</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-user	 fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge"><%=request.getAttribute("usuarios_creados").toString()%></div>
								<div>Usuarios activos!</div>
							</div>
						</div>
					</div>
					<a href="./userReporte.html">
						<div class="panel-footer">
							<span class="pull-left">Ver Reporte</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="panel panel-green">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-group fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge"><%=request.getAttribute("equipos_creados").toString()%></div>
								<div>Equipos Semestre Actual</div>
							</div>
						</div>
					</div>
					<a href="./teamReporte.html">
						<div class="panel-footer">
							<span class="pull-left">Ver reporte</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			
			<div class="col-lg-4 col-md-6">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-info fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge"><%=request.getAttribute("semestreActual").toString()%></div>
								<div>Semestre Actual</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

</div>
<jsp:include page="footer.jsp" />