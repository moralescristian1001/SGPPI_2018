<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Mod"%>
<%@page import="com.mybatis.models.Modulo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.mybatis.models.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="home.html">SGPPI</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li style="color:white !important">Bienvenido ${user.getNombre()}</li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="changePassword.html"><i class="fa fa-user fa-fw"></i>Cambiar Contrase&ntilde;a</a></li>
				<li class="divider"></li>
				<li><a href="logout.html"><i class="fa fa-sign-out fa-fw"></i>
						Cerrar Sesión</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<%
					Usuarios user = (Usuarios) request.getAttribute("user");
					ArrayList<Modulo> modulos = new ArrayList<Modulo>();

					ArrayList<Modulo> usuarios = new ArrayList<Modulo>();
					usuarios.add(new Modulo("Gestionar Usuarios", "users", 5, "user-plus"));
					usuarios.add(new Modulo("Gestionar Equipos de Trabajo", "team", 5, "group"));

					ArrayList<Modulo> asesorias = new ArrayList<Modulo>();
					asesorias.add(new Modulo("Agendar", "schedule", 3, "calendar-check-o"));
					asesorias.add(new Modulo("Solicitar", "request", 1, "calendar-plus-o"));
					asesorias.add(new Modulo("Seguimiento", "tracing", new int[] { 1, 3 }, "history"));

					ArrayList<Modulo> events = new ArrayList<Modulo>();
					events.add(new Modulo("Programar Evento", "social", 5, "bullhorn"));
					events.add(new Modulo("Gestionar Rúbricas", "rubric", 5, "check-square"));
					events.add(new Modulo("Gestionar Cuadrantes", "quadrant", 5, "sticky-note-o"));

					ArrayList<Modulo> reports = new ArrayList<Modulo>();
					reports.add(new Modulo("Informe Usuarios", "usersReport", 5, "user-plus"));
					reports.add(new Modulo("Informe Equipo", "teamReport", 5, "group"));
					reports.add(new Modulo("Informe Asesorias", "advisoryReport", 5, "calendar-check-o"));
					
// 					modulos.add(new Modulo("Perfiles y Seguridad", "profile", new int[] { 1, 2, 3, 4, 5 }));
					modulos.add(new Modulo("Usuarios", usuarios, 5, "user"));
					modulos.add(new Modulo("Asignaturas", "sunModule", 5, "book"));
					modulos.add(new Modulo("Asesorias", asesorias, new int[] { 1, 3 }, "calendar"));
					modulos.add(new Modulo("Informes", reports, 5, "area-chart"));
					modulos.add(new Modulo("Parametrización", events, 5, "edit"));
					modulos.add(new Modulo("Calificar", "qualify", new int[] { 2, 4 }, "check"));
					modulos.add(new Modulo("Acerca de", "aboutUs", new int[] {1, 2, 3, 4, 5}, "info-circle"));
					modulos.add(new Modulo("Ayuda", "onlineHelp", new int[] {1, 2, 3, 4, 5}, "question-circle"));
					
					final int cargo = user.getIdCargo();
					String menu = Modulo.menu(modulos, cargo);
					int i = 0;
				%>
				<%=menu%>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>