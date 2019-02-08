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
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Acerca de nosotros</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<p style="font-size:15px; color: #1da1a1">
				Politécnico Jaime Isaza Cadavid  es una universidad de educación superior que gestiona operaciones educativas y relaciones con los estudiantes, docentes, coordinares y evaluadores. Mejora la experiencia en los procesos de las carreras de la  institución al condensar la información.<br>
				Cuando decimos de Sistema De Gestión Del Proyecto Pedagógico Integrador (SGPPI), lo hacemos porque tenemos razones muy potentes para ello. En su página de inicio, hay una gran cantidad de información sobre el Proyecto Pedagógico Integrador (PPI).<br>
				Pero el sitio web es diferente ya que los temas a tratar de información en el sitio se muestra en una lista con módulos alternativos que hace que sea fácil para todos los estudiantes, docentes, coordinares y evaluadores echar un vistazo a la página sin perderse en el texto. Además, el texto y los campos en sus formularios son grandes y fáciles de leer.
				<br><br><br><br>
				</p>
				<p align="center">
					Politécnico Colombiano Jaime Isaza Cadavid © 2019<br>
					Sede Medellín<br>
					Carrera 48 No. 7 – 151 | El Poblado | PBX: 444 76 54 - 319 79 00 | NIT: 890980136-6<br>
					Notificaciones Judiciales<br>
					Institución de Educación Superior de carácter pública y departamental sujeta a inspección y vigilancia por parte del Ministerio de Educación.
				</p>
			</div>			
		</div>
	</div>
</div>	
<jsp:include page="footer.jsp" />