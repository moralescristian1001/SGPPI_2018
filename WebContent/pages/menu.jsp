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
		<!-- 		<li class="dropdown"><a class="dropdown-toggle" -->
		<!-- 			data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i> -->
		<!-- 				<i class="fa fa-caret-down"></i> -->
		<!-- 		</a> 			<ul class="dropdown-menu dropdown-messages"> 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<strong>John Smith</strong> <span class="pull-right text-muted"> -->
		<!-- 								<em>Yesterday</em> -->
		<!-- 							</span> -->
		<!-- 						</div> -->
		<!-- 						<div>Lorem ipsum dolor sit amet, consectetur adipiscing -->
		<!-- 							elit. Pellentesque eleifend...</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<strong>John Smith</strong> <span class="pull-right text-muted"> -->
		<!-- 								<em>Yesterday</em> -->
		<!-- 							</span> -->
		<!-- 						</div> -->
		<!-- 						<div>Lorem ipsum dolor sit amet, consectetur adipiscing -->
		<!-- 							elit. Pellentesque eleifend...</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a class="text-center" href="#"> <strong>Read -->
		<!-- 							All Messages</strong> <i class="fa fa-angle-right"></i> -->
		<!-- 				</a></li> -->
		<!-- 			</ul> /.dropdown-messages</li> -->
		<!-- 		<!-- /.dropdown -->
		<!-- 		<li class="dropdown"><a class="dropdown-toggle" -->
		<!-- 			data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i> -->
		<!-- 				<i class="fa fa-caret-down"></i> -->
		<!-- 		</a> -->
		<!-- 			<ul class="dropdown-menu dropdown-tasks"> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<p> -->
		<!-- 								<strong>Task 1</strong> <span class="pull-right text-muted">40% -->
		<!-- 									Complete</span> -->
		<!-- 							</p> -->
		<!-- 							<div class="progress progress-striped active"> -->
		<!-- 								<div class="progress-bar progress-bar-success" -->
		<!-- 									role="progressbar" aria-valuenow="40" aria-valuemin="0" -->
		<!-- 									aria-valuemax="100" style="width: 40%"> -->
		<!-- 									<span class="sr-only">40% Complete (success)</span> -->
		<!-- 								</div> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<p> -->
		<!-- 								<strong>Task 2</strong> <span class="pull-right text-muted">20% -->
		<!-- 									Complete</span> -->
		<!-- 							</p> -->
		<!-- 							<div class="progress progress-striped active"> -->
		<!-- 								<div class="progress-bar progress-bar-info" role="progressbar" -->
		<!-- 									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" -->
		<!-- 									style="width: 20%"> -->
		<!-- 									<span class="sr-only">20% Complete</span> -->
		<!-- 								</div> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<p> -->
		<!-- 								<strong>Task 3</strong> <span class="pull-right text-muted">60% -->
		<!-- 									Complete</span> -->
		<!-- 							</p> -->
		<!-- 							<div class="progress progress-striped active"> -->
		<!-- 								<div class="progress-bar progress-bar-warning" -->
		<!-- 									role="progressbar" aria-valuenow="60" aria-valuemin="0" -->
		<!-- 									aria-valuemax="100" style="width: 60%"> -->
		<!-- 									<span class="sr-only">60% Complete (warning)</span> -->
		<!-- 								</div> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<p> -->
		<!-- 								<strong>Task 4</strong> <span class="pull-right text-muted">80% -->
		<!-- 									Complete</span> -->
		<!-- 							</p> -->
		<!-- 							<div class="progress progress-striped active"> -->
		<!-- 								<div class="progress-bar progress-bar-danger" role="progressbar" -->
		<!-- 									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" -->
		<!-- 									style="width: 80%"> -->
		<!-- 									<span class="sr-only">80% Complete (danger)</span> -->
		<!-- 								</div> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a class="text-center" href="#"> <strong>See -->
		<!-- 							All Tasks</strong> <i class="fa fa-angle-right"></i> -->
		<!-- 				</a></li> -->
		<!-- 			</ul> /.dropdown-tasks</li> -->
		<!-- /.dropdown -->
		<!-- 		<li class="dropdown"><a class="dropdown-toggle" -->
		<!-- 			data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i> -->
		<!-- 				<i class="fa fa-caret-down"></i> -->
		<!-- 		</a> -->
		<!-- 			<ul class="dropdown-menu dropdown-alerts"> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<i class="fa fa-comment fa-fw"></i> New Comment <span -->
		<!-- 								class="pull-right text-muted small">4 minutes ago</span> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span -->
		<!-- 								class="pull-right text-muted small">12 minutes ago</span> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<i class="fa fa-envelope fa-fw"></i> Message Sent <span -->
		<!-- 								class="pull-right text-muted small">4 minutes ago</span> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<i class="fa fa-tasks fa-fw"></i> New Task <span -->
		<!-- 								class="pull-right text-muted small">4 minutes ago</span> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a href="#"> -->
		<!-- 						<div> -->
		<!-- 							<i class="fa fa-upload fa-fw"></i> Server Rebooted <span -->
		<!-- 								class="pull-right text-muted small">4 minutes ago</span> -->
		<!-- 						</div> -->
		<!-- 				</a></li> -->
		<!-- 				<li class="divider"></li> -->
		<!-- 				<li><a class="text-center" href="#"> <strong>See -->
		<!-- 							All Alerts</strong> <i class="fa fa-angle-right"></i> -->
		<!-- 				</a></li> -->
		<!-- 			</ul> /.dropdown-alerts</li> -->
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="profile.html"><i class="fa fa-user fa-fw"></i>Mi Perfil</a></li>
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

// 					modulos.add(new Modulo("Perfiles y Seguridad", "profile", new int[] { 1, 2, 3, 4, 5 }));
					modulos.add(new Modulo("Usuarios", usuarios, 5, "user"));
					modulos.add(new Modulo("Asignaturas", "sunModule", 5, "book"));
					modulos.add(new Modulo("Asesorias", asesorias, new int[] { 1, 3 }, "calendar"));
					modulos.add(new Modulo("Informes", "reports", 5, "area-chart"));
					modulos.add(new Modulo("Parametrización", events, 5, "edit"));
					modulos.add(new Modulo("Calificar", "qualify", new int[] { 2, 4 }, "check"));

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